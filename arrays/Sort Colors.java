class Solution {
    public void sortColors(int[] nums) {
        int noOfZero = 0, noOfOne = 0, noOfTwo = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) noOfZero++;
            else if(nums[i] == 1) noOfOne++;
            else noOfTwo++;
        }
        for (int i = 0; i < nums.length; i++) {
            if(i < noOfZero) nums[i] = 0;
            else if(i < noOfZero + noOfOne) nums[i] = 1;
            else nums[i] = 2;
        }
    }
}
