class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int currConsuctive = 0, maxi = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == 0){
                maxi = Math.max(maxi, currConsuctive);
                currConsuctive = 0;
            }
            else currConsuctive++;
        }
        maxi = Math.max(maxi, currConsuctive);
        return maxi;
    }
}
