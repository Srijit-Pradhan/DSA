/*
🟢 Problem: Merge Sorted Array
🔹 Meaning (Problem ta ki bolche)
Ekhane duti sorted (choto theke boro sajano) array dewa ache: nums1 ar nums2.
Amader ke array dutoke merge kore ekta single sorted array te porinoto korte hobe.
Kintu notun kono array return kora jabe na, jaha korar nums1 er bhitor ei korte hobe (in-place).

Tai nums1 er size age thekei ektu boro kore dewa ache. nums1 er ashol element ache m ta, ar baki n ta jaigai 0 bosiye faka rakha ache, jate nums2 er n ta element ke or bhitor dhokano jay.
Output e kichu return korte hobe na, shudhu nums1 ke update kore dilei hobe.

🔹 How to Approach (Kibhabe chinta korbo)
Prothome brute force idea:
Sobcheye sohoj upay holo, nums2 er shob element gulo ke nums1 er last er faka jayga (0 gulo) te copy kore dewa. Tarpor nums1 ke Arrays.sort() kore dewa.
Kintu etar Time Complexity hobe O((m+n) log(m+n)), jeta optimal na. Interviewer etate khushi hobe na.

Optimal Approach (Three Pointers from the END):
Aamra jodi samne theke (index 0) merge kora shuru kori, tahole nums1 er ashol data gulo overwrite (muche) jabe.
Tai aamra pichon theke (end theke) kaj shuru korbo. Karon nums1 er pichon dik ta faka (0 dewa ache).

Ekta pointer rakhibo nums1 er ashol data-r ekdom seshe (i = m - 1).

Arekta pointer rakhibo nums2 er ekdom seshe (j = n - 1).

Ar ekta main pointer thakbe nums1 er ekdom last index e (k = m + n - 1), jekhan theke amra final sorted data boshabo.

Ebar i ar j er moddhe jar value boro hobe, take k number index e bosiye pichone ghotabo.

🔹 Solution (Detailed Explanation)
Step by step:

i = m - 1, j = n - 1, k = m + n - 1 set korbo.

Ekta while loop chalabo jotokhon na i ba j kono ekta sesh hoy (i >= 0 && j >= 0).

Jodi nums1[i] > nums2[j] hoy, tahole nums1[k] = nums1[i], ar i o k ke komabo (i--, k--).

Nahole (mane nums2[j] boro ba soman hole), nums1[k] = nums2[j], ar j o k ke komabo (j--, k--).

Loop sesh hole, jodi nums2 te ekhono kichu element baki thake (j >= 0), taderke nums1 e bosiye debo.
(Note: nums1 e jodi kichu baki thake (i >= 0), tader ke ar soranor dorkar nai karon tara already nijeeder thik jaygatei ache.)

Dry Run (Example 1):
nums1 = [1,2,3,0,0,0], m = 3
nums2 = [2,5,6], n = 3

Initial: i = 2 (value 3), j = 2 (value 6), k = 5 (last position)

3 ar 6 er moddhe 6 boro. So, nums1[5] = 6. (j--, k--) -> j=1, k=4

3 ar 5 er moddhe 5 boro. So, nums1[4] = 5. (j--, k--) -> j=0, k=3

3 ar 2 er moddhe 3 boro. So, nums1[3] = 3. (i--, k--) -> i=1, k=2

2 ar 2 soman. Else block cholbe, nums1[2] = 2. (j--, k--) -> j=-1, k=1
j < 0 hoye geche, tai loop sesh. nums1 ekhon [1,2,2,3,5,6]. Result solved!

🔹 Other Important Things
Time Complexity:
O(m + n) -> Amra maximum (m+n) bar ekta loop chalachhi. Protita element ekbar korei visit hochhe. Tai linear time.

Space Complexity:
O(1) -> Amra kono extra array use korchi na. Just 3 te variable (pointer) use korchi. In-place merge hochhe.

Edge Cases:

m = 0 (nums1 e kono ashol element nei): Shudhu nums2 er sob element nums1 e copy hoye jabe. Loop properly handle korbe.

n = 0 (nums2 te kono element nei): Main loop e dhukbei na, ar nums1 jemon chilo temoni thakbe. Correct ans.

🔹 Java Code (LeetCode Version)
class Solution {
public void merge(int[] nums1, int m, int[] nums2, int n) {
int i = m - 1;       // nums1 er ashol data-r last index
int j = n - 1;       // nums2 er last index
int k = m + n - 1;   // nums1 er final merged data rakhabar last index

    // Jotokhon duto array tei element ache
    while (i >= 0 && j >= 0) {
        // Jeta boro seta nums1 er pichon theke boshabo
        if (nums1[i] > nums2[j]) {
            nums1[k] = nums1[i]; // nums1 er element ta boro, tai setake pichone bosholam
            i--;                 // i pointer ta ek ghor bame soralam
        } else {
            nums1[k] = nums2[j]; // nums2 er element ta boro (ba soman), take bosholam
            j--;                 // j pointer ta ek ghor bame soralam
        }
        k--;                     // main pointer always ek ghor bame sorbe
    }

    // Jodi nums2 te ekhono kichu data baki thake (mane nums1 er sob data agei sesh hoye geche)
    // Tahole seguloke exactly nums1 er samne bosiye debo
    while (j >= 0) {
        nums1[k] = nums2[j];
        j--;
        k--;
    }
    
    // nums1 e element baki thakle kichu korar dorkar nai, karon tara already thik jaigai ache
}
}

🔹 Code Mone Rakhar Steps (Revision Trick)
Pattern: Three Pointers (From End)

Observation: Samne theke merge korle data overwrite hobe, tai pichon (end) theke merge kora smart approach.

Skeleton: i = m-1, j = n-1, k = m+n-1, ebar while(i>=0 && j>=0)

Logic: Boro element k khuje pichone boshao, ar last e leftover nums2 elements copy kore dao.

Mantra: "End theke shuru → Compare koro → Boro take pichone boshao → Baki nums2 copy koro"
========================================
*/

