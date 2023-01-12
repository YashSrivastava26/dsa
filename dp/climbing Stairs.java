// memoization
// class Solution {

//     private int countWays(int n, int[] dp){
//         if(n == 0){
//             return 1;
//         }

//         if(n < 0){
//             return 0;
//         }

//         if(dp[n] != 0){
//             return dp[n];
//         }

//         int oneSteps = countWays(n - 1, dp);
//         int twoSteps = countWays(n - 2, dp);
//         return dp[n] = oneSteps + twoSteps;
//     }

//     public int climbStairs(int n) {
//         int dp[] = new int[n + 1];
//         return countWays(n, dp);
//     }
// }

// tabulation
// class Solution {
//     public int climbStairs(int n) {
//         int dp[] = new int[n + 1];
//         dp[0] = 1;
//         dp[1] = 1;

//         for(int i = 2; i <= n; i++){
//             dp[i] = dp[i - 1] + dp[i - 2];
//         }
//         return dp[n];
//     }
// }

//space optimization
class Solution {
    public int climbStairs(int n) {
        int step2 = 1;
        int step1 = 1;

        for(int i = 2; i <= n; i++){
            int curr = step1 + step2;
            step2 = step1;
            step1 = curr;
        }
        return step1;
    }
}