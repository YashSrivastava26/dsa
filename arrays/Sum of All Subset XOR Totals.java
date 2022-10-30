class Solution {

    int findSubsetXORSum(int[] nums, int idx, int sum){
        if(idx < 0) return 0;

        int take = nums[idx] ^ findSubsetXORSum(nums, idx - 1, sum);
        int notTake = findSubsetXORSum(nums, idx - 1, sum);
        sum
        return take + notTake;
    }

    public int subsetXORSum(int[] nums) {
        return findSubsetXORSum(nums, nums.length - 1 , 0, 0);
    }
}
