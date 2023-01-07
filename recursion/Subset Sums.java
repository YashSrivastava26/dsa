import java.util.ArrayList;
import java.util.Collections;

class Solution{
    
    private void helper(int i, ArrayList<Integer> arr, ArrayList<Integer> ans, int n, int sum){
        if(i == n){
            ans.add(sum);
            return;
        }
        
        //pick
        helper(i + 1, arr, ans, n, sum + arr.get(i));
        helper(i + 1, arr, ans, n, sum);
        
        
        
    }
    
    ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int N){
        ArrayList<Integer> ans = new ArrayList<>();
        
        helper(0, arr, ans, N, 0);
        Collections.sort(ans);
        return ans;
    }
}