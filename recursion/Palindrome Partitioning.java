import java.util.*;
class Solution {

    private boolean isPalindrome(String s, int start, int i){
        int left = start, right = i - 1;

        while(left < right){
            if(s.charAt(left) != s.charAt(right)){
                return false;
            }
            left ++;
            right--;
        }
        return true;
    }

    private void tryAllPossiblePartation(int start, String s, ArrayList<String> curr, List<List<String>> ans){
        if(start == s.length()){
            ans.add(new ArrayList<>(curr));
            return;
        }

        int n = s.length();
        for(int i = start + 1; i <= n; i++){
            if(isPalindrome(s, start, i)){
                curr.add(s.substring(start, i));
                tryAllPossiblePartation(i, s, curr, ans);
                curr.remove(curr.size() - 1);
            }
        }
    }

    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();

        tryAllPossiblePartation(0, s, new ArrayList<String>(), ans);
        return ans;
    }
}