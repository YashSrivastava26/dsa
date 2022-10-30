
import java.util.Arrays;

// //recursion
// class Solution {
//     private int noOfUniquePath(int row, int column){
//         if(row == 0  &&  column == 0) return 1;
//         if(row < 0 ||  column < 0) return 0;

//         int left = noOfUniquePath(row, column - 1);
//         int up = noOfUniquePath(row - 1, column);
        
//         return left + up;
//     }

//     public int uniquePaths(int m, int n) {
//         return noOfUniquePath(m - 1, n - 1);
//     }
// }

// //memoization
// class Solution {
//     private int noOfUniquePath(int row, int column, int[][] dp){
//         if(row == 0  &&  column == 0) return 1;
//         if(row < 0 ||  column < 0) return 0;

//         if(dp[row][column] != -1) return dp[row][column];

//         int left = noOfUniquePath(row, column - 1, dp);
//         int up = noOfUniquePath(row - 1, column, dp);
        
//         return dp[row][column] = left + up;
//     }

//     public int uniquePaths(int m, int n) {
//         int dp[][] = new int[m + 1][n + 1];
//         for (int[] is : dp) {
//             Arrays.fill(is, -1);
//         }
//         return noOfUniquePath(m - 1, n - 1, dp);
//     }
// }


// //tabulation

// class Solution {

//     private static int countWaysUntil(int m, int n, int[][] dp){
//         for(int i = 0; i < m; i++){
//             for (int j = 0; j < n; j++) {
//                 if(i == 0 && j == 0) dp[i][j] = 1;
//                 else{
//                     int left = 0, up = 0;
//                     if(j > 0) left = dp[i][j - 1];
//                     if(i > 0) up = dp[i - 1][j];
//                     dp[i][j] = left + up;
//                 }
//             }
//         }
//         return dp[m - 1][n - 1];
//     }

//     public static int uniquePaths(int m, int n) {
//         int dp[][] = new int[m][n];
//         for (int[] row : dp) {
//             Arrays.fill(row, -1);
//         }
//         return countWaysUntil(m, n, dp);
//     }
// }

//space optimization

class Solution {

    public int uniquePaths(int m, int n) {
        int prev[] = new int[n];
        for(int i = 0; i < m; i++){
            int curr[] = new int[n];
            Arrays.fill(curr, 0);
            for (int j = 0; j < n; j++) {
                if(i == 0 && j == 0) curr[j] = 1;
                else{
                    int left = 0, up = 0;
                    if(j > 0) left = curr[j - 1];
                    if(i > 0) up = prev[j];
                    curr[j] = left + up;
                }
            }
            prev = curr;
        }
        return prev[n - 1];
    }
}

/**
 * UniquePath
 */
public class UniquePath {

    public static void main(String[] args) {
    }
}