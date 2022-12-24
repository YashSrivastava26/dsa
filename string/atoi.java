class Solution {

    boolean isValid(int a){
        if(a >= 0 && a <= 9) return true;
        return false;
    }
    public int myAtoi(String s) {
        s = s.trim();
        int n = s.length();
        if(n == 0) return 0;
        int i = 0, mul = 1;
        if(s.charAt(0) == '-') {
            mul = -1;
            i++;
        }
        
        else if(s.charAt(0) == '+') i++;

        long ans = 0;
        for(; i < n; i++){
            int digitAtI = s.charAt(i) - '0';
            if(!isValid(digitAtI)){
                break;
            }
            ans = ans * 10 + digitAtI;
            long temp = ans * mul;
            
            if(temp > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            if(temp < Integer.MIN_VALUE) return Integer.MIN_VALUE;


        }
        
        ans = ans * mul;
        return (int) ans;
    }
}