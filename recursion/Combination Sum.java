import java.util.ArrayList;
import java.util.List;

//using pick and not pick
// class Solution {

//     private void helper(int[] cand, int targ, int i, ArrayList<Integer> curr, List<List<Integer>> ans){
        
//         if(targ == 0){
//             ans.add(new ArrayList<>(curr));
//             return;
//         }
//         if(targ < 0){
//             return;
//         }
        
//         if(i == cand.length){
//             return;
//         }
//         //pick
//         curr.add(cand[i]);
//         helper(cand, targ - cand[i], i, curr, ans);
//         curr.remove(curr.size() - 1);

//         //not pick
//         helper(cand, targ, i + 1, curr, ans);
//     }

//     public List<List<Integer>> combinationSum(int[] candidates, int target) {
//         List<List<Integer>> ans = new ArrayList<>();
//         ArrayList < Integer > curr = new ArrayList<>();
//         helper(candidates, target, 0, curr, ans);
//         return ans;
//     }
// }

//using loop
class Solution {

    private void helper(int[] cand, int targ, int i, ArrayList<Integer> curr, List<List<Integer>> ans){

        if(targ == 0){
            ans.add(new ArrayList<>(curr));
            return;
        }
        if(targ < 0){
            return;
        }
        
        while(i < cand.length){
            curr.add(cand[i]);
            helper(cand, targ - cand[i], i, curr, ans);
            curr.remove(curr.size() - 1);
            i++;
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        ArrayList < Integer > curr = new ArrayList<>();
        helper(candidates, target, 0, curr, ans);
        return ans;
    }
}