// // // class Solution {

// // //     private boolean doAllMatching(int i, int j, String s, String p, Boolean[][] dp){

// // //         if(i < 0 && j < 0){
// // //             return true;
// // //         }
// // //         if(j < 0){
// // //             return false;
// // //         }
        
// // //         if(i < 0){
// // //             while(j >= 0){
// // //                 if(p.charAt(j) != '*'){
// // //                     return false;
// // //                 }
// // //                 j--;
// // //             }
// // //             return true;
// // //         }

// // //         if(dp[i][j] != null){
// // //             return dp[i][j];
// // //         }
// // //         if(p.charAt(j) == '*'){
// // //             boolean lenZero = doAllMatching(i - 1, j, s, p, dp);
// // //             boolean notZero = doAllMatching(i, j - 1, s, p, dp);
// // //             return dp[i][j] = lenZero || notZero;
// // //         }
// // //         else if(p.charAt(j) == '?' || s.charAt(i) == p.charAt(j)){
// // //             return dp[i][j] = doAllMatching(i - 1, j - 1, s, p, dp);
// // //         }

// // //         return dp[i][j] = false;

// // //     }

// // //     public boolean isMatch(String s, String p) {
// // //         int n = s.length(), m = p.length();
// // //         Boolean dp[][] = new Boolean[n][m];
// // //         for(Boolean[] it : dp){
// // //             Arrays.fill(it, null);
// // //         }
// // //         return doAllMatching(n - 1, m - 1, s, p, dp);
// // //     }
// // // }


// // class Solution {

// //     private boolean doAllMatching(int i, int j, String s, String p, Boolean[][] dp){

// //         if(i == 0 && j == 0){
// //             return true;
// //         }
// //         if(j == 0){
// //             return false;
// //         }
        
// //         if(i == 0){
// //             while(j > 0){
// //                 if(p.charAt(j - 1) != '*'){
// //                     return false;
// //                 }
// //                 j--;
// //             }
// //             return true;
// //         }

// //         if(dp[i][j] != null){
// //             return dp[i][j];
// //         }
// //         if(p.charAt(j - 1) == '*'){
// //             boolean lenZero = doAllMatching(i - 1, j, s, p, dp);
// //             boolean notZero = doAllMatching(i, j - 1, s, p, dp);
// //             return dp[i][j] = lenZero || notZero;
// //         }
// //         else if(p.charAt(j - 1) == '?' || s.charAt(i - 1) == p.charAt(j - 1)){
// //             return dp[i][j] = doAllMatching(i - 1, j - 1, s, p, dp);
// //         }

// //         return dp[i][j] = false;

// //     }

// //     public boolean isMatch(String s, String p) {
// //         int n = s.length(), m = p.length();
// //         Boolean dp[][] = new Boolean[n + 1][m + 1];
// //         for(Boolean[] it : dp){
// //             Arrays.fill(it, null);
// //         }
// //         return doAllMatching(n, m, s, p, dp);
// //     }
// // }

// class Solution {

//     public boolean isMatch(String s, String p) {
//         int n = s.length(), m = p.length();
//         boolean dp[][] = new boolean[n + 1][m + 1];
//         dp[0][0] = true;

//         for(int j = 1; j < m + 1; j++){
//             if(p.charAt(j - 1) == '*'){
//                 dp[0][j] = true;
//             }
//             else{
//                 break;
//             }
//         }

//         for(int i = 1; i < n + 1; i++){
//             for(int j = 1; j < m + 1; j++){
//                 if(p.charAt(j - 1) == '*'){
//                     dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
//                 }
//                 else if(p.charAt(j - 1) == '?' || s.charAt(i - 1) == p.charAt(j - 1)){
//                     dp[i][j] = dp[i - 1][j - 1];
//                 }

//                 else{
//                     dp[i][j] = false;
//                 }
//             }
//         }

//         return dp[n][m];
//     }
// }

class Solution {

    public boolean isMatch(String s, String p) {
        int n = s.length(), m = p.length();
        boolean prev[] = new boolean[m + 1];
        prev[0] = true;

        for(int j = 1; j < m + 1; j++){
            if(p.charAt(j - 1) == '*'){
                prev[j] = true;
            }
            else{
                break;
            }
        }

        for(int i = 1; i < n + 1; i++){
            boolean curr[] = new boolean[m + 1];
            for(int j = 1; j < m + 1; j++){
                if(p.charAt(j - 1) == '?' || s.charAt(i - 1) == p.charAt(j - 1)){
                    curr[j] = prev[j - 1];
                }
                else if(p.charAt(j - 1) == '*'){
                    curr[j] = prev[j] || curr[j - 1];
                }

                else{
                    curr[j] = false;
                }
            }
            prev = curr;
        }

        return prev[m];
    }
}