import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> hash = new HashMap<>();
        int[] pair = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if(hash.containsKey(target - nums[i])){
                pair[0] = hash.get(target - nums[i]);
                pair[1] = i;
                break;
            }
            hash.put(nums[i], i);
        }
        return pair;
    }
}