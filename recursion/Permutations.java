import java.util.*;

//TC = n! * n
//SC = n! + n + n
// class Solution {

//     private void formPermutations(ArrayList<Integer> curr, List<List<Integer>> ans, int[] nums){
//         if(curr.size() == nums.length){
//             ans.add(new ArrayList<>(curr));
//             return;
//         }

//         for(int i = 0; i < nums.length; i++){
//             if(nums[i] != Integer.MIN_VALUE){
//                 curr.add(nums[i]);
//                 int temp = nums[i];
//                 nums[i] = Integer.MIN_VALUE;
//                 formPermutations(curr, ans, nums);
//                 nums[i] = temp;
//                 curr.remove(curr.size() - 1);
//             }
//         }
//     }

//     public List<List<Integer>> permute(int[] nums) {
//         List<List<Integer>> ans = new ArrayList<>();

//         if(nums.length == 0) return ans;
        
//         formPermutations(new ArrayList<Integer>(), ans, nums);
//         return ans;
//     }
// }


//by swaping
// TC = n! * n
// SC = n! + n

class Solution {

    private void swap(int i, int j, int[] nums){
        Integer temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void formPermutations( List<List<Integer>> ans, int[] nums, int idx){
        if(idx == nums.length){
            ArrayList<Integer> ds = new ArrayList<>();
            for (int it : nums) {
                ds.add(it);
            }
            ans.add(ds);
            return;
        }

        for(int i = idx; i < nums.length; i++){
            swap(i, idx, nums);
            formPermutations(ans, nums, idx + 1);
            swap(idx, i, nums);
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();

        if(nums.length == 0) return ans;

        formPermutations(ans, nums, 0);
        return ans;
    }
}