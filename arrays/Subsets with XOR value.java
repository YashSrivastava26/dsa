// class Solution{
//     static int findXOR(int[] arr, int xor, int idx, int target){
//         if(idx < 0) {
//             if(xor == target) return 1;
//             return 0;
//         }

//         //take
//         int take = findXOR(arr, xor ^ arr[idx], idx - 1, target);
//         int notTake = findXOR(arr, xor, idx - 1, target);
//         return take + notTake;

//     }

//     static int subsetXOR(int arr[], int N, int K) {
//         return findXOR(arr, 0, N - 1, K);    
//     }
// }

// memoization
// class Solution{
//     static int findXOR(int[] arr, int xor, int idx, int target, int[][] dp){
//         if(idx < 0) {
//             if(xor == target) return 1;
//             return 0;
//         }

//         if(dp[xor][idx] != -1) return dp[xor][idx];
//         int take = findXOR(arr, xor ^ arr[idx], idx - 1, target, dp);
//         int notTake = findXOR(arr, xor, idx - 1, target, dp);
//         return dp[xor][idx] =  take + notTake;

//     }

//     static int subsetXOR(int arr[], int N, int K) {
//         int maxi = Integer.MIN_VALUE;
//         for(int i = 0; i < arr.length; i++){
//             maxi = Math.max(maxi, arr[i]);
//         }
//         int maxXor =10 * maxi;
//         int dp[][] = new int[maxXor + 1][N + 1];
//         for(int i = 0; i < maxXor; i++)
//             Arrays.fill(dp[i], -1);
//         return findXOR(arr, 0, N - 1, K, dp);    
//     }
// }

//tabulation

class Solution{
    static int findXOR(int[] arr, int xor, int idx, int target, int[][] dp){
        if(idx < 0) {
            if(xor == target) return 1;
            return 0;
        }

        if(dp[xor][idx] != -1) return dp[xor][idx];
        int take = findXOR(arr, xor ^ arr[idx], idx - 1, target, dp);
        int notTake = findXOR(arr, xor, idx - 1, target, dp);
        return dp[xor][idx] =  take + notTake;

    }

    static int subsetXOR(int arr[], int N, int K) {
        int maxi = Integer.MIN_VALUE;
        for(int i = 0; i < arr.length; i++){
            maxi = Math.max(maxi, arr[i]);
        }
        int maxXor =10 * maxi;
        int dp[][] = new int[maxXor + 1][N + 1];
        for(int i = 0; i < maxXor; i++)
            Arrays.fill(dp[i], -1);
        return findXOR(arr, 0, N - 1, K, dp);    
    }
}


