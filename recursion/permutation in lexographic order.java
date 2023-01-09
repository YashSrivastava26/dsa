import java.util.*;
class Solution
{

    private void hepler(String s, int i, StringBuffer curr, List<String> ans){
        if(i == s.length()){
            if(curr.length() != 0){
                ans.add(curr.toString());
            }
            return;
        }

        //pick
        curr.append(s.charAt(i));
        hepler(s, i + 1, curr, ans);
        curr.deleteCharAt(curr.length() - 1);

        hepler(s, i + 1, curr, ans);
    }

    public List<String> AllPossibleStrings(String s)
    {
        List<String> ans = new ArrayList<>();

        hepler(s, 0, new StringBuffer(), ans);
        Collections.sort(ans);
        return ans;
    }
}