import java.util.*;
class Solution{
    static List<Integer> get(int a,int b)
    {
        List<Integer> ans = new ArrayList<>();
        
        a ^= b;
        b ^= a;
        a ^= b;
        
        ans.add(a);
        ans.add(b);
        return ans;
    }
}