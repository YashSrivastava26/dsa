class Solution {

    public int maxCoins(int[] nums) {
        int n = nums.length;
        int numsClone[] = new int[n + 2];
        for(int i = 0; i < n; i++){
            numsClone[i + 1] = nums[i];
        }
        numsClone[0] = 1;
        numsClone[n + 1] = 1;
        int dp[][] = new int[n + 2][n + 2];
        for(int left = n; left > 0; left--){
            for(int right = left; right <= n; right++){
                for(int i = left; i <= right; i++){
                    int curr = numsClone[left - 1] * numsClone[right + 1] * numsClone[i] + dp[left][i - 1] + dp[i + 1][right];
                    dp[left][right] = Math.max(dp[left][right], curr);
                }
            }
        }

        return dp[1][n];
    }
}