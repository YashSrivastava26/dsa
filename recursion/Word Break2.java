import java.util.*;
class Solution {

    private void recursion(int i, int lastIdx, String s, HashSet<String> dict, List<String> ans, StringBuffer curr){
        if(i == s.length()){
            if(lastIdx == i){
                // System.out.println(curr);
                ans.add(curr.toString().trim());
            }
            return;
        }

        String now = s.substring(lastIdx, i + 1);
        if(dict.contains(now)){
            curr.append(" " + now);     
            recursion(i + 1, i + 1, s, dict, ans, curr);
            curr.delete(curr.length() - now.length() - 1, curr.length());
        }
        recursion(i + 1, lastIdx, s, dict, ans, curr);
        return;
    }

    public List<String> wordBreak(String s, List<String> wordDict) {
        HashSet<String> dict = new HashSet<>();
        for(String st: wordDict){
            dict.add(st);
        }
        List<String> ans = new ArrayList<>();
        recursion(0, 0, s, dict, ans, new StringBuffer());
        return ans;
        
    }
}