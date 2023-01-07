import java.util.*;

//brute force
//Tc = O( 2^n *(k log (x) )). 2^n  for generating every subset and k* log(x)
//SC = O(2 ^ N * k + 2 ^ n)
// class Solution {

//     private void helper(int i, int[] nums, ArrayList< Integer > curr, Set < List < Integer > > unique){
//         if(i == nums.length){
//             unique.add(new ArrayList< Integer >(curr));
//             return;
//         }
        
//         //pick
//         curr.add(nums[i]);
//         helper(i + 1, nums, curr, unique);
//         curr.remove(curr.size() - 1);

//         //not pick
//         helper(i + 1, nums, curr, unique);

//     }

//     public List<List<Integer>> subsetsWithDup(int[] nums) {
//         Set < List < Integer >> unique = new HashSet<>();
//         Arrays.sort(nums);

//         helper(0, nums, new ArrayList<>(), unique);
        
//         List<List<Integer>> ans = new ArrayList<>(unique);
//         return ans;
//     }
// }



class Solution {

    private void helper(int size, int[] nums, ArrayList< Integer > curr, List < List < Integer > > ans){
        // not necessary
        // if(size == nums.length ){
        //     ans.add(new ArrayList< Integer >(curr));
        //     return;
        // }
        
        ans.add(new ArrayList< Integer >(curr));

        for(int i = size; i < nums.length; i++){
            if(i > size && nums[i] == nums[i - 1]){
                continue;
            }
            curr.add(nums[i]);
            helper(i + 1, nums, curr, ans);
            curr.remove(curr.size() - 1);
        }

    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);

        helper(0, nums, new ArrayList<>(), ans);
        return ans;
    }
}