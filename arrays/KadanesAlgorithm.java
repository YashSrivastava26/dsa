
// class Solution{

//     // arr: input array
//     // n: size of array
//     //Function to find the sum of contiguous subarray with maximum sum.
//     long maxSubarraySum(int arr[], int n){
        
//         int sum = 0, maxi = arr[0];
//         for (int i = 0; i < arr.length; i++) {
//             sum += arr[i];
            
//             maxi = Math.max(maxi, sum);
//             if(sum < 0) sum = 0;
//         }
//         return maxi;
        
//     }
    
// }



//recursion
// class Solution{

//     int recursiveFn(int[] arr, int idx, boolean mustPick){
//         if(idx >= arr.length) return 0;
        
//         if(mustPick)
//             return Math.max(0, arr[idx] + recursiveFn(arr, idx + 1, true));
//         return Math.max(recursiveFn(arr, idx + 1, false), arr[idx] + recursiveFn(arr, idx + 1, true));
//     }

//     int maxSubarraySum(int[] arr){
//         int dp[][] = new int[2][arr.length];
//         for (int[] is : dp) {
//             Arrays.fill(is, -1);
//         }
//         return recursiveFn(arr, 0, false);
//     }
// }

// memoization
// class Solution{

//     int recursiveFn(int[] arr, int idx, boolean mustPick, int[] dp){
//         if(idx >= arr.length) return 0;
        
//         if(dp[idx] != -1 && mustPick) return dp[idx];

//         dp[idx] = arr[idx] + recursiveFn(arr, idx + 1, true, dp);
//         if(mustPick)
//             return Math.max(0, dp[idx]);
//         return Math.max(recursiveFn(arr, idx + 1, false, dp), dp[idx]);
//     }

//     int maxSubarraySum(int[] arr){
//         int dp[] = new int[arr.length];
//         Arrays.fill(dp, -1);
//         return recursiveFn(arr, 0, false,dp);
//     }
// }


// tabulation
// class Solution{

//     int maxSubarraySum(int[] arr){
//         int dp[] = new int[arr.length];
//         dp[0] = arr[0];
//         for (int i = 1; i < dp.length; i++) {
//             dp[i] = Math.max(arr[i], arr[i] + dp[i - 1]);
//         }
//         int maxi = dp[0];
//         for (int i = 1; i < dp.length; i++) {
//             maxi = Math.max(maxi, dp[i]);
//         }
//         return maxi;
//     }
// }

//space optimizaton
class Solution{

    int maxSubarraySum(int[] arr){
        int prev = arr[0], maxi = Integer.MIN_VALUE;
        for (int i = 1; i < arr.length; i++) {
            int curr = Math.max(arr[i], arr[i] + prev);
            maxi = Math.max(maxi, curr);
            prev = curr;
        }
        return maxi;
    }
}

/**
 * KadanesAlgorithm
 */
public class KadanesAlgorithm {

    public static void main(String[] args) {
        int arr[] = {-2,1,-3,4,-1,2,1,-5,4};
        Solution s = new Solution();
        System.out.println(s.maxSubarraySum(arr));
    }
}
