

// recursion
// class Solution {
    
//     private int minSumTill(int row, int col, int[][] arr){
//         if(col < 0 || col > arr.length - 1) return (int) 1e9;
//         if(row == 0) return arr[row][col];

//         int left = arr[row][col] + minSumTill(row - 1, col - 1, arr);
//         int right = arr[row][col] + minSumTill(row - 1, col + 1, arr);
//         int above = arr[row][col] + minSumTill(row - 1, col, arr);

//         int result = Math.min(left, Math.min(right, above));
//         return result;
//     }
    
//     public int minFallingPathSum(int[][] matrix) {
        
//         int lastRowIdx = matrix.length - 1;
//         int sizeOfLastRow = matrix[lastRowIdx].length;
//         int minSum = Integer.MAX_VALUE;
//         for (int i = 0; i < sizeOfLastRow; i++) {
//             minSum = Math.min(minSum, minSumTill(lastRowIdx, i, matrix));
//         }

//         return minSum;
//     }
// }

//memoization

// class Solution {
    
//     private int minSumTill(int row, int col, int[][] arr, int[][] dp){
//         if(col < 0 || col > arr.length - 1) return (int) 1e9;
//         if(row == 0) return arr[row][col];

//         if(dp[row][col] != -1) return dp[row][col];

//         int left = arr[row][col] + minSumTill(row - 1, col - 1, arr, dp);
//         int right = arr[row][col] + minSumTill(row - 1, col + 1, arr, dp);
//         int above = arr[row][col] + minSumTill(row - 1, col, arr, dp);

//         int result = Math.min(left, Math.min(right, above));
//         return dp[row][col] = result;
//     }
    
//     public int minFallingPathSum(int[][] matrix) {
        
//         int lastRowIdx = matrix.length - 1;
//         int sizeOfLastRow = matrix[lastRowIdx].length;
//         int minSum = Integer.MAX_VALUE;
//         int dp[][] = new int[matrix.length][sizeOfLastRow];
        
//         for (int i = 0; i < sizeOfLastRow; i++) {
//             for (int[] x : dp) {
//                 Arrays.fill(x, -1);
//             }
            
//             minSum = Math.min(minSum, minSumTill(lastRowIdx, i, matrix, dp));
//         }

//         return minSum;
//     }
// }

//tabulation
// class Solution {
    
//     public int minFallingPathSum(int[][] matrix) {
        
//         int dp[][] = new int[matrix.length][matrix[0].length];
//         for (int i = 0; i < dp[0].length; i++) {
//             dp[0][i] = matrix[0][i];
//         }        

//         int minResult = Integer.MAX_VALUE;
//         for (int row = 1; row < dp.length; row++) {
//             for (int col = 0; col < dp[row].length; col++) {
//                 int left = (int) 1e9, right = (int) 1e9;
//                 if(col > 0) left = matrix[row][col] + dp[row - 1][col - 1];
//                 if(col < dp[row].length - 1) right = matrix[row][col] + dp[row - 1][col + 1];
//                 int above = matrix[row][col] + dp[row - 1][col];

//                 dp[row][col] = Math.min(above, Math.min(left, right));
                 
//             }
//         }
//         for (int i = 0; i < dp[dp.length - 1].length; i++) {
//             if(dp[dp.length - 1][i] < minResult) minResult = dp[dp.length - 1][i];
//         }

//         return minResult;
//     }
// }

//space optimization

class Solution {
    
    public int minFallingPathSum(int[][] matrix) {
        
        int prev[] = new int[matrix[0].length];
        for (int i = 0; i < prev.length; i++) {
            prev[i] = matrix[0][i];
        }        

        int minResult = Integer.MAX_VALUE;
        for (int row = 1; row < matrix.length; row++) {
            int curr[] = new int[matrix[row].length];
            for (int col = 0; col < matrix[row].length; col++) {
                int left = (int) 1e9, right = (int) 1e9;
                if(col > 0) left = matrix[row][col] + prev[col - 1];
                if(col < matrix[row].length - 1) right = matrix[row][col] + prev[col + 1];
                int above = matrix[row][col] + prev[col];

                curr[col] = Math.min(above, Math.min(left, right));
                prev = curr;
                 
            }
        }
        for (int i = 0; i < prev.length; i++) {
            if(prev[i] < minResult) minResult = prev[i];
        }

        return minResult;
    }
}