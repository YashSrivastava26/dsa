import java.util.*;
// class Solution {
    
//     private static int memoization(int row, int col, int n, ArrayList<ArrayList<Integer>> grid, int dp[][]){
//         if(row == n - 1){
//             return grid.get(row).get(col);  
//         }
        
//         if(dp[row][col] != -1){
//             return dp[row][col];
//         }
        
//         int down = memoization(row + 1, col, n, grid, dp);
//         int downNext = memoization(row + 1, col + 1, n, grid, dp);
        
//         return dp[row][col] = grid.get(row).get(col) + Math.min(down, downNext);
//     }
    
//     public static int minimizeSum(int n, ArrayList<ArrayList<Integer> >grid) {
//         int dp[][] = new int[n][n];
//         for(int[] row : dp){
//             Arrays.fill(row, -1);
//         }
//         return memoization(0, 0, n, grid, dp);
//     }
// }



// class Solution {
//     public static int minimizeSum(int n, ArrayList<ArrayList<Integer> >grid) {
//         int dp[][] = new int[n][n];
        
//         for(int i = 0; i < n; i++){
//             dp[n - 1][i] = grid.get(n - 1).get(i);
//         }
        
//         for(int row = n - 2; row >= 0; row--){
//             for(int col = 0; col <= row; col++){
//                 int down = dp[row + 1][col];
//                 int downNext = dp[row + 1][col + 1];
        
//                 dp[row][col] = grid.get(row).get(col) + Math.min(down, downNext);
//             }
//         }
        
//         return dp[0][0];
//     }
// }

class Solution {
    public static int minimizeSum(int n, ArrayList<ArrayList<Integer> >grid) {
        int prev[] = new int[n];
        
        for(int i = 0; i < n; i++){
            prev[i] = grid.get(n - 1).get(i);
        }
        
        for(int row = n - 2; row >= 0; row--){
            int curr[] = new int[row + 1];
            for(int col = 0; col <= row; col++){
                int down = prev[col];
                int downNext = prev[col + 1];
        
                curr[col] = grid.get(row).get(col) + Math.min(down, downNext);
            }
            prev = curr;
        }
        
        return prev[0];
    }
}