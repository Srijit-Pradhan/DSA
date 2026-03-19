/*
========================================
🟢 Problem: Majority Element
========================================

🔹 Meaning (Problem ta ki bolche)
----------------------------------------
Tomake ekta array `nums` dewa ache jaar size holo `n`. 
Tomake emon ekta element khuje ber korte hobe jeta array te array-er half size er theke besi bar ache, mane strictly `> n/2` times present ache. 
Eke "Majority Element" bola hocche. 
Question e bole dewa ache je array te sob somoy ekta majority element thakbei, tai amader emon kono case handle korte hobe na jekhane answer nei.

Input: `nums = [2,2,1,1,1,2,2]` (size n = 7, 7/2 = 3. Mane je element 3 barer beshi ache)
Output: `2` (Karon 2 ache 4 bar, jeta > 3)

----------------------------------------

🔹 How to Approach (Kibhabe chinta korbo)
----------------------------------------
Amra 3 bhabe problem ta chinta korte pari (Interview te evabei bolbe):

1. **Brute Force (Naïve Approach):**
   Ekta element dhorbo, tarpor puro array te traverse kore check korbo seta koto bar ache. 
   - Time Complexity: O(n²) -> Onek boro array er jonno Time Limit Exceeded (TLE) khabe.

2. **Better Approach (Hashing / Sorting):**
   - *Sorting:* Array ta sort kore nile majority element obossoi middle index `(n/2)` e thakbe. Time: O(n log n), Space: O(1) / O(n) depending on sorting algo.
   - *Hashing:* Ekta HashMap e protita element er frequency count korbo. Jar count `n/2` er beshi, setai answer. Time: O(n), kintu Extra Space: O(n) lagbe.

3. **Optimal Approach (Boyer-Moore Voting Algorithm):**
   Amader follow-up e boleche Time: O(n) ar Space: O(1) e solve korte. Etai best approach.
   Ekhane amra count korbo. Dhore nebo first element tai majority. 
   - Same element pele `count++` korbo.
   - Onno element pele `count--` korbo.
   - Jodi `count == 0` hoye jay, tar mane ei element ta majority noy ba oi specific part e balance out hoye geche. Tokhon current element ke notun candidate hisabe dhore nebo ar count abar 1 kore debo.
   - Jehetu Majority element array te `n/2` er beshi thakbe, baki sob elements mileo tar count ke permanently 0 korte parbe na. Last e je `candidate` thakbe, setai answer.

----------------------------------------

🔹 Solution (Detailed Explanation)
----------------------------------------
Algorithm steps:
1. Duto variable nebo: `count = 0` ar `candidate = 0`.
2. Array er moddhe diye loop chalabo (for each loop ba normal for loop).
3. Jodi `count == 0` hoy, tahole current element ke `candidate` baniye debo.
4. Ebar check korbo jodi current element `candidate` er soman hoy tahole `count` barabo (`+1`), ar soman na hole `count` komabo (`-1`).
5. Loop sesh hole `candidate` er moddhe je value ta theke jabe, setai amader Majority Element.

**Dry Run:**
Input: `nums = [2,2,1,1,1,2,2]`
- Init: `count = 0`, `candidate = ?`
- Step 1 (num=2): `count` 0 chilo, tai `candidate = 2`. num == candidate tai `count = 1`.
- Step 2 (num=2): num == candidate (2==2), tai `count = 2`.
- Step 3 (num=1): num != candidate (1!=2), tai `count = 1`.
- Step 4 (num=1): num != candidate (1!=2), tai `count = 0`.
- Step 5 (num=1): `count` 0 chilo, tai notun `candidate = 1`. num == candidate tai `count = 1`.
- Step 6 (num=2): num != candidate (2!=1), tai `count = 0`.
- Step 7 (num=2): `count` 0 chilo, tai notun `candidate = 2`. num == candidate tai `count = 1`.
Loop sesh. Final `candidate = 2`. Etai answer!

----------------------------------------

🔹 Other Important Things
----------------------------------------
Time Complexity: 
O(n) - Karon amra puro array ta ekbar matro traverse korchi.

Space Complexity: 
O(1) - Karon amra shudhu duto variable (`count`, `candidate`) use korechi, kono extra array ba hashmap use korini.

Edge Cases:
- Single element: `[5]` -> loop ekbar cholbe, candidate 5 hobe, correctly return korbe.
- Negative values/Large values: Variable track korche tai kono problem hobe na. Integer overflow er kono bishoy nei ekhane.

----------------------------------------

🔹 Java Code (Benglish Explanation Shoho - LeetCode Version)
----------------------------------------
class Solution {
    public int majorityElement(int[] nums) {
        int count = 0;      // Counter for the current candidate
        int candidate = 0;  // Store the potential majority element

        // Array er protita element er jonno loop chalachi
        for (int num : nums) {
            // Jodi count 0 hoye jay, mane purano candidate er power sesh
            // Tai current number ke notun candidate banabo
            if (count == 0) {
                candidate = num;
            }

            // Jodi current number candidate er soman hoy, tahole vote barabo (+1)
            // Na hole vote komabo (-1)
            if (num == candidate) {
                count++;
            } else {
                count--;
            }
        }

        // Question e boleche majority element always exists, 
        // tai double verification er dorkar nei, direct return
        return candidate;
    }
}

----------------------------------------
🔹 Code Mone Rakhar Steps (Revision Trick)
----------------------------------------
1. Pattern: Boyer-Moore Voting Algorithm (Counting algorithm).
2. Observation: Majority element n/2 er theke besi ache, tai baki sob element mileo tar vote ke cancel (0) korte parbe na sesh obdi.
3. Skeleton: `for` loop chalabo puro array tay, bhetore duto if-else.
4. Logic: `count == 0` hole notun `candidate` set koro. Tarpor same element hole `count++`, nahole `count--`.
5. Edge Case: Kono edge case er thekei e atkabe na, strictly valid for guaranteed majority.

Ek line mantra:
"Count Zero hole Candidate Change → Same pele Plus → Alada pele Minus → Sesh e ja bache Tai Answer"

========================================
*/

public class MajorityElement {
    
    // Core Logic Method
    public int majorityElement(int[] nums) {
        int count = 0;
        int candidate = 0;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            if (num == candidate) {
                count++;
            } else {
                count--;
            }
        }
        return candidate;
    }

    // Main method for testing in VS Code
    public static void main(String[] args) {
        MajorityElement solution = new MajorityElement();

        // Test Case 1
        int[] nums1 = {3, 2, 3};
        System.out.println("Input: [3, 2, 3]");
        System.out.println("Majority Element: " + solution.majorityElement(nums1)); 
        // Expected Output: 3

        System.out.println("----------------------------------------");

        // Test Case 2
        int[] nums2 = {2, 2, 1, 1, 1, 2, 2};
        System.out.println("Input: [2, 2, 1, 1, 1, 2, 2]");
        System.out.println("Majority Element: " + solution.majorityElement(nums2)); 
        // Expected Output: 2
    }
}