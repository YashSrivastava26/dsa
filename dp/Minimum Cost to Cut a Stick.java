import java.util.*;
// class Solution {

//     int tryAllCutCombo(int left, int right, int[] cuts, int[][] dp){

//         if(left > right){
//             return 0;
//         }
        
//         if(dp[left][right] != -1){
//             return dp[left][right];
//         }

//         int n = cuts.length, len = cuts[right +  1] - cuts[left - 1];
//         int mini = Integer.MAX_VALUE;
//         for(int i = left; i <= right; i++){
//             int curr = len + tryAllCutCombo(left, i - 1, cuts, dp) + tryAllCutCombo(i + 1, right, cuts, dp);
//             mini = Math.min(curr, mini);
//         }
//         return dp[left][right] = mini;
//     }

//     public int minCost(int n, int[] cuts) {
//         int m = cuts.length;
//         int cutClone[] = new int[m + 2];
//         for(int i = 0; i < m; i++){
//             cutClone[i] = cuts[i];
//         }
//         cutClone[m] = 0;
//         cutClone[m + 1] = n;
//         Arrays.sort(cutClone);
//         int dp[][] = new int[m + 1][m + 1];
//         for(int[] it : dp){
//             Arrays.fill(it, -1);
//         }
//         return tryAllCutCombo(1, m, cutClone, dp);
//     }
// }


class Solution {

    public int minCost(int n, int[] cuts) {
        int m = cuts.length;
        int cutClone[] = new int[m + 2];

        for(int i = 0; i < m; i++){
            cutClone[i] = cuts[i];
        }
        cutClone[m] = 0;
        cutClone[m + 1] = n;
        Arrays.sort(cutClone);

        int dp[][] = new int[m + 2][m + 2];
        for(int left = m; left > 0; left--){
            for(int right = left; right <= m; right++){
                int mini = Integer.MAX_VALUE;
                for(int i = left; i <= right; i++){
                    int curr = (cutClone[right +  1] - cutClone[left - 1]) + dp[left][i - 1] + dp[i + 1][right];
                    mini = Math.min(curr, mini);
                }
                // System.out.println(mini);
                dp[left][right] = mini;
            }
        }
        return dp[1][m];
    }
}