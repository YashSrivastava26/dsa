class Solution {

    private long powUnderMod(long n, int x){
        long ans = 1;
        long base = x;
        int mod = (int) 1e9 + 7;
        while(n > 0){
            if((n & 1) == 1){
                ans = ans * base;
                ans %= mod;
                n -= 1;
            }
            else{
                base *= base;
                base %= mod; 
                n /= 2;
            }
        }
        return ans;
    }

    public int countGoodNumbers(long n) {
        long ans = 1;
        int mod = (int) 1e9 + 7;
        long oddNoInRange = n / 2;
        long evenNoInRange = (n + 1) / 2;
        ans *= powUnderMod(oddNoInRange, 4);
        ans *= powUnderMod(evenNoInRange, 5);
        ans %= mod;
        return (int)ans;
    }
}