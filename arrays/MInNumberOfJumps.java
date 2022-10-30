
// recirsion
// class Solution{

//     static int jump(int idx, int[] arr){
//         if(idx >= arr.length) return 0;

//         int minCount = (int)1e9;
//         for (int i = 1; i <= arr[idx]; i++) {
//             minCount = Math.min(minCount, jump(idx + i, arr) + 1);
//         }
//         return minCount;
//     }

//     static int minJumps(int[] arr){
//         return jump(0, arr);
//     }
// }


// memoization
// class Solution{

//     static int jump(int idx, int[] arr, int[] dp){
//         if(idx >= arr.length) return 0;

//         if(dp[idx] != -1) return dp[idx];

//         int minCount = (int)1e9;
//         for (int i = 1; i <= arr[idx]; i++) {
//             minCount = Math.min(minCount, jump(idx + i, arr, dp) + 1);
//         }
//         return dp[idx] = minCount;
//     }

//     static int minJumps(int[] arr){
//         int[] dp = new int[arr.length];
//         Arrays.fill(dp, -1);
//         return jump(0, arr, dp);
//     }
// }


// // memoization (top down)
// class Solution{

//     static int jump(int idx, int[] arr, int[] dp){
//         if(idx <= 0) return 0;

//         if(dp[idx] != -1) return dp[idx];

//         int minCount = (int)1e9;
//         for (int i = 1; i <= arr[idx]; i++) {
//             minCount = Math.min(minCount, jump(idx - i, arr, dp) + 1);
//         }
//         return dp[idx] = minCount;
//     }

//     static int minJumps(int[] arr){
//         int[] dp = new int[arr.length];
//         Arrays.fill(dp, -1);
//         return jump(arr.length - 1, arr, dp);
//     }
// }

//tabulation
// class Solution{

//     static int minJumps(int[] arr){
//         int[] dp = new int[arr.length];
//         dp[0] = 0;

//         for (int idx = 1; idx < dp.length; idx++) {
//             dp[idx] = (int) 1e9;
//             for (int step = 1; step <= arr[idx]; step++) {
//                 if((idx - step) < 0) break;// break
//                 else dp[idx] = Math.min(dp[idx], dp[idx - step] + 1);
//             }
//         }
//         return dp[arr.length - 1];
//     }
// }


// no space optimization as we need arr[idx-step] values to compute dp[idx] value and step can range to array full length
// class Solution{

//     static int minJumps(int[] arr){
//         int[] dp = new int[arr.length];
//         dp[0] = 0;

//         for (int idx = 0; idx < dp.length; idx++) {
//             dp[idx] = (int) 1e9;
//             for (int step = 1; step <= arr[idx]; step++) {
//                 if((idx - step) < 0) dp[idx] = 0;
//                 else dp[idx] = Math.min(dp[idx], dp[idx - step] + 1);
//             }
//         }
//         return dp[arr.length - 1];
//     }
// }

// observation base(taking three variable)

// class Solution{
//     static int minJumps(int[] arr){
//         int maxReach = arr[0];
//         int step = arr[0];
//         int jump = 1;
        
//         if(arr.length == 1) return 0;
//         else if(arr[0] == 0) return -1;

//         else{
//             for (int i = 1; i < arr.length; i++) {
//                 if(i == arr.length - 1) return jump;
//                 maxReach = Math.max(maxReach, arr[i] + i);
//                 step --;
//                 if(step == 0){
//                     jump ++;
//                     if(i > maxReach) return -1;
//                     step = maxReach - i;
//                 }
//             }
//         }
//          return -1;
//     }
// }