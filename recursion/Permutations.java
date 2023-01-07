import java.util.*;
class Solution {

    private void formPermutations(ArrayList<Integer> curr, List<List<Integer>> ans, int[] nums){
        if(curr.size() == nums.length){
            ans.add(new ArrayList<>(curr));
            return;
        }

        for(int i = 0; i < nums.length; i++){
            if(nums[i] != Integer.MIN_VALUE){
                curr.add(nums[i]);
                int temp = nums[i];
                nums[i] = Integer.MIN_VALUE;
                formPermutations(curr, ans, nums);
                nums[i] = temp;
                curr.remove(curr.size() - 1);
            }
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();

        if(nums.length == 0) return ans;
        
        formPermutations(new ArrayList<Integer>(), ans, nums);
        return ans;
    }
}