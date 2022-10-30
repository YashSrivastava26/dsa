class Solution {
    public int maxProfit(int[] prices) {
        int purchase = prices[0], sell = prices[0], maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if(purchase > prices[i]) purchase = prices[i];
            sell = prices[i];
            maxProfit = Math.max(maxProfit, sell - purchase);
        }
        return maxProfit;

    }
}
