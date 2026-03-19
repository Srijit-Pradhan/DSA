/*
========================================
🟢 Problem: Find Missing and Repeating Values
========================================

🔹 Meaning (Problem ta ki bolche)
----------------------------------------
Tomake ekta 2D grid dewa ache jar size hocche `n * n`. 
Grid er moddhe `1` theke `n^2` obdi numbers thakar kotha. 
Kintu ekta choto bhul hoyeche: ekta number duibar chole esheche (jake amra bolbo repeating number, `a`), ar sei karone arekta number harie geche (jake amra bolbo missing number, `b`).
Amader kaj holo sei repeating number `a` ar missing number `b` ke khuje ber kora ar tader ke ekta array te `[a, b]` hisabe return kora.

Input: `grid = [[1,3],[2,2]]` (ekhane `n = 2`, tai numbers thakar kotha `1` theke `4` obdi)
Output: `[2,4]` (Karon 2 duibar ache, ar 4 missing)

----------------------------------------

🔹 How to Approach (Kibhabe chinta korbo)
----------------------------------------
Problem ta mainly duto vabe solve kora jay:

1. **Brute Force (Frequency Array / Hashing):**
   Amra ekta 1D array ba HashMap nite pari jar size hobe `n^2 + 1`. Grid er sob element e traverse korbo ar tader count barabo. 
   Tarpor frequency array ta check korbo: jar count `2` seta repeating (`a`), ar jar count `0` seta missing (`b`).
   - Keno eta optimal noy? Karon ekhane amader ekta extra array nite hocche, mane Space Complexity O(n^2) lagche.

2. **Optimal Approach (Math / Equations):**
   Math use kore amra bina kono extra space e eta solve korte pari. 
   Dhoro total elements $N = n^2$.
   - Amra jani `1` theke `N` obdi numbers er sum er formula holo: $Sum = \frac{N(N+1)}{2}$
   - Ar tader squares er sum er formula holo: $SumSq = \frac{N(N+1)(2N+1)}{6}$
   
   Ebar grid er sob elements gulor actual sum ar actual square sum ber korbo.
   Dhori repeating number hocche `a` ar missing hocche `b`.
   Tahole:
   - Eq 1: `Actual Sum - Expected Sum = a - b`
   - Eq 2: `Actual Square Sum - Expected Square Sum = a^2 - b^2`
   
   Amra jani $a^2 - b^2 = (a-b)(a+b)$. 
   Tai Eq 2 ke Eq 1 diye divide korle amra `a + b` peye jabo.
   Ebar amader kache `a - b` ar `a + b` dutoi ache, eguloke solve korlei `a` ar `b` er value easily beriye asbe!

   *Khub important point:* N er max value 2500 hote pare, tai squares er sum $2500^3$ er kachakachi jabe jeta normal `int` e dhorbe na (overflow korbe). Tai amader obossoi `long` datatype use korte hobe.

----------------------------------------

🔹 Solution (Detailed Explanation)
----------------------------------------
Step by step logic flow:
1. Prothome grid er size `n` theke total numbers $N = n \times n$ ber korbo (`long` e).
2. Expected sum ar expected square sum formula use kore calculate korbo.
3. Duto nested loop chaliye grid er actual sum ar actual square sum ber korbo.
4. Diff1 = `Actual Sum - Expected Sum` jeta asole `a - b`.
5. Diff2 = `Actual Square Sum - Expected Square Sum` jeta asole $a^2 - b^2$.
6. SumAB = `Diff2 / Diff1` korle pabo `a + b`.
7. Ebar `a = (Diff1 + SumAB) / 2` ar `b = SumAB - a` kore final answer pabo.

**Dry Run:**
Input: `grid = [[1,3],[2,2]]` 
- $n = 2$, tai $N = 4$.
- Expected Sum = $4 \times 5 / 2 = 10$.
- Expected Sq Sum = $4 \times 5 \times 9 / 6 = 30$.
- Actual Sum = $1 + 3 + 2 + 2 = 8$.
- Actual Sq Sum = $1^2 + 3^2 + 2^2 + 2^2 = 1 + 9 + 4 + 4 = 18$.
- Diff1 ($a - b$) = $8 - 10 = -2$.
- Diff2 ($a^2 - b^2$) = $18 - 30 = -12$.
- SumAB ($a + b$) = Diff2 / Diff1 = $-12 / -2 = 6$.
- $a = (-2 + 6) / 2 = 4 / 2 = 2$.
- $b = 6 - 2 = 4$.
Answer `[2, 4]`. Ekdom perfectly match korche!

----------------------------------------

🔹 Other Important Things
----------------------------------------
Time Complexity:
O(n^2) - Amra grid er sob element er opor diye exactly ekbar loop chalacchi. (Grid e total element i ache n^2 ta, tai eta effectively linear in terms of total elements).

Space Complexity:
O(1) - Amra shudhu kichu math variables use korechi, kono array ba HashMap use korini. Kono extra space lagchena.

Edge Cases:
- Integer Overflow: Sobtheke boro bishoy holo sum of squares calculate korar somoy. Tai prothom thekei sob variable `long` datatype e declare kora must.

----------------------------------------

🔹 Java Code (Benglish Explanation Shoho)
----------------------------------------
class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        long n = grid.length;
        long N = n * n; // Total number of elements
        
        // 1 theke N obdi expected sum ar square sum ber korchi
        long expectedSum = (N * (N + 1)) / 2;
        long expectedSqSum = (N * (N + 1) * (2 * N + 1)) / 6;
        
        long actualSum = 0;
        long actualSqSum = 0;
        
        // Grid er vetor traverse kore actual sum ar square sum nichi
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                long val = grid[i][j];
                actualSum += val;
                actualSqSum += (val * val);
            }
        }
        
        // a - b = actualSum - expectedSum
        long diff1 = actualSum - expectedSum; 
        
        // a^2 - b^2 = actualSqSum - expectedSqSum
        long diff2 = actualSqSum - expectedSqSum; 
        
        // (a + b) = (a^2 - b^2) / (a - b)
        long sumAB = diff2 / diff1; 
        
        // a = ((a - b) + (a + b)) / 2
        int a = (int) ((diff1 + sumAB) / 2);
        
        // b = (a + b) - a
        int b = (int) (sumAB - a);
        
        // answer return korchi [repeating, missing] format e
        return new int[]{a, b}; 
    }
}

----------------------------------------
🔹 Code Mone Rakhar Steps (Revision Trick)
----------------------------------------
1. Pattern: Mathematics (Sum and Sum of Squares).
2. Observation: Actual sum ar Expected sum er difference theke amra equations banate pari. Integer overflow erate hobe (use long).
3. Skeleton: Prothome $N$ bar koro, tarpor Expected $S$ ar Expected $S_2$ bar koro. Tarpor nested loop chaliye Actual $S$ ar Actual $S_2$ bar koro.
4. Logic: Math equation solve koro `diff1 = a-b`, `diff2 = a^2-b^2`, oikhan theke `a` ar `b` find koro.
5. Edge Case: Overflow issue, tai sob variables ke `long` e cast kora.

Ek line mantra:
"Expected sum/sqSum ber koro → Actual sum/sqSum ber koro → Duto minus kore (a-b) ar (a²-b²) pao → Divide kore solve koro"

========================================
*/

