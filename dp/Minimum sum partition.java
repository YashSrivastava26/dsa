class Solution
{

	public int minDifference(int arr[], int N) 
	{
	    int sum = 0;
	    for(int i = 0; i < N; i++){
	        sum += arr[i];    
	    }
	    
        boolean dp[][] = new boolean[N][sum + 1];
        
        for(int i = 0; i < N; i++){
            dp[i][0] = true;
        }
        
        if(arr[0] <= sum){
            dp[0][arr[0]] = true;
        }
        
        for(int i = 1; i < N; i++){
            for(int s = 1; s < sum + 1; s++){
                
                boolean pick = false;
                if(s >= arr[i]){
                    pick = dp[i - 1][s - arr[i]];
                }
                
                boolean notpick = dp[i - 1][s];
                   
                dp[i][s] = pick | notpick;
            }
        }
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i <= sum / 2; i++){
            if(dp[N - 1][i]){
                int curr = Math.abs((sum - i) - i);
                ans = Math.min(ans, curr);
            }
        }
        return ans;
	} 
}