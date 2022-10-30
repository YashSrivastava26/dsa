class Solution {

    public static long pairWithMaxSum(long arr[], long N)
    {
        long maxSumConsuctive = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length - 1; i++) {
            maxSumConsuctive = Math.max(maxSumConsuctive, arr[i] + arr[i + 1]);
        }
    }
    return maxSumConsuctive;
}
