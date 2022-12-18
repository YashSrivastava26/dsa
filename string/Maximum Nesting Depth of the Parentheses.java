class Solution {
    public int maxDepth(String s) {
        int n = s.length();

        int count = 0, maxi = 0;
        for(int i = 0; i < n; i++){
            if(s.charAt(i) == '(') count++;
            else if(s.charAt(i) == ')') count--;

            maxi = Math.max(maxi, count);
        }
        return maxi;
    }
}