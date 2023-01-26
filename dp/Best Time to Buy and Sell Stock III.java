// // class Solution {

// //     private int tryAllBuySell(int i, int bought, int[] prices, int transactions, int[][][] dp){
// //         if(i == prices.length || transactions == 2){
// //             return 0;
// //         }

// //         if(dp[i][bought][transactions] != -1){
// //             return dp[i][bought][transactions];
// //         }
// //         if(bought == 1){
// //             int sell = prices[i] + tryAllBuySell(i + 1, 0, prices, transactions + 1, dp);
// //             int notSell = 0 + tryAllBuySell(i + 1, 1, prices, transactions, dp);
// //             return dp[i][bought][transactions] = Math.max(sell, notSell);
// //         }
// //         else{
// //             int buy = - prices[i] + tryAllBuySell(i + 1, 1, prices, transactions, dp);
// //             int notBuy = 0 + tryAllBuySell(i + 1, 0, prices, transactions, dp);
// //             return dp[i][bought][transactions] = Math.max(buy, notBuy);
// //         }
// //     }

// //     public int maxProfit(int[] prices) {
// //         int dp[][][] = new int[prices.length][2][2];
// //         for(int[][] it : dp){
// //             for(int[] itr: it){
// //                 Arrays.fill(itr, -1);
// //             }
// //         }
// //         return tryAllBuySell(0, 0, prices, 0, dp);
// //     }
// // }


// class Solution {

//     public int maxProfit(int[] prices) {
//         int n = prices.length;
//         int dp[][][] = new int[n + 1][2][3];
//         for(int i = n - 1; i >= 0; --i){
//             for(int bought = 0; bought <= 1; bought++){
//                 for(int transactions = 0; transactions <= 1; transactions++){
//                     if(bought == 1){
//                         int sell = prices[i] + dp[i + 1][0][transactions + 1];
//                         int notSell = 0 + dp[i + 1][1][transactions];
//                         dp[i][bought][transactions] = Math.max(sell, notSell);
//                     }
//                     else{
//                         int buy = - prices[i] + dp[i + 1][1][transactions];
//                         int notBuy = 0 + dp[i + 1][0][transactions];
//                         dp[i][bought][transactions] = Math.max(buy, notBuy);
//                     }
//                 }
//             }
//         }
//         return dp[0][0][0];
//     }
// }

class Solution {

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int dp[][][] = new int[n + 1][2][3];
        for(int i = n - 1; i >= 0; --i){
            for(int bought = 0; bought <= 1; bought++){
                for(int cap = 0; cap <= 1; cap++){
                    if(bought == 1){
                        dp[i][bought][cap] = Math.max(prices[i] + dp[i + 1][0][cap + 1], 0 + dp[i + 1][1][cap]);
                    }
                    else{
                        dp[i][bought][cap] = Math.max(- prices[i] + dp[i + 1][1][cap], 0 + dp[i + 1][0][cap]);
                    }
                }
            }
        }
        return dp[0][0][0];
    }
}