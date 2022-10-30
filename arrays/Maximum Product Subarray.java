// //Two Traversals approach
// class Solution {
//     public int maxProduct(int[] nums) {
//         int maxi = Integer.MIN_VALUE, prod = 1;
//         for (int i = 0; i < nums.length; i++) {
//             prod *= nums[i];
//             maxi = Math.max(maxi, prod);
//             if(nums[i] == 0){
//                 prod = 1;
//             }
//         }
//         prod = 1;
//         for (int i = nums.length - 1; i >= 0; i--) {
//             prod *= nums[i];
//             maxi = Math.max(maxi, prod);
//             if(nums[i] == 0){
//                 prod = 1;
//             }
//         }
//         return maxi;
//     }
// }

//kadane algorithm approach

class Solution {
    // Function to find maximum product subarray
    long maxProduct(int[] arr, int n) {
        long prod1 = arr[0], prod2 = arr[0], result = arr[0];

        for (int i = 1; i < arr.length; i++) {
            long temp = Math.max(arr[i], Math.max(prod1 * (long)arr[i], prod2 * (long)arr[i]));
            prod2 = Math.min(arr[i], Math.min(prod1 * (long)arr[i], prod2 * (long)arr[i]));
            prod1 = temp;

            result = Math.max(result, prod1);
        }
        return result;
    }
}
