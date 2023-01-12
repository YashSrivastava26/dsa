// class Solution
// {
//     //Function to find the maximum money the thief can get.
    
//     private int memoization(int[] arr, int idx, int[] dp){
//         if(idx == 0){
//             return arr[0];
//         }
//         if(idx < 0){
//             return 0;
//         }
        
//         if(dp[idx] != -1){
//             return dp[idx];
//         }
        
//         int pick = arr[idx] + memoization(arr, idx - 2, dp);
//         int notpick = 0 + memoization(arr, idx - 1, dp);
        
//         return dp[idx] = Math.max(pick, notpick);
//     }
    
//     public int FindMaxSum(int arr[], int n)
//     {
//         int dp[] = new int[n];
//         Arrays.fill(dp, -1);
        
//         return memoization(arr, n - 1, dp);
//     }
// }


//tabulation
// class Solution
// {
    
//     public int FindMaxSum(int arr[], int n)
//     {
//         if(n == 1){
//             return arr[0];
//         }
//         int dp[] = new int[n];
        
//         dp[0] = arr[0];
//         dp[1] = Math.max(arr[1], arr[0]);
        
//         for(int i = 2; i < n; i++){
//             int pick = arr[i] + dp[i - 2];
//             int notpick = 0 + dp[i - 1];
        
//             dp[i] = Math.max(pick, notpick);
//         }
        
//         return dp[n - 1];
//     }
// }

//space optimization
class Solution
{
    
    public int FindMaxSum(int arr[], int n)
    {
        
        int prev2_pick = 0;
        int prev1_notpick = arr[0];
        for(int i = 1; i < n; i++){
            int pick = arr[i] + prev2_pick;
            int notpick = 0 + prev1_notpick;
        
            int curr = Math.max(pick, notpick);
            prev2_pick = prev1_notpick;
            prev1_notpick = curr;
            
        }
        
        return prev1_notpick;
    }
}