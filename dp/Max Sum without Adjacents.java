// class Solution {
    
//     private int memoization(int[] arr, int n, int dp[]){
//         if(n == 0){
//             return arr[0];
//         }
//         if(n == 1){
//             return Math.max(arr[1], arr[0]);
//         }
//         if(dp[n] != -1){
//             return dp[n];
//         }
//         int pick = arr[n] + memoization(arr, n - 2, dp);
//         int notpick = 0 +  memoization(arr,  n - 1, dp);
//         int ans = Math.max(pick, notpick);
        
//         return dp[n] = ans;
//     }
    
//     int findMaxSum(int arr[], int n) {
//         int dp[] = new int[n];
//         Arrays.fill(dp, -1);
        
//         return memoization(arr, n - 1, dp);
//     }
// }

//tabulation
// class Solution {
    
//     int findMaxSum(int arr[], int n) {
//         if(n == 1){
//             return arr[0];
//         }
//         int dp[] = new int[n];
//         dp[0] = arr[0];
//         dp[1] = Math.max(arr[1], arr[0]);
        
//         for(int i = 2; i < n; i++){
//             int pick = arr[i] + dp[i - 2];
//             int notpick = 0 +  dp[i - 1];
//             dp[i] = Math.max(pick, notpick);
//         }
        
//         return dp[n - 1];
   
//     }
// }



class Solution {
    
    int findMaxSum(int arr[], int n) {
        int prev1_notpick = arr[0];
        int prev2_pick = 0;
        
        for(int i = 1; i < n; i++){
            int pick = arr[i] + prev2_pick;
            int notpick = 0 +  prev1_notpick;
            int curr = Math.max(pick, notpick);
            
            prev2_pick = prev1_notpick;
            prev1_notpick = curr;
        }
        
        return prev1_notpick;
    }
}