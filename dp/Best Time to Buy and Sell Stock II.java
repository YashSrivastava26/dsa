// // class Solution {

// //     private int tryAllComboOfBuySell(int i, int boughtPrevious, int[] prices, int[][] dp){

// //         if(i == prices.length){
// //             return 0;
// //         }

// //         if(dp[i][boughtPrevious] != -1){
// //             return dp[i][boughtPrevious];
// //         }

// //         if(boughtPrevious == 1){
// //             int sell = prices[i] + tryAllComboOfBuySell(i + 1, 0, prices, dp);
// //             int notSell = tryAllComboOfBuySell(i + 1, 1, prices, dp);
// //             // System.out.println(sell + " " + notSell);
// //             return dp[i][boughtPrevious] = Math.max(sell, notSell);
// //         }
// //         else{
// //             int buy = - prices[i] + tryAllComboOfBuySell(i + 1, 1, prices, dp);
// //             int notBuy = tryAllComboOfBuySell(i + 1, 0, prices, dp);
// //             // System.out.println(buy + " " + notBuy);

// //             return dp[i][boughtPrevious] = Math.max(buy, notBuy);
// //         }
// //     }

// //     public int maxProfit(int[] prices) {
// //         int dp[][] = new int[prices.length][2];
// //         for(int[] it : dp){
// //             Arrays.fill(it, -1);
// //         }
// //         return tryAllComboOfBuySell(0, 0, prices, dp);
// //     }
// // }


// class Solution {

//     public int maxProfit(int[] prices) {
//         int n = prices.length;
//         int dp[][] = new int[n + 1][2];
//         for(int i = n - 1; i >= 0; i--){
//             for(int j = 0; j < 2; j++){
//             if(j == 1){
//                 int sell = prices[i] + dp[i + 1][0];
//                 int notSell = dp[i + 1][1];
//                 dp[i][j] = Math.max(sell, notSell);
//             }
//             else{
//                 int buy = - prices[i] + dp[i + 1][1];
//                 int notBuy = dp[i + 1][0];

//                 dp[i][j] = Math.max(buy, notBuy);
//             }
//             }
//         }
//         return dp[0][0];
//     }
// }

class Solution {

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int prev[] = new int[2];
        for(int i = n - 1; i >= 0; i--){
            int curr[] = new int[2];
            for(int j = 0; j < 2; j++){
                if(j == 1){
                    int sell = prices[i] + prev[0];
                    int notSell = prev[1];
                    curr[j] = Math.max(sell, notSell);
                }
                else{
                    int buy = - prices[i] + prev[1];
                    int notBuy = prev[0];

                    curr[j] = Math.max(buy, notBuy);
                }
            }
            prev = curr;
        }
        return prev[0];
    }
}