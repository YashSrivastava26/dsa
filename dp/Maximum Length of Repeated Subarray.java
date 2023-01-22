// // class Solution {
// //     public int findLength(int[] nums1, int[] nums2) {
// //         int n = nums1.length, m = nums2.length;
// //         int ans = Integer.MIN_VALUE;
// //         int dp[][] = new int[n + 1][m + 1];
// //         for(int i = 1; i < n + 1; i++){
// //             for(int j = 1; j < m + 1; j++){
// //                 if(nums1[i - 1] == nums2[j - 1]){
// //                     dp[i][j] = 1 + dp[i - 1][j - 1];
// //                 }
// //                 ans = Math.max(ans, dp[i][j]);
// //                 // System.out.print(dp[i][j] + " ");
// //             }
// //             // System.out.println();

// //         }
// //         return ans;
// //     }
// // }


// class Solution {
//     public int findLength(int[] nums1, int[] nums2) {
//         int n = nums1.length, m = nums2.length;
//         int ans = Integer.MIN_VALUE;
//         int prev[] = new int[m + 1];
//         for(int i = 1; i < n + 1; i++){
//             int curr[] = new int[m + 1];
//             for(int j = 1; j < m + 1; j++){
//                 if(nums1[i - 1] == nums2[j - 1]){
//                     curr[j] = 1 + prev[j - 1];
//                 }
//                 ans = Math.max(ans, curr[j]);
//                 // System.out.print(dp[i][j] + " ");
//             }
//             prev = curr;
//             // System.out.println();
//         }
//         return ans;
//     }
// }


class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        int ans = Integer.MIN_VALUE;
        int prev[] = new int[m + 1];
        for(int i = 1; i < n + 1; i++){
            for(int j = m; j >= 1; j--){
                if(nums1[i - 1] == nums2[j - 1]){
                    prev[j] = 1 + prev[j - 1];
                }
                else{
                    prev[j] = 0;
                }
                ans = Math.max(ans, prev[j]);
                // System.out.print(prev[j] + " ");
            }
            // System.out.println();
        }
        return ans;
    }
}