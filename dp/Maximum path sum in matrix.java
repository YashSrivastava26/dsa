// class Solution{
    
//     private static int tryAllWays(int row, int col, int[][] matrix, int n, int[][] dp){
//         if(col < 0 || col >= n){
//             return 0;
//         }
        
//         if(row == 0){
//             return matrix[0][col];
//         }
        
//         if(dp[row][col] != -1){
//             return dp[row][col];
//         }
//         int up = tryAllWays(row - 1, col, matrix, n, dp);
//         int upLeft = tryAllWays(row - 1, col - 1, matrix, n, dp);
//         int upRight = tryAllWays(row - 1, col + 1, matrix, n, dp);
        
//         return dp[row][col] = matrix[row][col] + Math.max(up, Math.max(upLeft, upRight));
//     }
    
//     static int maximumPath(int N, int Matrix[][])
//     {
//         int maxAns = 0;
//         int dp[][] = new int[N][N];
//         for(int[] row : dp){
//             Arrays.fill(row, -1);
//         }
//         for(int i = 0; i < N; i++){
//             maxAns = Math.max(tryAllWays(N - 1, i, Matrix, N, dp), maxAns);
//         }
        
//         return maxAns;
//     }
// }


// class Solution{
//     static int maximumPath(int N, int matrix[][])
//     {
//         int dp[][] = new int[N][N];
        
//         for(int i = 0; i < N; i++){
//             dp[0][i] = matrix[0][i];
//         }
        
//         for(int row = 1; row < N; row++){
//             for(int col = 0; col < N; col++){
//                 int up = dp[row - 1][col];
//                 int upLeft = (col - 1) < 0 ? (int)(-1e7) : dp[row - 1][col - 1];
//                 int upRight = (col + 1) >= N ? (int)(-1e7) : dp[row - 1][col + 1];
                
//                 dp[row][col] = matrix[row][col] + Math.max(up, Math.max(upLeft, upRight));
        
//             }
//         }
//         int ans = 0;
//         for(int col = 0; col < N; col++){
//             ans = Math.max(ans, dp[N - 1][col]);
//         }
        
//         return ans;
//     }
// }

class Solution{
    static int maximumPath(int N, int matrix[][])
    {
        int prev[] = new int[N];
        
        for(int i = 0; i < N; i++){
            prev[i] = matrix[0][i];
        }
        
        for(int row = 1; row < N; row++){
            int curr[] = new int[N];
            for(int col = 0; col < N; col++){
                int up = prev[col];
                int upLeft = (col - 1) < 0 ? (int)(-1e7) : prev[col - 1];
                int upRight = (col + 1) >= N ? (int)(-1e7) : prev[col + 1];
                
                curr[col] = matrix[row][col] + Math.max(up, Math.max(upLeft, upRight));
            }
            prev = curr;
        }
        int ans = 0;
        for(int col = 0; col < N; col++){
            ans = Math.max(ans, prev[col]);
        }
        
        return ans;
    }
}