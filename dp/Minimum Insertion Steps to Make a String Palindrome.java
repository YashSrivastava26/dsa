// // class Solution {

// //     int findLPS(int i, int j, String s, String rev, int[][] dp){
// //         if(i < 0 || j < 0){
// //             return 0;
// //         }
// //         if(dp[i][j] != -1){
// //             return dp[i][j];
// //         }

// //         if(s.charAt(i) == rev.charAt(j)){
// //             return dp[i][j] = 1 + findLPS(i - 1, j - 1, s, rev, dp);
// //         }
// //         else{
// //             int moveInS = findLPS(i - 1, j, s, rev, dp);
// //             int moveInRev = findLPS(i, j - 1, s, rev, dp);

// //             return dp[i][j] = Math.max(moveInS, moveInRev);
// //         }
// //     }

// //     public int minInsertions(String s) {
// //         int n = s.length();
// //         String rev = new StringBuffer(s).reverse().toString();
// //         int[][] dp = new int[n][n];
// //         for(int[] it : dp){
// //             Arrays.fill(it, -1);
// //         }
// //         int lpsLen = findLPS(n - 1, n - 1, s, rev, dp);
// //         return n - lpsLen;
// //     }
// // }


// class Solution {

//     public int minInsertions(String s) {
//         int n = s.length();
//         String rev = new StringBuffer(s).reverse().toString();
//         int[][] dp = new int[n + 1][n + 1];

//         for(int i = 1; i < n + 1; i++){
//             for(int j = 1; j < n + 1; j++){
//                 if(s.charAt(i - 1) == rev.charAt(j - 1)){
//                     dp[i][j] = 1 + dp[i - 1][j - 1];
//                 }
//                 else{
//                     dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
//                 }
//             }
//         }

//         return n - dp[n][n];
//     }
// }

class Solution {

    public int minInsertions(String s) {
        int n = s.length();
        String rev = new StringBuffer(s).reverse().toString();
        int[] prev = new int[n + 1];

        for(int i = 1; i < n + 1; i++){
            int[] curr = new int[n + 1];
            for(int j = 1; j < n + 1; j++){
                if(s.charAt(i - 1) == rev.charAt(j - 1)){
                    curr[j] = 1 + prev[j - 1];
                }
                else{
                    curr[j] = Math.max(prev[j], curr[j - 1]);
                }
            }
            prev = curr;
        }

        return n - prev[n];
    }
}