class Solution {
    
    private  void reverse(int[] arr, int start, int end){
        while(start < end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
    
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        k = n - k;
        if(k == 0) return;
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
        reverse(nums, 0, n - 1);
    }
}
