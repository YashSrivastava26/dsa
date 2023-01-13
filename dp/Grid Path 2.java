// class Solution {
    
//     private int memoization(int row, int col, int[][] grid, int[][] dp){
//         int mod = (int) (1e9 + 7);
//         if(row == 0 && col == 0){
//             return 1;
//         }
        
//         if(dp[row][col] != -1){
//             return dp[row][col];
//         }
        
//         int left = 0, up = 0;
//         if(row != 0 && grid[row - 1][col] != 1){
//             left = memoization(row - 1, col, grid, dp);
//         }
        
//         if(col != 0 && grid[row][col - 1] != 1){
//             up = memoization(row, col - 1, grid, dp);
//         }
        
//         return dp[row][col] = (left + up) % mod;
//     }
    
//     public int totalWays(int N, int M, int grid[][]) {
//         if(grid[0][0] == 1 || grid[N - 1][M - 1] == 1){
//             return 0;
//         }
//         int[][] dp =  new int[N][M];
//         for(int[] row : dp){
//             Arrays.fill(row, -1);
//         }
        
//         return memoization(N - 1, M - 1, grid, dp);
//     }
// }


// class Solution {
    
//     public int totalWays(int N, int M, int grid[][]) {
//         if(grid[0][0] == 1 || grid[N - 1][M - 1] == 1){
//             return 0;
//         }
//         int[][] dp =  new int[N][M];
        
//         for(int i = 0; i < N; i++){
//             dp[i][0] = grid[i][0] == 1 ? 0 : 1;
//         }
        
//         for(int i = 0; i < M; i++){
//             dp[0][i] = grid[0][i] == 1 ? 0 : 1;
//         }
//         int mod = (int)(1e9 + 7);
        
//         for(int row = 1; row < N; row++){
//             for(int col = 1; col < M; col++){
//                 int up = 0, left = 0;
//                 if(grid[row - 1][col] != 1){
//                     up = dp[row - 1][col];
//                 }
//                 if(grid[row][col - 1] != 1){
//                     left = dp[row][col - 1];
//                 }
//                 dp[row][col] = (left % mod + up % mod) % mod;
//             }
//         }
        
//         return dp[N - 1][M - 1];
//     }
// }

class Solution {
    
    public int totalWays(int N, int M, int grid[][]) {
        if(grid[0][0] == 1 || grid[N - 1][M - 1] == 1){
            return 0;
        }
        int prev[] = new int[M];
        
        for(int i = 0; i < M; i++){
            prev[i] = grid[0][i] == 1 ? 0 : 1;
        }
        
        
        int mod = (int)(1e9 + 7);
        
        for(int row = 1; row < N; row++){
            int[] curr = new int[M];
            
            if(grid[row][0] == 0){
                curr[0] = 1;
            }
            
            for(int col = 1; col < M; col++){
                int up = 0, left = 0;
                if(grid[row - 1][col] != 1){
                    up = prev[col];
                }
                if(grid[row][col - 1] != 1){
                    left = curr[col - 1];
                }
                curr[col] = (left % mod + up % mod) % mod;
            }
            prev = curr;
        }
        
        return prev[M - 1];
    }
}