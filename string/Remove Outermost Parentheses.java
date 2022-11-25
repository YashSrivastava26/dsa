//using two pointer 
//Tc = O(2n)
// class Solution {
//     public String removeOuterParentheses(String s) {
//         String ans = "";
//         int n = s.length();
//         if(n == 0) return ans;
//         int start = 0;
//         int count = 1;
//         for (int i = 1; i < s.length(); i++) {
//             if(s.charAt(i) == '(') count += 1;
//             else if(s.charAt(i) == ')') count -= 1;
//             //System.out.println(count);

//             if(count == 0){
//                 start++;
//                 while(start < i){
//                     char ch = s.charAt(start);
//                     //System.out.println(ch + " " + start);
//                     if(ch == '(') ans = ans + "(";
//                     else if(ch == ')') ans = ans + ")";
//                     start++;
//                 }
//                 start = i + 1;
//             }
//         }
//         return ans;
//     }
// }


//O(n)
class Solution {
    public String removeOuterParentheses(String s) {
        String ans = "";
        int n = s.length();
        if(n == 0) return ans;
        int count = 0;
        for (int i = 0; i < n; i++) {
            if(s.charAt(i) == '(') count += 1;
            System.out.println(count);

            if(count > 1){
                char ch = s.charAt(i);
                if(ch == '(') ans = ans + "(";
                else if(ch == ')') ans = ans + ")";
            }
            if(s.charAt(i) == ')') count -= 1;
        }
        return ans;
    }
}


