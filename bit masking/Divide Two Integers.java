class Solution {
    public int divide(int dividend, int divisor) {
        if(dividend == Integer.MIN_VALUE && divisor == -1){
            return Integer.MAX_VALUE;
        }
        int divd = Math.abs(dividend);
        int div = Math.abs(divisor);

        int ans = 0;
        while(divd - div >= 0){
            int i = 0;

            while(divd - (div << 1 << i) >= 0){//dont do div<<(i + 1) it will overflow and get back to loop of Integer but it will excreed 32 bit in case of overflow making 32 bit as 0
                i++;
            }
            ans += (1 << i);
            divd -= (div << i);

        }
        if(dividend < 0 == divisor < 0){
            return ans;
        }
        return ~ans + 1;
    }
}