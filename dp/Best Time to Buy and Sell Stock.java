class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0, mini = prices[0];
        int n = prices.length;
        for(int i = 1; i < n; i++){
            profit = Math.max(prices[i] - mini, profit);
            mini = Math.min(mini, prices[i]);
        }
        return profit;
    }
}