import java.util.Arrays;

//recursion
// class Solution {
    
//     public int countPaths(int[][] arr, int row, int column){
//         if(row == 0 && column == 0) return 1;
//         if(row < 0 || column < 0) return 0;
//         if(arr[row][column] == 1) return 0;

//         int up = countPaths(arr, row, column - 1);
//         int left = countPaths(arr, row - 1, column);
//         return up + left;
//     }
    
//     public int uniquePathsWithObstacles(int[][] obstacleGrid) {
//         return countPaths(obstacleGrid, obstacleGrid.length - 1, obstacleGrid[0].length - 1);
//     }
// }

// memoization
// class Solution {
    
//     public int countPaths(int[][] arr, int row, int column, int[][] dp){
        
//         if(row < 0 || column < 0) return 0;
//         if(arr[row][column] == 1) return 0;
//         if(row == 0 && column == 0) return 1;                
        
//         int up = countPaths(arr, row, column - 1, dp);
//         int left = countPaths(arr, row - 1, column, dp);
//         return dp[row][column]= up + left;
//     }
    
//     public int uniquePathsWithObstacles(int[][] obstacleGrid) {
//         int row = obstacleGrid.length;
//         int col = obstacleGrid[0].length;
//         int dp[][] = new int[row][col];
        
//         for (int[] x : dp) {
//             Arrays.fill(x, -1);
//         }
//         return countPaths(obstacleGrid, row - 1, col -1, dp);
//     }
// }

// // tabulation
// class Solution {
        
//     public int uniquePathsWithObstacles(int[][] obstacleGrid) {
//         int row = obstacleGrid.length;
//         int col = obstacleGrid[0].length;
//         int dp[][] = new int[row][col];
        
//         for (int i = 0; i < row; i++) {
//             Arrays.fill(dp[i], -1);
//             for (int j = 0; j < col; j++) {
//                 if(obstacleGrid[i][j] == 1) dp[i][j] = 0;
//                 else if(i == 0 && j == 0) dp[i][j] = 1; 
//                 else{
//                     int left = 0, up = 0;
//                     if(i > 0) left = dp[i - 1][j];
//                     if(j > 0) up = dp[i][j - 1];
//                     dp[i][j] = left + up;
//                 }
//             }
//         }

        
//         return dp[row - 1][col - 1];
//     }
// }

//space optimization 

class Solution {
        
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        int prev[] = new int[col];
        Arrays.fill(prev, 0);
        
        for (int i = 0; i < row; i++) {
            int curr[] = new int[col];
            for (int j = 0; j < col; j++) {
                if(obstacleGrid[i][j] == 1) curr[j] = 0;
                else if(i == 0 && j == 0) curr[j] = 1; 
                else{
                    int left = 0, up = 0;
                    if(i > 0) left = prev[j];
                    if(j > 0) up = curr[j - 1];
                    curr[j] = left + up;
                }
            }
            prev = curr;
        }

        
        return prev[col - 1];
    }
}