import java.util.Arrays;

public class MergeSortedArray {

// Etai ashol logic jeta LeetCode e submit korte hobe
public static void merge(int[] nums1, int m, int[] nums2, int n) {
    int i = m - 1;       // nums1 er ashol data-r last index
    int j = n - 1;       // nums2 er last index
    int k = m + n - 1;   // nums1 er merged data rakhabar last index

    // Jotokhon duto array tei checking baki
    while (i >= 0 && j >= 0) {
        if (nums1[i] > nums2[j]) {
            nums1[k] = nums1[i]; // nums1 er element boro hole setake place korchi
            i--;
        } else {
            nums1[k] = nums2[j]; // nums2 er element boro ba soman hole setake place korchi
            j--;
        }
        k--; // Main placing pointer ek ghor komlo
    }

    // Leftover checking for nums2
    while (j >= 0) {
        nums1[k] = nums2[j];
        j--;
        k--;
    }
}

// VS Code e run korar jonno ar test korar jonno main method
public static void main(String[] args) {
    // Example 1 Test
    int[] nums1_1 = {1, 2, 3, 0, 0, 0};
    int m1 = 3;
    int[] nums2_1 = {2, 5, 6};
    int n1 = 3;
    merge(nums1_1, m1, nums2_1, n1);
    System.out.println("Test 1 Result: " + Arrays.toString(nums1_1)); 
    // Expected: [1, 2, 2, 3, 5, 6]

    // Example 2 Test
    int[] nums1_2 = {1};
    int m2 = 1;
    int[] nums2_2 = {};
    int n2 = 0;
    merge(nums1_2, m2, nums2_2, n2);
    System.out.println("Test 2 Result: " + Arrays.toString(nums1_2)); 
    // Expected: [1]

    // Example 3 Test
    int[] nums1_3 = {0};
    int m3 = 0;
    int[] nums2_3 = {1};
    int n3 = 1;
    merge(nums1_3, m3, nums2_3, n3);
    System.out.println("Test 3 Result: " + Arrays.toString(nums1_3)); 
    // Expected: [1]
}
}