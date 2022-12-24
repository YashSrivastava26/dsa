//using hash map but time taken is more due to continous updating/ searching

// class Solution {

//     private int atMostKDistinct(int[] nums, int k){
//         int left = 0, n = nums.length;
//         int ans = 0;

//         HashMap < Integer , Integer > freq = new HashMap<>();
//         for(int i = 0; i < n; i++){
//             freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);
//             while(freq.size() > k){
//                 freq.put(nums[left], freq.get(nums[left]) - 1);
//                 if(freq.get(nums[left]) == 0){
//                     freq.remove(nums[left]);
//                 }
//                 left ++;
//             }
//             ans += i - left + 1;
//         }
//         return ans;
//     }
//     public int subarraysWithKDistinct(int[] nums, int k) {
//         return atMostKDistinct(nums, k) - atMostKDistinct(nums, k - 1);
//     }
// }

//using array as hash table
class Solution {

    private int atMostKDistinct(int[] nums, int k){
        int left = 0, n = nums.length;
        int ans = 0, sizeFreq = 0;

        int freq[] = new int[n + 1];
        for(int i = 0; i < n; i++){
            if(freq[nums[i]] == 0){
                sizeFreq ++;
            }
            freq[nums[i]]++;
            while(sizeFreq > k){
                freq[nums[left]]--;
                if(freq[nums[left]] == 0){
                    sizeFreq--;
                }
                left ++;
            }
            ans += i - left + 1;
        }
        return ans;
    }
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMostKDistinct(nums, k) - atMostKDistinct(nums, k - 1);
    }
}