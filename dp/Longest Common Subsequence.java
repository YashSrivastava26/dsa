import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;


//recursion
// class Solution
// {
//     static int longestCommonSubseq(String s1, String s2, int ptr1, int ptr2){
//         if(ptr1 < 0 || ptr2 < 0) return 0;
        
//         int currLen = 0;
//         if(s1.charAt(ptr1) == s2.charAt(ptr2)){
//             currLen = 1 + longestCommonSubseq(s1, s2, ptr1 - 1, ptr2 - 1);
//         }
//         else{
//             int reduceS1 = longestCommonSubseq(s1, s2, ptr1 - 1, ptr2);
//             int reduceS2 = longestCommonSubseq(s1, s2, ptr1, ptr2 - 1);
//             currLen = Math.max(reduceS1, reduceS2);
//         }
//         return currLen;
//     }

//     //Function to find the length of longest common subsequence in two strings.
//     static int lcs(int x, int y, String s1, String s2)
//     {
//         return longestCommonSubseq(s1, s2, x - 1, y - 1);
//     }
    
// }

//memoization
// class Solution
// {
//     static int longestCommonSubseq(String s1, String s2, int ptr1, int ptr2, int[][] dp){
//         if(ptr1 < 0 || ptr2 < 0) return 0;

//         if(dp[ptr1][ptr2] != -1) return dp[ptr1][ptr2];
        
//         int currLen = 0;
//         if(s1.charAt(ptr1) == s2.charAt(ptr2)){
//             currLen = 1 + longestCommonSubseq(s1, s2, ptr1 - 1, ptr2 - 1, dp);
//         }
//         else{
//             int reduceS1 = longestCommonSubseq(s1, s2, ptr1 - 1, ptr2, dp);
//             int reduceS2 = longestCommonSubseq(s1, s2, ptr1, ptr2 - 1, dp);
//             currLen = Math.max(reduceS1, reduceS2);
//         }
//         return dp[ptr1][ptr2] = currLen;
//     }

//     //Function to find the length of longest common subsequence in two strings.
//     static int lcs(int x, int y, String s1, String s2)
//     {
//         int dp[][] = new int[x][y];
//         for (int[] is : dp) {
//             Arrays.fill(is, -1);
//         }
//         return longestCommonSubseq(s1, s2, x - 1, y - 1, dp);
//     }
    
// }

//shifting idx to right by 1
// class Solution
// {
//     static int longestCommonSubseq(String s1, String s2, int ptr1, int ptr2, int[][] dp){
//         if(ptr1 == 0 || ptr2 == 0) return 0;

//         if(dp[ptr1][ptr2] != -1) return dp[ptr1][ptr2];
        
//         int currLen = 0;
//         if(s1.charAt(ptr1 - 1) == s2.charAt(ptr2 - 1)){
//             currLen = 1 + longestCommonSubseq(s1, s2, ptr1 - 1, ptr2 - 1, dp);
//         }
//         else{
//             int reduceS1 = longestCommonSubseq(s1, s2, ptr1 - 1, ptr2, dp);
//             int reduceS2 = longestCommonSubseq(s1, s2, ptr1, ptr2 - 1, dp);
//             currLen = Math.max(reduceS1, reduceS2);
//         }
//         return dp[ptr1][ptr2] = currLen;
//     }

//     //Function to find the length of longest common subsequence in two strings.
//     static int lcs(int x, int y, String s1, String s2)
//     {
//         int dp[][] = new int[x + 1][y + 1];
//         for (int[] is : dp) {
//             Arrays.fill(is, -1);
//         }
//         return longestCommonSubseq(s1, s2, x, y, dp);
//     }
    
// }


//tabulation
// class Solution
// {

//     //Function to find the length of longest common subsequence in two strings.
//     static int lcs(int x, int y, String s1, String s2)
//     {
//         int dp[][] = new int[x + 1][y + 1];
//          //you can ommit this 2 for loop as in java it is already initilize to 0
//         for (int i = 0; i < x + 1; i++) {
//             dp[i][0] = 0;
//         }
//         for (int i = 0; i < y + 1; i++) {
//             dp[0][i] = 0;
//         }
//         for (int ptr1 = 1; ptr1 < x + 1; ptr1++) {
//             for (int ptr2 = 1; ptr2 < y + 1; ptr2++) {
//                 int currLen = 0;
//                 if(s1.charAt(ptr1 - 1) == s2.charAt(ptr2 - 1)){
//                     currLen = 1 + dp[ptr1 - 1][ptr2 - 1];
//                 }
//                 else{
//                     int reduceS1 = dp[ptr1 - 1][ptr2];
//                     int reduceS2 = dp[ptr1][ptr2 - 1];
//                     currLen = Math.max(reduceS1, reduceS2);
//                 }
//                 dp[ptr1][ptr2] = currLen;
//             }
//         }

//         return dp[x][y];
//     }
    
// }


//Space optimization
class Solution
{

    //Function to find the length of longest common subsequence in two strings.
    static int lcs(int x, int y, String s1, String s2)
    {
        int prev[] = new int[y + 1];
        
        
        for (int ptr1 = 1; ptr1 < x + 1; ptr1++) {
            int curr[] = new int[y + 1];
            for (int ptr2 = 1; ptr2 < y + 1; ptr2++) {
                if(s1.charAt(ptr1 - 1) == s2.charAt(ptr2 - 1)){
                    curr[ptr2] = 1 + prev[ptr2 - 1];
                }
                else{
                    int reduceS1 = prev[ptr2];
                    int reduceS2 = curr[ptr2 - 1];
                    curr[ptr2] = Math.max(reduceS1, reduceS2);
                }
            }
            prev = curr;
        }

        return prev[y];
    }
    
}