// class Solution{
    
//     private int memozation(int[] arr, int[] dp, int n){
//         if(n == 0){
//             return 0;
//         }
        
//         if(n == 1){
//             return Math.abs(arr[1] - arr[0]);
//         }
        
//         if(dp[n] != -1){
//             return dp[n];
//         }
        
//         int oneStep = Math.abs(arr[n] - arr[n - 1]) + memozation(arr, dp, n - 1);
//         int twoStep = Math.abs(arr[n] - arr[n - 2]) + memozation(arr, dp, n - 2);
        
//         return dp[n] = Math.min(oneStep, twoStep);
//     }
    
//     public int minimumEnergy(int arr[],int N){
//         int[] dp = new int[N];
//         Arrays.fill(dp, -1);
        
//         return memozation(arr, dp, N - 1);
//     }
// }


//tabulation
// class Solution{
    
//     public int minimumEnergy(int arr[],int N){
//         int[] dp = new int[N];
        
//         dp[0] = 0;
//         dp[1] = Math.abs(arr[1] - arr[0]);
        
//         for(int i = 2; i < N; i++){
//             int oneStep = Math.abs(arr[i] - arr[i - 1]) + dp[i - 1];
//             int twoStep = Math.abs(arr[i] - arr[i - 2]) + dp[i - 2];
        
//             dp[i] = Math.min(oneStep, twoStep);
//         }
//         return dp[N - 1];
        
//     }
// }



//space optimization
class Solution{
    
    public int minimumEnergy(int arr[],int N){
        
        int last2Energy = 0, last1Energy =  Math.abs(arr[1] - arr[0]);
        
        for(int i = 2; i < N; i++){
            int oneStep = Math.abs(arr[i] - arr[i - 1]) + last1Energy;
            int twoStep = Math.abs(arr[i] - arr[i - 2]) + last2Energy;
            
            last2Energy = last1Energy;
            last1Energy = Math.min(oneStep, twoStep);
        }
        return last1Energy;
    }
}