// class Solution {
//     static int setBits(int n) {
//         int ans = 0;
//         while(n != 0){
//            if((n & 1) != 0){
//                ans++;
//            }
//            n = n >> 1;
//         }
//         return ans;
//     }
// }


class Solution {
    static int setBits(int n) {
        int ans = 0;
        while(n > 0){
           n &= n - 1;
           ans++;
        }
        return ans;
    }
}