import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if(i == 0 || nums[i] != nums[i - 1]){
                int low = i + 1, high = nums.length - 1;
                while(low < high){
                    if(nums[i] + nums[low] + nums[high] == 0){
                        result.add(new ArrayList<>(List.of(nums[i], nums[low], nums[high])));
                    
                        while(low < high && nums[low] == nums[low + 1]) low++;
                        while(low < high && nums[high] == nums[high - 1]) high--;
                        low++;
                        high--;
                    }
                    else if(nums[i] + nums[low] + nums[high] < 0){
                        low++;
                    }
                    else{
                        high--;
                    }
                }
            }
        }
        return result;
    }
}