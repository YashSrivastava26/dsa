// class Solution {
//     int remove_duplicate(int A[],int N){
//         int prev = A[0], j = 0;
//         for (int i = 1; i < A.length; i++) {
//             if(prev != A[i]){
//                 j++;
//                 A[j] = A[i];
//             }
//             prev = A[i];
//         }
//         return j + 1;
//     }
// }


class Solution {
    public int removeDuplicates(int[] nums) {
        int prev = nums[0], j = 0;
        for (int i = 0; i < nums.length; i++) {
            if(prev != nums[i]){
                j++;
                nums[j] = nums[i];
            }
            prev = nums[i];
        }
        return j + 1;
    }
}