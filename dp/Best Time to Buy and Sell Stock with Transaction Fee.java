// // class Solution {

// //     private int tryAllBuySell(int i, int bought, int[] prices, int fee, int[][] dp){
// //         if(i == prices.length){
// //             return 0;
// //         }

// //         if(dp[i][bought] != -1){
// //             return dp[i][bought];
// //         }
// //         if(bought == 1){
// //             int sell = prices[i] - fee + tryAllBuySell(i + 1, 0, prices, fee, dp);
// //             int notSell = 0 + tryAllBuySell(i + 1, 1, prices, fee, dp);
// //             return dp[i][bought] = Math.max(sell, notSell);
// //         }
// //         else{
// //             int buy = -prices[i] + tryAllBuySell(i + 1, 1, prices, fee, dp);
// //             int notBuy = 0 + tryAllBuySell(i + 1, 0, prices, fee, dp);
// //             return dp[i][bought] = Math.max(buy, notBuy);
// //         }
// //     }

// //     public int maxProfit(int[] prices, int fee) {
// //         int n = prices.length;
// //         int[][] dp = new int[n][2];
// //         for(int[] it : dp){
// //             it[0] = -1;
// //             it[1] = -1;
// //         }
// //         return tryAllBuySell(0, 0, prices, fee, dp);
// //     }
// // }

// class Solution {
//     public int maxProfit(int[] prices, int fee) {
//         int n = prices.length;
//         int[][] dp = new int[n + 1][2];
        
//         for(int i = n - 1; i >= 0; i--){
//             for(int bought = 0; bought < 2; bought++){
//                 if(bought == 1){
//                     dp[i][bought] = Math.max(prices[i] - fee + dp[i + 1][0], 0 + dp[i + 1][1]);
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
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[] front = new int[2];
        
        for(int i = n - 1; i >= 0; i--){
            int curr[] = new int[2];
            for(int bought = 0; bought < 2; bought++){
                if(bought == 1){
                    curr[bought] = Math.max(prices[i] - fee + front[0], 0 + front[1]);
                }
                else{
                    curr[bought] = Math.max(-prices[i] + front[1], 0 + front[0]);
                }
            }
            front = curr;
        }
        return front[0];
    }
}