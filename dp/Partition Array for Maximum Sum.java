// class Solution {

//     private int tryAllPartation(int i, int arr[], int k, int[] dp){

//         if(i >= arr.length){
//             return 0;
//         }

//         if(dp[i] != -1){
//             return dp[i];
//         }

//         int prod = Integer.MIN_VALUE;
//         int mult = arr[i];
//         for(int j = 0; j < k; j++){
//             if(i + j < arr.length){
//                 mult = Math.max(mult, arr[i + j]);
//                 int curr = (j + 1) * mult + tryAllPartation(i + j + 1, arr, k, dp);
//                 prod = Math.max(curr, prod);
//             }
//         }
        
//         return dp[i] = prod;
//     }

//     public int maxSumAfterPartitioning(int[] arr, int k) {
//         int dp[] = new int[arr.length];
//         Arrays.fill(dp, -1);
//         return tryAllPartation(0, arr, k, dp);
//     }
// }


class Solution {

    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int dp[] = new int[n + k];

        for(int i = n - 1; i >= 0; i--){
            int prod = Integer.MIN_VALUE;
            int mult = arr[i];
            for(int j = 0; j < k; j++){
                if(i + j < n){
                    mult = Math.max(mult, arr[i + j]);
                    int curr = (j + 1) * mult + dp[i + j + 1];
                    prod = Math.max(curr, prod);
                }
            }
            dp[i] = prod;
        }
        return dp[0];
    }
}