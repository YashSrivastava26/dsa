// class Solution{
    
//     private int memoization(int[] arr, int k, int n, int[] dp){
//         if(n == 0){
//             return 0;
//         }
        
//         if(n == 1){
//             return Math.abs(arr[1] - arr[0]);
//         }
//         if(dp[n] != -1){
//             return dp[n];
//         }
        
//         int minEnergy = Integer.MAX_VALUE;
//         for(int i = 1; i <= k; i++){
//             int idxLand = n - i;
//             if(idxLand >= 0){
//                 int curr = Math.abs(arr[n] - arr[idxLand]) + memoization(arr, k, idxLand, dp);
//                 minEnergy = Math.min(minEnergy, curr);
//             }
//         }
//         return dp[n] = minEnergy;
//     }
    
//     public int minimizeCost(int arr[],int n,int k){
//         int dp[] = new int[n];
//         Arrays.fill(dp, -1);
        
//         return memoization(arr, k, n - 1, dp);
//     }
// }


class Solution{
    
    public int minimizeCost(int arr[],int n,int k){
        int dp[] = new int[n];
        dp[0] = 0;
        dp[1] = Math.abs(arr[1] - arr[0]);
        
        for(int i = 2; i < n; i++){
            dp[i] = Integer.MAX_VALUE;
            for(int j = 1; j <= k; j++){
                int idxLand = i - j;
                if(idxLand >= 0 && idxLand >= 0){
                    int curr = Math.abs(arr[i] - arr[idxLand]) + dp[idxLand];   
                    dp[i] = Math.min(dp[i], curr);
                }
            }
        }
        
        return dp[n - 1];
    }
}