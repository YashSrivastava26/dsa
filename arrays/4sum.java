import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        if(n < 4) return result;

        for (int i = 0; i < n; i++) {
            long target1 = (long)target - (long)nums[i];
            for (int j = i + 1; j < n; j++) {
                long target2 = target1 - nums[j];
                int left = j + 1, right = n - 1;
                while(left < right){
                    int two_sum = nums[right] + nums[left];
                    if(two_sum == target2){
                        ArrayList<Integer> quad = new ArrayList<>(List.of(nums[i], nums[j], nums[left], nums[right]));
                        result.add(quad);
                        
                        while(left < right && nums[left] == nums[left + 1]) left++;
                        while(left < right && nums[right] == nums[right - 1]) right--;

                        right--;
                        left++;

                    }
                    else if(two_sum < target2)
                        left++;
                    else 
                        right--;
                }

                while(j + 1 < n && nums[j] == nums[j + 1]) j++;
            }
            
            while(i + 1 < n && nums[i] == nums[i + 1]) i++;
        }

        return result;
    }
}