

// // //User function Template for Java

// // class Solution
// // {
    
// //     private int memoization(int i, int j, String s1, String s2, int[][] dp){
// //         if(i < 0 || j < 0){
// //             return 0;
// //         }
// //         if(dp[i][j] != -1){
// //             return dp[i][j];
// //         }
// //         if(s1.charAt(i) == s2.charAt(j)){
// //             return dp[i][j] = 1 + memoization(i - 1, j - 1, s1, s2, dp);
// //         }
        
// //         int backwordsIns1 = memoization(i - 1, j, s1, s2, dp);
// //         int backwordsInS2 = memoization(i, j - 1, s1, s2, dp);
// //         return dp[i][j] = Math.max(backwordsIns1,backwordsInS2);
// //     }
    
// //     public int longestPalinSubseq(String S)
// //     {
// //         int n = S.length();
// //         StringBuffer s2 = new StringBuffer(S);
// //         s2.reverse();
// //         int[][] dp = new int[n + 1][n + 1];
// //         for(int[] it : dp){
// //             Arrays.fill(it, -1);
// //         }
// //         return memoization(n - 1, n - 1, S, s2.toString(), dp);
// //     }
// // }




// class Solution
// {
    
//     public int longestPalinSubseq(String S)
//     {
//         int n = S.length();
//         StringBuffer s2 = new StringBuffer(S);
//         s2.reverse();
//         int[][] dp = new int[n + 1][n + 1];
        
//         for(int i = 1; i < n + 1; i++){
//             for(int j = 1; j < n + 1; j++){
//                 if(S.charAt(i - 1) == s2.charAt(j - 1)){
//                     dp[i][j] = 1 + dp[i - 1][j - 1];
//                 }
//                 else{
//                     int backwordsIns1 = dp[i - 1][j];
//                     int backwordsInS2 = dp[i][j - 1];
//                     dp[i][j] = Math.max(backwordsIns1,backwordsInS2); 
//                 }
//             }
//         }
//         return dp[n][n];
//     }
// }




//User function Template for Java

class Solution
{
    
    public int longestPalinSubseq(String S)
    {
        int n = S.length();
        StringBuffer s2 = new StringBuffer(S);
        s2.reverse();
        int[] prev = new int[n + 1];
        
        for(int i = 1; i < n + 1; i++){
        int curr[] = new int[n + 1];
            for(int j = 1; j < n + 1; j++){
                if(S.charAt(i - 1) == s2.charAt(j - 1)){
                    curr[j] = 1 + prev[j - 1];
                }
                else{
                    int backwordsIns1 = prev[j];
                    int backwordsInS2 = curr[j - 1];
                    curr[j] = Math.max(backwordsIns1,backwordsInS2); 
                }
            }
            prev = curr;
        }
        return prev[n];
    }
}