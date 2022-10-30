import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
// // recursion
// class Solution {

//     private int minPathUntil(List<List<Integer>> triangle, int row, int col){ // min path sum from bottom until
//         if(row == triangle.size() - 1) return triangle.get(row).get(col);

//         int left = triangle.get(row).get(col) + minPathUntil(triangle, row + 1, col);
//         int right = triangle.get(row).get(col) + minPathUntil(triangle, row + 1, col + 1);

//         return Math.min(left, right);
//     }
    
//     public int minimumTotal(List<List<Integer>> triangle) {
//         return minPathUntil(triangle, 0, 0);
//     }
// }


// // memoization

// class Solution {

//     private int minPathUntil(List<List<Integer>> triangle, int row, int col, int[][] dp){ // min path sum from bottom until
//         if(row == triangle.size() - 1) return triangle.get(row).get(col);

//         if(dp[row][col] != -1) return dp[row][col];

//         int left = triangle.get(row).get(col) + minPathUntil(triangle, row + 1, col, dp);
//         int right = triangle.get(row).get(col) + minPathUntil(triangle, row + 1, col + 1, dp);

//         return dp[row][col] = Math.min(left, right);
//     }
    
//     public int minimumTotal(List<List<Integer>> triangle) {
//         int dp[][] = new int[triangle.size()][];
//         for (int i = 0; i < dp.length; i++) {
//             dp[i] = new int[triangle.get(i).size()];
//             Arrays.fill(dp[i], -1);
//         }
        
//         return minPathUntil(triangle, 0, 0, dp);
//     }
// }

// // tabulation

// class Solution {
    
//     public int minimumTotal(List<List<Integer>> triangle) {
//         int totalRow = triangle.size();
//         int dp[][] = new int[totalRow][];
//         for (int row = 0; row < totalRow; row++) {
//             dp[row] = new int[triangle.get(row).size()];
//         }

//         for (int col = 0; col < triangle.get(totalRow - 1).size(); col++) {
//             dp[totalRow - 1][col] = triangle.get(totalRow - 1).get(col);
//         }

//         for (int row = totalRow - 2; row >= 0; row--) {
//             for (int col = triangle.get(row).size() - 1; col >= 0; col--) {
//                     int left = triangle.get(row).get(col) + dp[row + 1][col];
//                     int right = triangle.get(row).get(col) + dp[row + 1][col + 1];
//                     dp[row][col] = Math.min(left, right);
//             }
//         }

//         return dp[0][0];
//     }
// }

//space optimization

class Solution {
    
    public int minimumTotal(List<List<Integer>> triangle) {
        int totalRow = triangle.size();
        int prev[] = new int[triangle.get(totalRow - 1).size()];
        for (int row = 0; row < prev.length; row++) {
            prev[row] = triangle.get(totalRow - 1).get(row);
        }

        for (int row = totalRow - 2; row >= 0; row--) {
            int curr[] = new int[triangle.get(row).size()];

            for (int col = curr.length - 1; col >= 0; col--) {

                    int left = triangle.get(row).get(col) + prev[col];
                    int right = triangle.get(row).get(col) + prev[col + 1];
                    curr[col] = Math.min(left, right);
            }
            prev = curr;
        }

        return prev[0];
    }
}

public class Triangle {
    
}

