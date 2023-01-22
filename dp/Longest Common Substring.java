// class Solution{
    
//     int longestCommonSubstr(String S1, String S2, int n, int m){
//         int ans = 0;
//         for (int i=0;i<n;i++){
//             for (int j =0;j<m;j++){
//                 int k = 0;
//                 while ((i + k) < n && (j + k) < m && S1.charAt(i + k) == S2.charAt(j + k)){
//                     k = k + 1;
//                 }

//                 ans = Math.max(ans, k);
//             }
//         }
//         return ans;
//     }
// }

class Solution{
    
    int longestCommonSubstr(String S1, String S2, int n, int m){
        int dp[][] = new int[n + 1][m + 1];
        
        int ans = Integer.MIN_VALUE;
        for(int i = 1; i < n + 1; i++){
            for(int j = 1; j < m + 1; j++){
                
                if(S1.charAt(i - 1) == S2.charAt(j - 1)){
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                }
                ans = Math.max(ans, dp[i][j]);
            }
        }
        return ans;
    }
}