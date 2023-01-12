class Solution {

    static long dp[] = new long[1001];
    static int mod = (int)(1e9 + 7);
    static long topDown(int n) {
        if(n <= 1) return n;
        if(dp[n] != 0){
            return dp[n] % mod;
        }
        
        return dp[n] = (topDown(n - 1) + topDown(n - 2)) % mod;
    }

    static long bottomUp(int n) {
        if(n <= 1) return n;
        
        long prev2 = 0, prev1 = 1, ans = 0;
        for(int i = 2; i <= n; i++){
            ans = (prev2 + prev1) % mod;
            prev2 = prev1;
            prev1 = ans;
        }
        return ans  % mod;
        
    }
}