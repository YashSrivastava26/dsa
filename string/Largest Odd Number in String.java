//O(n)
// class Solution {

//     boolean checkOdd(char ch){
//         if(ch == '1' || ch == '3' || ch == '5' || ch == '7' || ch == '9') return true;
//         return false;
//     }

//     public String largestOddNumber(String num) {
//         int n = num.length();
//         boolean flg = false;
//         StringBuffer st = new StringBuffer();
//         for (int i = n - 1; i >= 0; i--) {
//             char ch = num.charAt(i);
//             if(flg){
//                 st.append(ch);
//             }
//             else if(checkOdd(ch)){
//                 st.append(ch);
//                 flg = true;
//             }
            
//         }

//         st.reverse();
//         return st.toString();
//     }
// }

//without using string buffer
class Solution {
    public String largestOddNumber(String num) {
        int n = num.length();
        for (int i = n - 1; i >= 0; i--) {
            int digit = num.charAt(i) - '0';
            if(digit % 2 == 1){
                return num.substring(0, i + 1);
            }                
        }
        return "";
    }
}