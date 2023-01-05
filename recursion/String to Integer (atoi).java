class Solution {
    private long atoi(String s, int i, int n, long ans){
        if(i == n) return ans;

        int digit = s.charAt(i) - '0';
        if(digit < 0 || digit > 9){
            return ans;
        }
        ans = (ans * 10) + digit;
        if(ans > (Integer.MAX_VALUE + 1l)){
            return Integer.MAX_VALUE + 1l;
        }
        return atoi(s, i + 1, n, ans);
    }
    public int myAtoi(String s) {
        s = s.trim();
        int n = s.length();
        if(n == 0) return 0;
        int mul = 1;
        long ans = 0;
        if(s.charAt(0) == '-'){
            ans = atoi(s, 1, n, ans);
            mul = -1;
        }
        else if(s.charAt(0) == '+'){
            ans = atoi(s, 1, n, 0);
            mul = 1;
        }
        else{
            ans = atoi(s, 0, n, ans);
            mul = 1;
        }
        ans *= mul;
        if(ans > Integer.MAX_VALUE){
            return Integer.MAX_VALUE;
        }
        else if(ans < Integer.MIN_VALUE){
            return Integer.MIN_VALUE;
        }
        else{
            return (int) ans;
        }
    }
}