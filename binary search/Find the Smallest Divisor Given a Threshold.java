// class Solution {

//     public long sumAfterDiv(int[] arr, int div){
//         long sum = 0;
//         for (int i = 0; i < arr.length; i++) {
//             sum += (long)Math.ceil((double)arr[i] / div);
//         }
//         return sum;
//     }

//     public int smallestDivisor(int[] nums, int threshold) {
//         int maxi = Integer.MIN_VALUE;
//         for (int i = 0; i < nums.length; i++) {
//             maxi = Math.max(maxi, nums[i]);
//         }

//         int low = 1, high = maxi, ans = -1;
//         while(low <= high){
//             int mid = low + (high - low) / 2;

//             long currSum = sumAfterDiv(nums, mid);
//             if(currSum <= threshold){
//                 ans = mid;
//                 high = mid - 1;
//             } 
//             else low = mid + 1;
//         }
//         return ans;
//     }
// }

// breaking for loop if sum > threshold
class Solution {

    public boolean isvalid(int[] arr, int div, int threshold){
        long sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += (long)((arr[i] + div - 1)/ div);
            if(sum > threshold) return false;

        }
        return true;
    }

    public int smallestDivisor(int[] nums, int threshold) {
        int maxi = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            maxi = Math.max(maxi, nums[i]);
        }

        int low = 1, high = maxi, ans = -1;
        while(low <= high){
            int mid = low + (high - low) / 2;;
            if(isvalid(nums, mid, threshold)){
                ans = mid;
                high = mid - 1;
            } 
            else low = mid + 1;
        }
        return ans;
    }
}