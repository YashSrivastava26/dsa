import java.util.ArrayList;

// class Solution {
    
//     private boolean isGood(int l, int d){
//         int sum = l % 10;
//         if(sum == d) return false;
//         l /= 10;
//         while(l != 0){
//             int digit = l % 10;
//             //System.out.println(sum + " " + digit);
//             l /= 10;
//             if(digit <= sum || digit == d) {
//                 return false;
//             }
//             sum += digit;
//         }
//         return true;
        
//     }
    
//     ArrayList<Integer> goodNumbers(int L, int R, int D) {
//         ArrayList< Integer > ans = new ArrayList<>(); 
//         for(;L <= R; L++){
//             if(isGood(L, D) == true){
//                 ans.add(L);
//             }
//         }
//         return ans;
        
//     }
// }
//recursion
class Solution {
    
    private boolean isGood(int l, int d, int sum){
        if(l == 0) return true;
        
        int digit = l % 10;
        if(digit == d || digit <= sum) return false;
        sum = (sum == -1) ? digit : (digit + sum);
        
        return isGood(l / 10, d, sum);
        
    }
    
    ArrayList<Integer> goodNumbers(int L, int R, int D) {
        ArrayList< Integer > ans = new ArrayList<>(); 
        for(;L <= R; L++){
            if(isGood(L, D, -1) == true){
                ans.add(L);
            }
        }
        return ans;
        
    }
}