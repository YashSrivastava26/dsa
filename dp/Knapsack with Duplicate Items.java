

// // //User function Template for Java

// // class Solution{
    
// //     private static int tryAllWays(int i, int W, int[] val, int[] wt, int dp[][]){
// //         if(i == 0){
// //             // System.out.println(W + " " + i);
// //             // System.out.println((W / wt[i]) * val[i]);
// //             return (W / wt[i]) * val[i];
// //         }
        
// //         if(dp[i][W] != -1){
// //             return dp[i][W];
// //         }
// //         int pick = 0;
// //         if(wt[i] <= W){
// //             pick = val[i] + tryAllWays(i, W - wt[i], val, wt, dp);
// //         }
// //         int notPick = tryAllWays(i - 1, W, val, wt, dp);
// //         // System.out.println(pick + " " + notPick + " " + i + " " + W);
// //         return dp[i][W] = Math.max(pick, notPick);
// //     }
    
// //     static int knapSack(int N, int W, int val[], int wt[])
// //     {
// //         int dp[][] = new int[N][W + 1];
// //         for(int[] it : dp){
// //             Arrays.fill(it, -1);
// //         }
// //         return tryAllWays(N - 1, W, val, wt, dp);
// //     }
// // }



// //User function Template for Java

// class Solution{

//     static int knapSack(int N, int W, int val[], int wt[])
//     {
//         int dp[][] = new int[N][W + 1];
        
//         for(int w = 0; w < W + 1; w++){
//             dp[0][w] =  (w / wt[0]) * val[0];
//             // System.out.print(dp[0][w] + " ");
//         }
//         // System.out.println();
        
//         for(int i = 1; i < N; i++){
//             for(int w = 0; w < W + 1; w++){
//                 int pick = 0;
//                 if(wt[i] <= w){
//                     pick = val[i] + dp[i][w - wt[i]];
//                 }
//                 int notPick = dp[i - 1][w];
//                 dp[i][w] = Math.max(pick, notPick);
//                 // System.out.print(dp[i][w] + " ");
//             }
//             // System.out.println();
//         }
//         return dp[N - 1][W];
//     }
// }



// class Solution{
    
//     static int knapSack(int N, int W, int val[], int wt[])
//     {
//         int prev[] = new int[W + 1];
//         int curr[] = new int[W + 1];
        
//         for(int w = 0; w < W + 1; w++){
//             prev[w] =  (w / wt[0]) * val[0];
//         }
        
//         for(int i = 1; i < N; i++){
//             for(int w = 0; w < W + 1; w++){
//                 int pick = 0;
//                 if(wt[i] <= w){
//                     pick = val[i] + curr[w - wt[i]];
//                 }
//                 int notPick = prev[w];
//                 curr[w] = Math.max(pick, notPick);
//             }
//             prev = curr;
//         }
//         return prev[W];
//     }
// }


//1 array space optimization
class Solution{
    
    static int knapSack(int N, int W, int val[], int wt[])
    {
        int prev[] = new int[W + 1];
        
        for(int w = 0; w < W + 1; w++){
            prev[w] =  (w / wt[0]) * val[0];
        }
        
        for(int i = 1; i < N; i++){
            for(int w = 0; w < W + 1; w++){
                int pick = 0;
                if(wt[i] <= w){
                    pick = val[i] + prev[w - wt[i]];
                }
                int notPick = prev[w];
                prev[w] = Math.max(pick, notPick);
            }
        }
        return prev[W];
    }
}