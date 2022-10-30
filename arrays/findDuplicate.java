class Solution {
    public int findDuplicate(int[] nums) {
        int xor = 0, xor_n = 0;
        for (int i = 0; i < nums.length; i++) {
            xor ^= nums[i];
        }
        for (int i = 1; i < nums.length ; i++) {
            xor_n ^= i;
        }
        return xor ^ xor_n;
    }
}