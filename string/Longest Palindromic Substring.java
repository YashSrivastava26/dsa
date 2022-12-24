class Solution {

    private int expandAroundCenter(String s, int left, int right){
        int n = s.length();
        while(left >= 0 && right < n && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        return right - left - 1;
    }

    public String longestPalindrome(String s) {
        int n = s.length();
        if(n <= 1) return s;
        int start = 0, end = 0;
        int len = 0;
        for(int i = 0; i < n; i++){
            int lenOddPal = expandAroundCenter(s, i, i); 
            int lenEvenPal = expandAroundCenter(s, i, i + 1); 
            len = Math.max(lenOddPal, lenEvenPal);
            if(len > end - start + 1){
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        
        return s.substring(start, end + 1);
    }
}