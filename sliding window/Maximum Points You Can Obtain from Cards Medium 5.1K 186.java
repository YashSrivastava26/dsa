// class Solution {
//     public int maxScore(int[] cardPoints, int k) {
//         int n = cardPoints.length;
//         if(k > n){
//             return -1;
//         }

//         int ans = 0, start = n - k, end = n + k;
//         int windowSum = 0;
//         int left = start, right = start;

//         while(right < end){
//             windowSum += cardPoints[(right % n + n) % n];//why + n bcz it will give -ve sometime can also do Math.abs

//             if(right - left + 1 > k){
//                 windowSum -= cardPoints[(left % n + n) % n];
//                 left++;
//             }

//             right++;
//             // System.out.println(left + " " + right + " " + windowSum);
//             ans = Math.max(ans, windowSum);
//         }
//         return ans;
//     }
// }


class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        if(k > n){
            return -1;
        }

        int totalSum = 0;
        for(int i = 0; i < n; i++){
            totalSum += cardPoints[i];
        }

        int right = 0, left = 0, windowSum = 0, windowSize = n - k;
        int ans = 0;

        while(right < n){
            windowSum += cardPoints[right];

            if(right - left + 1 > windowSize){
                windowSum -= cardPoints[left];
                left++;
            }

            if(right - left + 1 == windowSize){
                ans = Math.max(ans, totalSum - windowSum);
            }
            right++;
        }
        return ans;
    }
}