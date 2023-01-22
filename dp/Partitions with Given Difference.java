class Solution{

    public int countPartitions(int n, int d, int arr[]){
        
        int sum = 0;
        for(int i = 0; i < n; i++){
	       sum += arr[i];
	    }
        
        int dp[][] = new int[n][sum + 1];
	    dp[0][0] = 1;
	    if(arr[0] <= sum){
	        dp[0][arr[0]] += 1;
	    } 
	    
	    int mod = (int)(1e9 + 7);
	    
	    for(int i = 1; i < n; i++){
	        for(int s = 0; s < sum + 1; s++){
	            int pick = 0;
                if(arr[i] <= s){
                    pick = dp[i - 1][s - arr[i]];
                }
                int notPick = dp[i - 1][s];
        
                dp[i][s] = (pick + notPick) % mod;
	        }
	    }
	    
	    int ans = 0;
	    for(int i = 0; i <= sum; i++){
	       if((sum - i) - i == d){
	           ans = dp[n - 1][i];
	       }
	    }
	    return ans;
    }
}