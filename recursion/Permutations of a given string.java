import java.util.*;
class Solution {
    
    private void formPermutations(StringBuilder curr, List<String> ans, String s, boolean[] isPick){
        if(curr.length() == s.length()){
            ans.add(curr.toString());
            return;
        }
        
        char prev = ' ';
        for(int i = 0; i < s.length(); i++){
            if(prev == s.charAt(i)){
                continue;
            }
            if(!isPick[i]){
                curr.append(s.charAt(i));
                isPick[i] = true;
                formPermutations(curr, ans, s, isPick);
                curr.deleteCharAt(curr.length() - 1);
                isPick[i] = false;
                prev = s.charAt(i);
            }
        }
    }
    
    public List<String> find_permutation(String S) {
        
        char[] chars = S.toCharArray();
        Arrays.sort(chars);
        S = new String(chars);
        
        List<String> ans = new ArrayList<>();
        boolean isPick[] = new boolean[S.length()];

        if(S.length() == 0) return ans;
        
        formPermutations(new StringBuilder(), ans, S, isPick);
        return ans;
    }
}