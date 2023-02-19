//tc = log(n) max o(32)
// class Solution {
//     public int minBitFlips(int start, int goal) {
//         int xor = start ^ goal;

//         int mask = 1, ans = 0;
//         while(xor - mask >= 0){
//             if((xor & mask) != 0){
//                 ans++;
//             }
//             mask <<= 1;
//         }
//         return ans;
//     }
// }

//tc = no of set bit in xor  max = o(32)
class Solution {
    public int minBitFlips(int start, int goal) {
        int xor = start ^ goal;

        int ans = 0;
        while(xor>0){
            ans++;
            xor=xor & (xor-1);
        }
        return ans;
    }
}