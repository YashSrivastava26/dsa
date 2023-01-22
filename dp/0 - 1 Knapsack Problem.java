// class Solution 
// { 
    
//     private static int memoization(int i, int k, int wt[], int val[], int dp[][]){
//         if(i == 0){
//             if(k >= wt[i]){
//                 return val[i];
//             }
//             return 0;
//         }
        
//         if(dp[i][k] != -1){
//             return dp[i][k];
//         }
        
//         int pick = 0;
//         if(wt[i] <= k){
//             pick = val[i] + memoization(i - 1, k - wt[i], wt, val, dp);
//         }
//         int notPick = memoization(i - 1, k, wt, val, dp);
        
//         return dp[i][k] = Math.max(pick, notPick);
//     }
    
//     //Function to return max value that can be put in knapsack of capacity W.
//     static int knapSack(int W, int wt[], int val[], int n) 
//     { 
//         int dp[][] = new int[n][W + 1];
//         for(int[] it : dp){
//             Arrays.fill(it, -1);
//         }
        
//         return memoization(n - 1, W, wt, val, dp);
//     } 
// }



// class Solution 
// { 
    
//     //Function to return max value that can be put in knapsack of capacity W.
//     static int knapSack(int W, int wt[], int val[], int n) 
//     { 
//         int dp[][] = new int[n][W + 1];
//         for(int i = 0; i < W + 1; i++){
//             if(i >= wt[0]){
//                 dp[0][i] = val[0];
//             }
//         }
        
//         for(int i = 1; i < n; i++){
//             for(int k = 0; k < W + 1; k++){
//                 int pick = 0;
//                 if(wt[i] <= k){
//                     pick = val[i] + dp[i - 1][k - wt[i]];
//                 }
//                 int notPick = dp[i - 1][k];
//                 // System.out.println(pick + " " + notPick);        
//                 dp[i][k] = Math.max(pick, notPick);
//             }
//         }
        
//         return dp[n - 1][W];
//     } 
// }







// class Solution 
// { 
    
//     //Function to return max value that can be put in knapsack of capacity W.
//     static int knapSack(int W, int wt[], int val[], int n) 
//     { 
//         int prev[] = new int[W + 1];
//         for(int i = 0; i < W + 1; i++){
//             if(i >= wt[0]){
//                 prev[i] = val[0];
//             }
//         }
        
//         for(int i = 1; i < n; i++){
//             int curr[] = new int[W + 1];
//             for(int k = 0; k < W + 1; k++){
//                 int pick = 0;
//                 if(wt[i] <= k){
//                     pick = val[i] + prev[k - wt[i]];
//                 }
//                 int notPick = prev[k];  
//                 curr[k] = Math.max(pick, notPick);
//             }
//             prev = curr;
//         }
        
//         return prev[W];
//     } 
// }

//space optimization using only 1 row (i.e. only using prev)
class Solution 
{ 
    
    //Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int W, int wt[], int val[], int n) 
    { 
        int prev[] = new int[W + 1];
        for(int i = 0; i < W + 1; i++){
            if(i >= wt[0]){
                prev[i] = val[0];
            }
        }
        
        for(int i = 1; i < n; i++){
            for(int k = W; k >= 0; k--){
                int pick = 0;
                if(wt[i] <= k){
                    pick = val[i] + prev[k - wt[i]];
                }
                int notPick = prev[k];  
                prev[k] = Math.max(pick, notPick);
            }
        }
        
        return prev[W];
    } 
}