// // // // class Solution {

// // // //     private int doingAllComparision(int i, int j, String s, String t, int[][] dp){
// // // //         if(j < 0){
// // // //             return 1;
// // // //         }
// // // //         if(i < 0){
// // // //             return 0;
// // // //         }
// // // //         if(dp[i][j] != -1){
// // // //             return dp[i][j];
// // // //         }
// // // //         int take = 0;
// // // //         if(s.charAt(i) == t.charAt(j)){
// // // //             take = doingAllComparision(i - 1, j - 1, s, t, dp);
// // // //         }
// // // //         int notTake = doingAllComparision(i - 1, j, s, t, dp);

// // // //         return dp[i][j] = take + notTake;
// // // //     }

// // // //     public int numDistinct(String s, String t) {
// // // //         int n = s.length(), m = t.length();
// // // //         int dp[][] = new int[n][m];
// // // //         for(int[] it : dp){
// // // //             Arrays.fill(it, -1);
// // // //         }
// // // //         return doingAllComparision(n - 1, m - 1, s, t, dp);
// // // //     }
// // // // }

// // // class Solution {

// // //     public int numDistinct(String s, String t) {
// // //         int n = s.length(), m = t.length();
// // //         int dp[][] = new int[n + 1][m + 1];
// // //         for(int i = 0; i < n + 1; i++){
// // //             dp[i][0] = 1;
// // //         }

// // //         for(int i = 1; i < n + 1; i++){
// // //             for(int j = 1; j < m + 1; j++){
// // //                 int same = 0;
// // //                 if(s.charAt(i - 1) == t.charAt(j - 1)){
// // //                     same = dp[i - 1][j - 1];
// // //                 }
// // //                 int ignore = dp[i - 1][j];

// // //                 dp[i][j] = same + ignore;
// // //             }
// // //         }
// // //         return dp[n][m];
// // //     }
// // // }

// // class Solution {

// //     public int numDistinct(String s, String t) {
// //         int n = s.length(), m = t.length();
// //         int prev[] = new int[m + 1];
// //         prev[0] = 1;

// //         for(int i = 1; i < n + 1; i++){
// //             int curr[] = new int[m + 1];
// //             curr[0] = 1;
// //             for(int j = 1; j < m + 1; j++){
// //                 int same = 0;
// //                 if(s.charAt(i - 1) == t.charAt(j - 1)){
// //                     same = prev[j - 1];
// //                 }
// //                 int ignore = prev[j];

// //                 curr[j] = same + ignore;
// //             }
// //             prev = curr;
// //         }
// //         return prev[m];
// //     }
// // }

// class Solution {

//     public int numDistinct(String s, String t) {
//         int n = s.length(), m = t.length();
//         int prev[] = new int[m + 1];
//         prev[0] = 1;

//         for(int i = 1; i < n + 1; i++){
//             for(int j = m; j > 0; j--){
//                 int same = 0;
//                 if(s.charAt(i - 1) == t.charAt(j - 1)){
//                     same = prev[j - 1];
//                 }
//                 int ignore = prev[j];

//                 prev[j] = same + ignore;
//             }
//         }
//         return prev[m];
//     }
// }

class Solution {

    public int numDistinct(String s, String t) {
        int n = s.length(), m = t.length();
        int prev[] = new int[m + 1];
        prev[0] = 1;

        for(int i = 1; i < n + 1; i++){
            for(int j = m; j > 0; j--){
                if(s.charAt(i - 1) == t.charAt(j - 1)){
                    prev[j] = prev[j - 1] + prev[j];
                }
            }
        }
        return prev[m];
    }
}