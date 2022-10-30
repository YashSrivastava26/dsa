class Solution {
    public int longestOnes(int[] nums, int k) {
        int left = 0, right = 0, zeroInsideWindow = 0, maxi = 0;
        while(right < nums.length){
            if(zeroInsideWindow <= k){
                if(nums[right] == 0){
                    zeroInsideWindow++;
                }
                right++;
            }
            if(zeroInsideWindow > k){
                if(nums[left] == 0){
                    zeroInsideWindow--;
                }
                left++;
            }
            if(zeroInsideWindow <= k){
                maxi = Math.max(maxi, right - left + 1);
            }
        }
        return maxi;
    }
}