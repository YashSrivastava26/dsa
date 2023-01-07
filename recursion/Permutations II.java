import java.util.*;

class Solution {

    private void generatePermutations(int idx, HashMap<Integer, Integer> freq, ArrayList<Integer> curr, List<List<Integer>> ans, int n){
        if(curr.size() == n){
            ans.add(new ArrayList<>(curr));
            return;
        }

        for(Map.Entry<Integer, Integer >  it: freq.entrySet()){
            if(it.getValue() > 0){
                curr.add(it.getKey());
                freq.put(it.getKey(), it.getValue() - 1);

                generatePermutations(idx + 1, freq, curr, ans, n);

                freq.put(it.getKey(), it.getValue() + 1);
                curr.remove(curr.size() - 1);
            }
        }
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> ans = new ArrayList<>();
        HashMap<Integer, Integer> freq = new HashMap<>();

        for(int it: nums){
            freq.put(it, freq.getOrDefault(it, 0) + 1);
        }

        generatePermutations(0, freq, new ArrayList<>(), ans, nums.length);
        return ans;
    }
}