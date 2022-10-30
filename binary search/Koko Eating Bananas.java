// class Solution {
//     public static int hoursTookToFinishBananas(int[] piles, int n, int rate){
//         int count = 0;
//         for (int i = 0; i < piles.length; i++) {
//             count += (int)Math.ceil(piles[i] / (double) rate);
//         }
//         return count;
//     }
//     public static int Solve(int N, int[] piles, int H) {
//         int low = 0, high = (int)1e9, ans = Integer.MAX_VALUE;
//         while(low <= high){
//             int mid = low + (high - low) / 2;
//             int currHrTook = hoursTookToFinishBananas(piles, N, mid);
//             int prevHrTook = hoursTookToFinishBananas(piles, ans, mid - 1);
//             if(mid > 0 && currHrTook <= H && prevHrTook > H) return mid;
//             else if(currHrTook <= H) high = mid - 1;
//             else low = mid + 1;
//         }
//         return 0;
//     }
// }


//little change in range take high inttal as max in pile
class Solution {
    public static long hoursTookToFinishBananas(int[] piles, int n, int rate){
        long count = 0;
        for (int i = 0; i < piles.length; i++) {
            count += (long)Math.ceil(piles[i] / (double) rate);
        }
        return count;
    }
    public static int Solve(int N, int[] piles, int H) {
        int maxi = Integer.MAX_VALUE;
        for (int i = 0; i < piles.length; i++) 
            maxi = Math.max(maxi, piles[i]);

        int low = 0, high = (int)1e9, ans = maxi;
        while(low <= high){
            int mid = low + (high - low) / 2;
            long currHrTook = mid == 0 ? Integer.MAX_VALUE : hoursTookToFinishBananas(piles, N, mid);
            if(currHrTook <= H){
                ans = mid;
                high = mid - 1;
            }
            else low = mid + 1;
        }
        return ans;
    }
}
    