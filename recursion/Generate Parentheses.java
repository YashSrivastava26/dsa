import java.util.ArrayList;
import java.util.List;

//my solution
//tc = O(2 ^ n)
//sc = O(2 * n) + O(x * n) x => no of valid paranthesis
// class Solution {

//     private void helper(int n, ArrayList<String> ans, int count, StringBuffer curr){
//         if(n == 0 && count == 0){
//             ans.add(curr.toString());
//             return;
//         }
//         else if(n == 0){
//             return;
//         }

//         curr.append("(");
//         helper(n - 1, ans, count + 1, curr);
//         curr.deleteCharAt(curr.length() - 1);
        
//         if(count > 0){
//             curr.append(")");
//             helper(n - 1, ans, count - 1, curr);
//             curr.deleteCharAt(curr.length() - 1);
//         }
//     }

//     public List<String> generateParenthesis(int n) {
//         ArrayList < String > ans = new ArrayList<>();
//         StringBuffer curr = new StringBuffer();
//         helper(2 * n, ans, 0, curr);
//         return ans;
//     }
// }


//little optimization
//tc = O(2 ^ n)
//sc = O(n) + O (n * x)
class Solution {

    private void helper(int n, ArrayList<String> ans, int open, int close, StringBuffer curr){
        if(curr.length() == 2 * n){
            ans.add(curr.toString());
            return;
        }

        if(open < n){
            curr.append("(");
            helper(n, ans, open + 1, close, curr);
            curr.deleteCharAt(curr.length() - 1);
        }

        if(close < open){
            curr.append(")");
            helper(n, ans, open, close + 1, curr);
            curr.deleteCharAt(curr.length() - 1);
        }
    }

    public List<String> generateParenthesis(int n) {
        ArrayList < String > ans = new ArrayList<>();
        StringBuffer curr = new StringBuffer();
        helper(n, ans, 0, 0, curr);
        return ans;
    }
}