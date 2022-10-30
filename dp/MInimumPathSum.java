import java.lang.reflect.Array;
import java.util.Arrays;

// // recursion

// class Solution {

//     private int minSumUntil(int[][] arr, int row, int column){
//         if(row == 0 && column == 0) return arr[0][0];
//         if(row < 0 || column < 0) return 1000000;//bcz range is upto 100 in question

//         int leftSum = arr[row][column] + minSumUntil(arr, row, column - 1);
//         int upSum = arr[row][column] + minSumUntil(arr, row - 1, column);

//         return Math.min(leftSum, upSum);
//     }

//     public int minPathSum(int[][] grid) {
//         int row = grid.length;
//         int col = grid[0].length;
//         return minSumUntil(grid, row - 1, col - 1);
//     }
// }

// public class MInimumPathSum {
    
// }


// //memoization

// class Solution {

//     private int minSumUntil(int[][] arr, int row, int column, int[][] dp){
//         if(row == 0 && column == 0) return arr[0][0];
//         if(row < 0 || column < 0) return 1000000;//bcz range is upto 100 in que

//         if(dp[row][column] != -1) return dp[row][column];

//         int leftSum = arr[row][column] + minSumUntil(arr, row, column - 1, dp);
//         int upSum = arr[row][column] + minSumUntil(arr, row - 1, column, dp);

//         return dp[row][column]= Math.min(leftSum, upSum);
//     }

//     public int minPathSum(int[][] grid) {
//         int row = grid.length;
//         int col = grid[0].length;
//         int dp[][] = new int[row][col];
//         for (int[] x : dp) {
//             Arrays.fill(x, -1);
//         }
//         return minSumUntil(grid, row - 1, col - 1, dp);
//     }
// }


// // tabulation
// class Solution {

//     public int minPathSum(int[][] grid) {
//         int row = grid.length;
//         int col = grid[0].length;
//         int dp[][] = new int[row][col];
//         for (int[] x : dp) {
//             Arrays.fill(x, 0);
//         }

//         for (int i = 0; i < row; i++) {
//             for (int j = 0; j < col; j++) {
//                 if(i == 0 && j == 0) dp[i][j] = grid[i][j];
//                 else{
//                     int up = 10000000, left = 100000000;
                    
//                     if(i > 0) up = dp[i - 1][j];
//                     if(j > 0) left = dp[i][j - 1];
//                     dp[i][j] = grid[i][j] + Math.min(up, left);
//                 }
//             }
//         }
//         return dp[row - 1][col - 1];
//     }
// }


//space optimization

class Solution {

    public int minPathSum(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int prev[] = new int[col];
        Arrays.fill(prev, 0);

        for (int i = 0; i < row; i++) {
            int curr[] = new int[col];
            for (int j = 0; j < col; j++) {
                if(i == 0 && j == 0) curr[j] = grid[i][j];
                else{
                    int up = 10000000, left = 100000000;
                    
                    if(i > 0) up = prev[j];
                    if(j > 0) left = curr[j - 1];
                    curr[j] = grid[i][j] + Math.min(up, left);
                }
            }
            prev = curr;
        }
        return prev[col - 1];
    }
}