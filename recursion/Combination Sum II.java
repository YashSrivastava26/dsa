import java.util.*;

class Solution {

    private void helper(int i, int[] cand, int targ, ArrayList <Integer> curr , List < List <Integer> > ans ){

        if(targ == 0) {
            ans.add(new ArrayList<>(curr));
            return;
        }
        else if(targ < 0){
            return ;
        }
        int n = cand.length;
        int prev = -1;
        for(;i < n; i++){
            if(cand[i] != prev){
                curr.add(cand[i]);
                helper(i + 1, cand, targ - cand[i], curr, ans);
                curr.remove(curr.size() - 1);
                prev = cand[i];
            }
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List < List <Integer> > ans = new ArrayList<>();

        Arrays.sort(candidates);

        helper(0, candidates, target,new ArrayList<>(), ans);
        return ans;
    }
}