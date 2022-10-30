import java.util.HashMap;


//return longest length
// class Solution{    
   
//     // Function for finding maximum and value pair
//     public static int lenOfLongSubarr (int[] nums, int K) {
//         int maxLen = 0, sum = 0;
//         HashMap<Integer,Integer> sumTillPoint = new HashMap<>();
//         for (int i = 0; i < nums.length; i++) {
//             sum += nums[i];

//             if(sum == K)
//                 maxLen = i + 1;
            
//             if(!(sumTillPoint.containsKey(sum)))
//                 sumTillPoint.put(sum, i);
            
//             if(sumTillPoint.containsKey(sum - K))
//                 maxLen = Math.max(maxLen, i - sumTillPoint.get(sum - K));
//         }
//         return maxLen;
//     }

// }