public class FindMissingAndRepeatingValues {
    
    // Core Logic Method
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        long n = grid.length;
        long N = n * n;
        
        long expectedSum = (N * (N + 1)) / 2;
        long expectedSqSum = (N * (N + 1) * (2 * N + 1)) / 6;
        
        long actualSum = 0;
        long actualSqSum = 0;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                long val = grid[i][j];
                actualSum += val;
                actualSqSum += (val * val);
            }
        }
        
        long diff1 = actualSum - expectedSum; 
        long diff2 = actualSqSum - expectedSqSum; 
        
        long sumAB = diff2 / diff1; 
        
        int a = (int) ((diff1 + sumAB) / 2);
        int b = (int) (sumAB - a);
        
        return new int[]{a, b}; 
    }

    // Main method for testing in VS Code
    public static void main(String[] args) {
        FindMissingAndRepeatingValues solution = new FindMissingAndRepeatingValues();

        // Test Case 1
        int[][] grid1 = {
            {1, 3},
            {2, 2}
        };
        int[] result1 = solution.findMissingAndRepeatedValues(grid1);
        System.out.println("Input: [[1,3],[2,2]]");
        System.out.println("Output: [" + result1[0] + ", " + result1[1] + "]"); 
        // Expected Output: [2, 4]

        System.out.println("----------------------------------------");

        // Test Case 2
        int[][] grid2 = {
            {9, 1, 7},
            {8, 9, 2},
            {3, 4, 6}
        };
        int[] result2 = solution.findMissingAndRepeatedValues(grid2);
        System.out.println("Input: [[9,1,7],[8,9,2],[3,4,6]]");
        System.out.println("Output: [" + result2[0] + ", " + result2[1] + "]"); 
        // Expected Output: [9, 5]
    }
}