// // class Solution {

// //     private int tryallBuySell(int i, int bought, int k, int[] prices, int[][][] dp){
// //         if(i == prices.length || k == 0){
// //             return 0;
// //         }

// //         if(dp[i][bought][k] != -1){
// //             return dp[i][bought][k];
// //         }

// //         if(bought == 1){
// //             int sell = prices[i] + tryallBuySell(i + 1, 0, k - 1, prices, dp);
// //             int notSell = 0 + tryallBuySell(i + 1, 1, k, prices, dp);

// //             return dp[i][bought][k] = Math.max(sell, notSell);
// //         }
// //         else{
// //             int buy = -prices[i] + tryallBuySell(i + 1, 1, k, prices, dp);
// //             int notBuy = -0 + tryallBuySell(i + 1, 0, k, prices, dp);

// //             return dp[i][bought][k] = Math.max(buy, notBuy);
// //         }
// //     }

// //     public int maxProfit(int k, int[] prices) {
// //         int n = prices.length;
// //         int[][][] dp = new int[n][2][k + 1];
// //         for(int[][] it: dp){
// //             for(int[] itr : it){
// //                 Arrays.fill(itr, -1);
// //             }
// //         }
// //         return tryallBuySell(0, 0, k, prices, dp);
// //     }
// // }


// class Solution {

//     public int maxProfit(int k, int[] prices) {
//         int n = prices.length;
//         int[][][] dp = new int[n + 1][2][k + 1];
//         for(int i = n - 1; i >= 0; i--){
//             for(int bought = 0; bought < 2; bought++){
//                 for(int cap = k; cap > 0; cap--){
//                     if(bought == 1){
//                         dp[i][bought][cap] = Math.max(prices[i] + dp[i + 1][0][cap - 1], 0 + dp[i + 1][1][cap]);
//                     }
//                     else{
//                         dp[i][bought][cap] = Math.max(-prices[i] + dp[i + 1][1][cap], 0 + dp[i + 1][0][cap]);
//                     }
//                 }
//             }
//         }
//         return dp[0][0][k];
//     }
// }


class Solution {

    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[][] prev = new int[2][k + 1];
        for(int i = n - 1; i >= 0; i--){
            int curr[][] = new int[2][k + 1];
            for(int bought = 0; bought < 2; bought++){
                for(int cap = k; cap > 0; cap--){
                    if(bought == 1){
                        curr[bought][cap] = Math.max(prices[i] + prev[0][cap - 1], 0 + prev[1][cap]);
                    }
                    else{
                        curr[bought][cap] = Math.max(-prices[i] + prev[1][cap], 0 + prev[0][cap]);
                    }
                }
            }
            prev = curr;
        }
        return prev[0][k];
    }
}