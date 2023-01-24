// // // class Solution {

// // //     private int minDistByRecursion(int i, int j, String word1, String word2, int[][] dp){
        
// // //         if(j < 0){
// // //             return i + 1;
// // //         }
// // //         if(i < 0){
// // //             return j + 1;
// // //         }

// // //         if(dp[i][j] != -1){
// // //             return dp[i][j];
// // //         }
// // //         // System.out.println(i + " " + word1.charAt(i) +  " " + j + " " + word2.charAt(j));
// // //         if(word1.charAt(i) == word2.charAt(j)){
// // //             return dp[i][j] = minDistByRecursion(i - 1, j - 1, word1, word2, dp);
// // //         }

// // //         int insert = 1 + minDistByRecursion(i, j - 1, word1, word2, dp);
// // //         int remove = 1 + minDistByRecursion(i - 1, j, word1, word2, dp);
// // //         int replace = 1 + minDistByRecursion(i - 1, j - 1, word1, word2, dp);
// // //         return dp[i][j] = Math.min(insert, Math.min(remove, replace));
// // //     }

// // //     public int minDistance(String word1, String word2) {
// // //         int n = word1.length(), m = word2.length();
// // //         int dp[][] = new int[n][m];
// // //         for(int[] it : dp){
// // //             Arrays.fill(it, -1);
// // //         }
// // //         return minDistByRecursion(n - 1, m - 1, word1, word2, dp);
// // //     }
// // // }

// // class Solution {

// //     private int minDistByRecursion(int i, int j, String word1, String word2, int[][] dp){
        
// //         if(j == 0){
// //             return i;
// //         }
// //         if(i == 0){
// //             return j;
// //         }

// //         if(dp[i][j] != -1){
// //             return dp[i][j];
// //         }
// //         // System.out.println(i + " " + word1.charAt(i) +  " " + j + " " + word2.charAt(j));
// //         if(word1.charAt(i - 1) == word2.charAt(j - 1)){
// //             return dp[i][j] = minDistByRecursion(i - 1, j - 1, word1, word2, dp);
// //         }

// //         int insert = 1 + minDistByRecursion(i, j - 1, word1, word2, dp);
// //         int remove = 1 + minDistByRecursion(i - 1, j, word1, word2, dp);
// //         int replace = 1 + minDistByRecursion(i - 1, j - 1, word1, word2, dp);
// //         return dp[i][j] = Math.min(insert, Math.min(remove, replace));
// //     }

// //     public int minDistance(String word1, String word2) {
// //         int n = word1.length(), m = word2.length();
// //         int dp[][] = new int[n + 1][m + 1];
// //         for(int[] it : dp){
// //             Arrays.fill(it, -1);
// //         }
// //         return minDistByRecursion(n, m, word1, word2, dp);
// //     }
// // }

// class Solution {
//     public int minDistance(String word1, String word2) {
//         int n = word1.length(), m = word2.length();
//         int dp[][] = new int[n + 1][m + 1];
//         for(int i = 0; i < n + 1; i++){
//             dp[i][0] = i;
//         }
//         for(int i = 0; i < m + 1; i++){
//             dp[0][i] = i;
//         }


//         for(int i = 1; i < n + 1; i++){
//             for(int j = 1; j < m + 1; j++){
//                 if(word1.charAt(i - 1) == word2.charAt(j - 1)){
//                     dp[i][j] = dp[i - 1][j - 1];
//                 }
//                 else{
//                     int insert = 1 + dp[i][j - 1];
//                     int remove = 1 + dp[i - 1][j];
//                     int replace = 1 + dp[i - 1][j - 1];
//                     dp[i][j] = Math.min(insert, Math.min(remove, replace));
//                 }
//             }
//         }
//         return dp[n][m];
//     }
// }

class Solution {     

    public int minDistance(String word1, String word2) {
        int n = word1.length(), m = word2.length();
        int prev[] = new int[m + 1];
        for(int i = 0; i < m + 1; i++){
            prev[i] = i;
        }


        for(int i = 1; i < n + 1; i++){
            int curr[] = new int[m + 1];
            curr[0] = i;
            for(int j = 1; j < m + 1; j++){
                if(word1.charAt(i - 1) == word2.charAt(j - 1)){
                    curr[j] = prev[j - 1];
                }
                else{
                    curr[j] = 1 + Math.min(curr[j - 1], Math.min(prev[j], prev[j - 1]));
                }
            }
            prev = curr;
        }
        return prev[m];
    }
}