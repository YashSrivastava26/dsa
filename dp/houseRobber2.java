
//leave first ele in first time and last in secont time and pass arrays in houserobber1 question function and take max of them
//as answer contain either last or first element
class Solution {
    public int FindMaxSum(int arr[], int n, int start)
    {
        
        int prev2_pick = 0;
        int prev1_notpick = arr[start];
        for(int i = start + 1; i < n; i++){
            int pick = arr[i] + prev2_pick;
            int notpick = 0 + prev1_notpick;
        
            int curr = Math.max(pick, notpick);
            prev2_pick = prev1_notpick;
            prev1_notpick = curr;
            
        }
        
        return prev1_notpick;
    }

    public int rob(int[] nums) {
        int n = nums.length;
        int ans = FindMaxSum(nums, n - 1, 0);
        if(n > 1) {
            ans = Math.max(FindMaxSum(nums, n - 1, 0), FindMaxSum(nums, n, 1));
        }
        return ans;
    }
}