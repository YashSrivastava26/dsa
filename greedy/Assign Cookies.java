import java.util.*;
class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int n = g.length, m = s.length;
        int i = 0, j = 0;
        int ans = 0;
        while(i < n && j < m){
            if(g[i] <= s[j]){
                i++;
                j++;
                ans ++;
            }
            else{
                j++;
            }
        }

        return ans;
    }
}