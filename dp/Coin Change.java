// // class Solution {

// //     private int memoization(int i, int amount, int[] coins, int[][] dp){
// //         if(i == 0){
// //             if(amount % coins[0] == 0){
// //                 return amount / coins[0];
// //             }
// //             return (int)1e8;
// //         }

// //         if(dp[i][amount] != -1){
// //             return dp[i][amount];
// //         }

// //         int notPick = memoization(i - 1, amount, coins, dp);
// //         int pick = (int)1e8;
// //         if(coins[i] <= amount){
// //             pick = 1 + memoization(i, amount - coins[i], coins, dp);
// //         }

// //         return dp[i][amount] = Math.min(pick, notPick);
// //     }

// //     public int coinChange(int[] coins, int amount) {
// //         int n = coins.length;
// //         int dp[][] = new int[n][amount + 1];
// //         for(int[] it : dp){
// //             Arrays.fill(it, -1);
// //         }

// //         int ans = memoization(n - 1, amount, coins, dp);
// //         if(ans > 1e4) return -1;
// //         return ans;
// //     }
// // }


// class Solution {

//     public int coinChange(int[] coins, int amount) {
//         int n = coins.length;
//         int dp[][] = new int[n][amount + 1];
//         for(int i = 0; i < amount + 1; i++){
//             if(i % coins[0] == 0){
//                 dp[0][i] = i / coins[0];
//             }
//             else{
//                 dp[0][i] = (int)1e8;
//             }
//         }
//         for(int i = 1; i < n; i++){
//             for(int amt = 0; amt < amount + 1; amt++){
//                 int notPick = dp[i - 1][amt];
//                 int pick = (int)1e8;
//                 if(coins[i] <= amt){
//                     pick = 1 + dp[i][amt - coins[i]];
//                 }

//                 dp[i][amt] = Math.min(pick, notPick);
//             }
//         }

//         if(dp[n - 1][amount] >= 1e8) return -1;
//         return dp[n - 1][amount];
//     }
// }

class Solution {

    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int prev[] = new int[amount + 1];
        for(int i = 0; i < amount + 1; i++){
            if(i % coins[0] == 0){
                prev[i] = i / coins[0];
            }
            else{
                prev[i] = (int)1e8;
            }
        }
        int curr[] = new int[amount + 1];
        for(int i = 1; i < n; i++){
            for(int amt = 0; amt < amount + 1; amt++){
                int notPick = prev[amt];
                int pick = (int)1e8;
                if(coins[i] <= amt){
                    pick = 1 + curr[amt - coins[i]];
                }

                curr[amt] = Math.min(pick, notPick);
            }
            prev = curr;
        }

        if(prev[amount] >= 1e8) return -1;
        return prev[amount];
    }
}