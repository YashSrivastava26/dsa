// // class Solution {

// //     private int tryAllBuySell(int i, int bought, int[] prices, int[][] dp){
// //         if(i >= prices.length){
// //             return 0;
// //         }

// //         if(dp[i][bought] != -1){
// //             return dp[i][bought];
// //         }

// //         if(bought == 1){
// //             int sell = prices[i] + tryAllBuySell(i + 2, 0, prices, dp);
// //             int notSell = 0 + tryAllBuySell(i + 1, 1, prices, dp);
// //             return dp[i][bought] = Math.max(sell,notSell);
// //         }
// //         else{
// //             int buy = -prices[i] + tryAllBuySell(i + 1, 1, prices, dp);
// //             int notBuy = 0 + tryAllBuySell(i + 1, 0, prices, dp);
// //             return dp[i][bought] = Math.max(buy, notBuy);
// //         }
// //     }

// //     public int maxProfit(int[] prices) {
// //         int n = prices.length;
// //         int dp[][] = new int[n][2];
// //         for(int[] it : dp){
// //             Arrays.fill(it, -1);
// //         }
// //         return tryAllBuySell(0, 0, prices, dp);
// //     }
// // }

// class Solution {

//     public int maxProfit(int[] prices) {
//         int n = prices.length;
//         int dp[][] = new int[n + 2][2];
//         for(int i = n - 1; i >= 0; i--){
//             for(int bought = 0; bought < 2; bought++){
//                 if(bought == 1){
//                     dp[i][bought] = Math.max(prices[i] + dp[i + 2][0], 0 + dp[i + 1][1]);
//                 }
//                 else{
//                     dp[i][bought] = Math.max(-prices[i] + dp[i + 1][1], 0 + dp[i + 1][0]);
//                 }
//             }
//         }
//         return dp[0][0];
//     }
// }

class Solution {

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int front2[] = new int[2];
        int front1[] = new int[2];
        for(int i = n - 1; i >= 0; i--){
            int curr[] = new int[2];
            for(int bought = 0; bought < 2; bought++){
                if(bought == 1){
                    curr[bought] = Math.max(prices[i] + front2[0], 0 + front1[1]);
                }
                else{
                    curr[bought] = Math.max(-prices[i] + front1[1], 0 + front1[0]);
                }
            }
            front2 = front1.clone();
            front1 = curr;
        }
        return front1[0];
    }
}