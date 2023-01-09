import java.util.*;
// class Solution {

//     private void generate(int[] nums, int i, ArrayList<Integer> curr, List< List< Integer>> ans){
//         if(i == nums.length){
//             ans.add(new ArrayList<>(curr));
//             return;
//         }
        
//         curr.add(nums[i]);
//         generate(nums, i + 1, curr, ans);
//         curr.remove(curr.size() - 1);

//         generate(nums, i + 1, curr, ans);

//     }

//     public List<List<Integer>> subsets(int[] nums) {
//         List<List<Integer>> ans = new ArrayList<>();

//         generate(nums, 0, new ArrayList<>(), ans);
//         return ans;
//     }
// }

class Solution {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        for(int ithSubset = 0; ithSubset < (1 << n); ithSubset++){
            ArrayList<Integer> curr = new ArrayList<>();
            for(int j = 0; j < n; j++){
                if((ithSubset & (1 << j)) != 0){
                    curr.add(nums[j]);
                }
            }
            ans.add(curr);
        }
        return ans;
    }
}