import java.util.Arrays;
//recursion
// class Solution{

//     static int mcm(int[] arr, int start, int end){
//         if(start == end) return 0;
//         int minOperation = (int) 1e9, opernationsUsed;
//         for (int patration = start; patration < end; patration++) {
//             int operationInCurrSteps = arr[start - 1] * arr[patration] * arr[end];
//             opernationsUsed = operationInCurrSteps + mcm(arr, start, patration) + mcm(arr, patration + 1, end);
//             minOperation = Math.min(opernationsUsed, minOperation);
//         }
//         return minOperation;
//     }

//     static int matrixMultiplication(int N, int arr[])
//     {
//         return mcm(arr, 1, N - 1);
//     }
// }

//memoization
// class Solution{

//     static int mcm(int[] arr, int start, int end, int[][] dp){
//         if(start == end) return 0;

//         if(dp[start][end] != -1) return dp[start][end];

//         int minOperation = (int) 1e9, opernationsUsed;
//         for (int patration = start; patration < end; patration++) {
//             int operationInCurrSteps = arr[start - 1] * arr[patration] * arr[end];
//             opernationsUsed = operationInCurrSteps + mcm(arr, start, patration, dp) + mcm(arr, patration + 1, end, dp);
//             minOperation = Math.min(opernationsUsed, minOperation);
//         }
//         return dp[start][end] = minOperation;
//     }

//     static int matrixMultiplication(int N, int arr[])
//     {
//         int dp[][] = new int[N][N];
//         for (int[] is : dp) {
//             Arrays.fill(is, -1);
//         }
//         return mcm(arr, 1, N - 1, dp);
//     }
// }

//tabulation
class Solution{

    static int matrixMultiplication(int N, int arr[])
    {
        int dp[][] = new int[N][N];
        for (int i = 0; i < N; i++) {
            dp[i][i] = 0;
        }
        for (int start = N - 1; start > 0; start--) {
            for (int end = start + 1; end < N; end++) {
                int minOperation = (int) 1e9;
                for (int patration = start; patration < end; patration++) {
                    int opernationsUsed = arr[start - 1] * arr[patration] * arr[end] + dp[start][patration] + dp[patration + 1][end];
                    minOperation = Math.min(opernationsUsed, minOperation);
                }
                dp[start][end] = minOperation;
            }
        }
        return dp[1][N - 1];
    }
}