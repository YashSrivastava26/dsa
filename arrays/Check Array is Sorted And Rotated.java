import java.util.Arrays;

// class Solution {
//     public boolean check(int[] nums) {
//         int temp[] = new int[nums.length];
//         for (int i = 0; i < temp.length; i++) {
//             temp[i] = nums[i];
//         }
//         Arrays.sort(temp);
//         for (int x = 0; x < temp.length; x++) {
//             boolean flag = true;
//             for (int i = 0; i < temp.length; i++) {
//                 if(!(temp[i] == nums[(i+x) % nums.length])){
//                     flag = false;
//                     break;
//                 }
//             }
//             if(flag) return true;
//         }
//         return false;
//     }
// }

class Solution {
    public boolean check(int[] nums) {
        int check = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i - 1] > nums[i]) check++;
        }
        if(nums[0] > nums[nums.length - 1]) check ++;
        if(check <= 1) return true;
        else return false;
    }
}
