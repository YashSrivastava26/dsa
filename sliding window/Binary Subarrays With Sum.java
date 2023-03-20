// class Solution {
//     public int numSubarraysWithSum(int[] nums, int goal) {
//         int n = nums.length, sum = 0, ans = 0;
//         HashMap<Integer, Integer> prefixSum = new HashMap<>();

//         prefixSum.put(0, 1);
//         for(int i = 0; i < n; i++){
//             sum += nums[i];
//             if(prefixSum.containsKey(sum - goal)){
//                 ans += prefixSum.get(sum - goal);
//             }
//             prefixSum.put(sum, prefixSum.getOrDefault(sum, 0) + 1);
//         }
//         return ans;


//     }
// }

class Solution {
    
    private int atMost(int nums[], int goal){
        if(goal < 0){
            return 0;
        }

        int n = nums.length, ans = 0;
        int left = 0, right = 0;

        while(right < n){
            goal -= nums[right];

            while(goal < 0){
                goal += nums[left];
                left++;
            }

            ans += right - left + 1;
            right++;
        }
        return ans;
    }

    public int numSubarraysWithSum(int[] nums, int goal) {
        return atMost(nums, goal) - atMost(nums, goal - 1);
    }
}