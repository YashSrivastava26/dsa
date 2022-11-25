

class Solution {
    int numberOfSubArrayWithLargestSum(int[] arr, int n, int mid){
        int count = 1;
        int currSum = arr[0];

        for (int i = 1; i < n; i++) {
            currSum += arr[i];
            if(currSum > mid){
                count++;
                currSum = arr[i];
            }
        }
        return count;
    }

    public int splitArray(int[] nums, int k) {
        int n = nums.length;

        if(k > n) return -1;
        
        int low = nums[0];
        int high = nums[0];
        for (int i = 1; i < n; i++) {
            low = Math.max(low, nums[i]);
            high += nums[i];
        }

        int ans = 0;
        while(low <= high){
            int mid = (low + high) >> 1;

            int count = numberOfSubArrayWithLargestSum(nums, n, mid);
            if(count > k) low = mid + 1;
            else{
                ans = mid;
                high = mid - 1;
            }
        }
        return ans;
    }
}