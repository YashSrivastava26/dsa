import java.util.*;
class Solution {

    private boolean check(String s1, String s2){
        // System.out.println(s1 + " " + s2);
        if(s1.length() != s2.length() + 1){
            return false;
        }
        int n = s1.length();
        boolean found = false;

        int i = 0, j = 0;
        while(i < n && j < n - 1){
            if(s1.charAt(i) == s2.charAt(j)){
                j++;
                i++;
            }
            else if(!found){
                i++;
                found = true;
            }
            else{
                return false;
            }
        }
        return true;
    }

    public int longestStrChain(String[] words) {
        int n = words.length;
        Arrays.sort(words, (a, b) -> a.length() - b.length());

        int maxLen[] = new int[n];
        Arrays.fill(maxLen, 1);

        int maxi = 1;
        for(int i = 1; i < n; i++){
            for(int j = 0; j < i; j++){
            // System.out.println(words[i] + " " + words[j] + " " + check(words[i], words[j]));

                if(maxLen[i] < maxLen[j] + 1 && check(words[i], words[j])){
                    maxLen[i] = maxLen[j] + 1;
                }
            }
            maxi = Math.max(maxi, maxLen[i]);
            // System.out.println(maxLen[i]);
        }
        return maxi;
    }
}