import java.util.HashSet;
import java.util.Set;

class Solution {
    
    private static void helper(int i, String s, StringBuffer curr, Set<StringBuffer> chkDistinct){
        if(i == s.length()){
            chkDistinct.add(curr);
            return;
        }
        
        //take
        curr.append(s.charAt(i));
        helper(i + 1, s, curr, chkDistinct);
        curr.deleteCharAt(curr.length() - 1);
        
        //not take
        helper(i + 1, s, curr, chkDistinct);
    }
    
    public static String betterString(String str1, String str2) {
        Set<StringBuffer> chkDistinct = new HashSet<>();
        StringBuffer curr = new StringBuffer();
        helper(0, str1, curr, chkDistinct);
        long a = chkDistinct.size();
        chkDistinct.clear();
        curr.delete(0, curr.length());
        
        helper(0, str2, curr, chkDistinct);
        long b = chkDistinct.size();
        
        if(b > a) return str2;
        return str1;
    }
}

//optimized solution in dp