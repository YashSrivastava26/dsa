import java.util.*;
// class Solution {

//     private int tryAllPossible(int n, int[] pick, int k, StringBuffer curr){
//         if(curr.length() == n){
//             return k - 1;
//         }

//         for(int i = 1; i <= n; i++){
//             if(pick[i] != 1){
//                 curr.append((char) (i + '0'));
//                 pick[i] = 1;
                
//                 k = tryAllPossible(n, pick, k, curr);
//                 if(k == 0){
//                     return 0;
//                 }

//                 pick[i] = 0;
//                 curr.deleteCharAt(curr.length() - 1);
//             }
//         }
//         return k;
//     }

//     public String getPermutation(int n, int k) {
//         int[] pick = new int[n + 1];
        
//         StringBuffer ans = new StringBuffer();

//         tryAllPossible(n, pick, k, ans);

//         return ans.toString();
//     }
// }


// class Solution {

//     private void chooseEleAtIPlace(int n, int k, int fact, StringBuffer ans, ArrayList<Integer> numsAvail){    

//         int idx = k / fact;
//         ans.append((char)(numsAvail.get(idx) + '0'));
//         numsAvail.remove(idx);

//         if(n != 0){
//             k %= fact;
//             fact = fact / n;
//             n--;
//             chooseEleAtIPlace(n, k, fact, ans, numsAvail);
//         }
//     }
//     public String getPermutation(int n, int k) {
//         int fact = 1;
//         ArrayList<Integer> numsAvail = new ArrayList<>();
//         StringBuffer ans = new StringBuffer();

//         for(int i = 1; i < n; i++){
//             fact = fact * i;
//             numsAvail.add(i);
//         }
//         numsAvail.add(n);

        
//         chooseEleAtIPlace(n - 1, k - 1, fact, ans, numsAvail);

//         System.out.println(ans);
//         return ans.toString();
//     }
// }


class Solution {
    public String getPermutation(int n, int k) {
        int fact = 1;
        ArrayList<Integer> numsAvail = new ArrayList<>();
        String ans = "";

        for(int i = 1; i < n; i++){
            fact = fact * i;
            numsAvail.add(i);
        }
        numsAvail.add(n);

        k--;
        while(numsAvail.size() != 0){
            int idx = k / fact;
            ans += (char)(numsAvail.get(idx) + '0');
            numsAvail.remove(idx);
            if(numsAvail.size() == 0){
                break;
            }
            
            k %= fact;
            fact /= numsAvail.size();
        }
        return ans;
    }
}