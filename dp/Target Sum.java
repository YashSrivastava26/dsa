

// // //User function Template for Java

// // class Solution {
// //     private static int memoization(int i, int S1, int[] A, int[][] dp){
// //         if(i == 0){
// //             if(A[0] == 0 && S1 == 0) return 2;
// //             if(S1 == 0 || S1 == A[0]) return 1;
// //             return 0;
// //         }   
        
// //         if(dp[i][S1] != -1){
// //             return dp[i][S1];
// //         }
        
// //         int pick = 0;
// //         if(A[i] <= S1){
// //             pick = memoization(i - 1, S1 - A[i], A, dp);
// //         }
// //         int notPick = memoization(i - 1, S1, A, dp);
        
// //         // System.out.println(i + " " + S1 + " " + pick +" "+ notPick);
// //         return dp[i][S1] = pick + notPick;
// //     }
    
// //     static int findTargetSumWays(int[] A , int N, int target) {
// //         int sum = 0;
// //         for(int i = 0; i < N; i++){
// //             sum += A[i];
// //         }
        
// //         if(sum - target < 0 || (sum - target) % 2 == 1){
// //             return 0;
// //         }
// //         int S1 = (sum - target) / 2;
// //         int dp[][] = new int[N][S1 + 1];
// //         for(int[] it : dp){
// //             Arrays.fill(it, -1);
// //         }
// //         // System.out.println(S1);
// //         return memoization(N - 1, S1, A, dp);
// //     }
// // };





// //User function Template for Java

// class Solution {
    
//     static int findTargetSumWays(int[] A , int N, int target) {
//         int sum = 0;
//         for(int i = 0; i < N; i++){
//             sum += A[i];
//         }
        
//         if(sum - target < 0 || (sum - target) % 2 == 1){
//             return 0;
//         }
        
//         int S1 = (sum - target) / 2;
//         int dp[][] = new int[N][S1 + 1];
//         if(A[0] == 0){
//             dp[0][0] = 2;
//         }
//         else {
//             dp[0][0] = 1;
            
//         }
        
//         if(A[0] != 0 && A[0] <= S1){
//             dp[0][A[0]] = 1;
//         }
        
//         for(int i = 1; i < N; i++){
//             for(int s1 = 0; s1 < S1 + 1; s1++){
//                 int pick = 0;
//                 if(A[i] <= s1){
//                     pick = dp[i - 1][s1 - A[i]];
//                 }
//                 int notPick = dp[i - 1][s1];
        
//                 dp[i][s1] = pick + notPick;
//             }
//         }
//         // System.out.println(S1);
//         return dp[N - 1][S1];
//     }
// };


class Solution {
    
    static int findTargetSumWays(int[] A , int N, int target) {
        int sum = 0;
        for(int i = 0; i < N; i++){
            sum += A[i];
        }
        
        if(sum - target < 0 || (sum - target) % 2 == 1){
            return 0;
        }
        
        int S1 = (sum - target) / 2;
        int prev[] = new int[S1 + 1];
        if(A[0] == 0){
            prev[0] = 2;
        }
        else {
            prev[0] = 1;
            
        }
        
        if(A[0] != 0 && A[0] <= S1){
            prev[A[0]] = 1;
        }
        
        for(int i = 1; i < N; i++){
            int curr[] = new int[S1 + 1];
            for(int s1 = 0; s1 < S1 + 1; s1++){
                int pick = 0;
                if(A[i] <= s1){
                    pick = prev[s1 - A[i]];
                }
                int notPick = prev[s1];
        
                curr[s1] = pick + notPick;
            }
            prev = curr;
        }
        // System.out.println(S1);
        return prev[S1];
    }
};