class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums2.length < nums1.length)
            return findMedianSortedArrays(nums2, nums1);
        
        int n = nums1.length, m = nums2.length;        
        int k = (nums1.length + nums2.length) / 2 + 1;

        int high = Math.min(n, k), low = Math.max(0, k - m);
        while(low <= high){
            int cut1 = low + (high - low) / 2;
            int cut2 = k - cut1;

            int l1 = cut1 == 0 ? Integer.MIN_VALUE : nums1[cut1 - 1];
            int l2 = cut2 == 0 ? Integer.MIN_VALUE : nums2[cut2 - 1];
            int r1 = cut1 == n ? Integer.MAX_VALUE : nums1[cut1];
            int r2 = cut2 == m ? Integer.MAX_VALUE : nums2[cut2];

            if(l1 <= r2 && l2 <= r1){
                if((n + m) % 2 == 1) return Math.max(l1, l2);
                else {
                    double ans = (double)(l1 + l2) / 2.0;
                    if(cut1 > 1)
                        ans = Math.max(ans, (double)(nums1[cut1 - 2] + l1) / 2.0);
                    if(cut2 > 1)
                        ans = Math.max(ans, (double)(nums2[cut2 - 2] + l2) / 2.0);
                    return ans;
                }
            }
            else if(l1 > r2) high = cut1 - 1;
            else low = cut1 + 1;
        }
        return -1;
    }
}