import java.util.*;
// class Solution
// {
    
//     private static int memoization(int row, int col, int[][] dp){
//         if(row  == 0 && col == 0){
//             return 1;
//         }
        
        
//         if(dp[row][col] != -1){
//             return dp[row][col];
//         }
        
//         int top = 0, left = 0;
//         if(row != 0){
//             top = memoization(row - 1, col, dp);
//         }
//         if(col != 0){
//             left = memoization(row, col - 1, dp);
//         }
        
//         return dp[row][col] = top + left;
//     }
    
//     //Function to find total number of unique paths.
//     public static int NumberOfPath(int a, int b) 
//     {
//         int[][] dp = new int[a][b];
//         for(int[] row : dp){
//             Arrays.fill(row, -1);
//         }
        
//         return memoization(a - 1, b - 1, dp);
//     }
// }


//tabulation
// class Solution
// {
//     //Function to find total number of unique paths.
//     public static int NumberOfPath(int a, int b) 
//     {
//         int[][] dp = new int[a][b];
        
//         for(int i = 0; i < Math.max(a, b); i++){
//             if(i < a) dp[i][0] = 1;
//             if(i < b) dp[0][i] = 1;
//         }
        
//         for(int row = 1; row < a; row++){
//             for(int col = 1; col < b; col++){
//                 dp[row][col] = dp[row - 1][col] + dp[row][col - 1];
//             }
//         }
//         return dp[a - 1][b - 1];
//     }
// }

//space optimization
class Solution
{
    //Function to find total number of unique paths.
    public static int NumberOfPath(int a, int b) 
    {
        int prev[] = new int[b];
        
        Arrays.fill(prev, 1);
        
        for(int row = 1; row < a; row++){
            int curr[] = new int[b];
            curr[0] = 1;
            for(int col = 1; col < b; col++){
                curr[col] = prev[col] + curr[col - 1];
            }
            prev = curr;
        }
        return prev[b - 1];
    }
}