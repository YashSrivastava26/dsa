//O(no of bits in n)
// class Solution {
//     public boolean isPowerOfTwo(int n) {
//         if(n <= 0) return false;
//         if(n == 1) return true;
//         if((n & 1) != 0) return false;
//         n = n >> 1;
//         int countSetBits = 0;
//         while(n != 0){
//             if((n & 1) != 0) {
//                 countSetBits ++;
//                 if(countSetBits > 1) return false;
//             }
//             n = n >> 1;
//         }
//         return true;
//     }
// }

//O(1)
class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n <= 0) return false;
        return (n & (n - 1)) == 0 ? true : false;
    }
}