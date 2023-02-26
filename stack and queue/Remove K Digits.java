import java.util.*;
class Solution {
    public String removeKdigits(String num, int k) {
        int n = num.length();
        if(k >= n){
            return "0";
        }
        Stack<Character> increasing = new Stack<>();

        for(int i = 0; i < n; i++){
            char digit = num.charAt(i);
            while( !increasing.isEmpty() && increasing.peek() > digit && k > 0){
                increasing.pop();
                k--;
            }
            increasing.push(digit);
        }

        while( !increasing.isEmpty() && k > 0){
            increasing.pop();
            k--;
        }

        if(increasing.size() == 0){
            return "0";
        }

        StringBuilder ans = new StringBuilder();
        while(!increasing.isEmpty()){
            ans.append(increasing.pop());
        }
        ans.reverse();


        int i = ans.length() - 1;
        while(ans.length() > 1 && ans.charAt(0) == '0'){
            ans.deleteCharAt(0);
        }

        return ans.toString();
    }
}