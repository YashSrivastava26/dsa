

// //User function Template for Java

// class Solution{

//     private static boolean tryAllPossibleWays(int i, int arr[], int sum, Boolean dp[][]){
//         if(sum == 0){
//             return true;
//         }
        
//         if(i == 0){
//             if(sum - arr[0] == 0){
//                 return true;
//             }
//             return false;
//         }
        
//         if(dp[i][sum] != null){
//             return dp[i][sum];
//         }
//         //pick
//         if(sum >= arr[i] && tryAllPossibleWays(i - 1, arr, sum - arr[i], dp)){
//             return dp[i][sum] = true;
//         }
//         //notpick
//         if(tryAllPossibleWays(i - 1, arr, sum, dp)){
//             return dp[i][sum] = true;
//         }
//         return dp[i][sum] = false;
//     }

//     static Boolean isSubsetSum(int N, int arr[], int sum){
//         Boolean dp[][] = new Boolean[N][sum + 1];
//         for(Boolean[] row : dp){
//             Arrays.fill(row, null);
//         }
//         return tryAllPossibleWays(N - 1, arr, sum, dp);
//     }
// }


//tabulation



//User function Template for Java

// class Solution{

//     static Boolean isSubsetSum(int N, int arr[], int sum){
//         boolean dp[][] = new boolean[N][sum + 1];
        
//         for(int i = 0; i < N; i++){
//             dp[i][0] = true;
//         }
        
//         if(arr[0] <= sum){
//             dp[0][arr[0]] = true;
//         }
        
//         for(int i = 1; i < N; i++){
//             for(int s = 1; s < sum + 1; s++){
                
//                 boolean pick = false;
//                 if(s >= arr[i]){
//                     pick = dp[i - 1][s - arr[i]];
//                 }
                
//                 boolean notpick = dp[i - 1][s];
                   
//                 dp[i][s] = pick | notpick;
//             }
//         }
//         return dp[N - 1][sum];
//     }
// }

//space optimization
class Solution{
    static Boolean isSubsetSum(int N, int arr[], int sum){
        boolean prev[] = new boolean[sum + 1];
        
        prev[0] = true;
        if(arr[0] <= sum){
            prev[arr[0]] = true;
        }
        
        for(int i = 1; i < N; i++){
            boolean curr[] = new boolean[sum + 1];
            for(int s = 1; s < sum + 1; s++){
                
                boolean pick = false;
                if(s >= arr[i]){
                    pick = prev[s - arr[i]];
                }
                
                boolean notpick = prev[s];
                   
                curr[s] = pick | notpick;
            }
            prev = curr;
        }
        return prev[sum];
    }
}