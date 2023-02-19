// class Solution{
//     private static int largestPowerOf2InRange(int n){
//         int ans = 0;
//         while((1 << ans) <= n){
//             ans++;
//         }
//         return ans - 1;
//     }
    
//     //Function to return sum of count of set bits in the integers from 1 to n.
//     public static int countSetBits(int n){
//         if(n == 0){
//             return 0;
//         }
    
//         int pwr2 = largestPowerOf2InRange(n);
//         int bitsTillpwr2 = pwr2 * (1 << (pwr2 - 1));
//         int mostSignificantBit = n - (1 << pwr2) + 1;
//         int left = n - (1 << pwr2);
        
//         return bitsTillpwr2 + mostSignificantBit + countSetBits(left);
//     }
// }


class Solution{
    
    //Function to return sum of count of set bits in the integers from 1 to n.
    public static int countSetBits(int n){
        n++;
        int cnt = 0;
        int mask = 1;
        
        while(mask <= n){
            int pair = n / mask;
            cnt += (pair / 2) * mask;
            
            if((pair & 1) == 1){
                cnt += n % mask;
            }
            
            mask <<= 1;
        }
        return cnt;
    }
}