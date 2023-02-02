class Solution{
    
    static int partationDP(int left, int right, String s, int makeTrue, int[][][] dp){
        
        if(left == right){
            if(makeTrue == 1 && s.charAt(left) == 'T'){
                return 1;
            }
            else if(makeTrue == 0 && s.charAt(left) == 'F'){
                return 1;
            }
            return 0;
        }
        if(left > right){
            return 0;
        }
        
        if(dp[left][right][makeTrue] != -1){
            return dp[left][right][makeTrue];
        }
        
        int ans = 0;
        for(int i = left + 1; i < right; i = i + 2){
            int leftTrue = partationDP(left, i - 1, s, 1, dp);
            int rightTrue = partationDP(i + 1, right, s, 1, dp);
            int leftFalse = partationDP(left, i - 1, s, 0, dp);
            int rightFalse = partationDP(i + 1, right, s, 0, dp);
            if(s.charAt(i) == '&'){
                if(makeTrue == 1){
                    ans += leftTrue * rightTrue;
                }
                else{
                    ans += leftTrue * rightFalse + leftFalse * rightTrue + leftFalse * rightFalse;
                }
            }
            else if(s.charAt(i) == '^'){
                if(makeTrue == 1){
                    ans += leftTrue * rightFalse + leftFalse * rightTrue;
                }
                else{
                    ans += leftTrue * rightTrue + leftFalse * rightFalse;
                }
            }
            else if(s.charAt(i) == '|'){
                if(makeTrue == 1){
                    ans += leftTrue * rightTrue + leftTrue * rightFalse + leftFalse * rightTrue;
                }
                else{
                    ans += leftFalse * rightFalse;
                }
            }
        }
        return dp[left][right][makeTrue] = ans % 1003;
    }
    
    static int countWays(int N, String S){
        int dp[][][] = new int[N + 1][N + 1][2];
        for(int i = 0; i < N + 1; i++){
            for(int j = 0; j < N + 1; j++){
                dp[i][j][0] = -1;
                dp[i][j][1] = -1;
            }
        }
        
        return partationDP(0, N - 1, S, 1, dp);
    }
}