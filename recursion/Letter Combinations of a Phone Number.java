import java.util.*;

// using hashmap
// class Solution {

//     private void pickAtEachNum(int idx, String digits, StringBuilder curr, List<String> ans, HashMap < Integer, String >  mapChToNum){
//         if(idx == digits.length()){
//             ans.add(curr.toString());
//             return;
//         }

//         String currAvail = mapChToNum.get(digits.charAt(idx) - '0');
//         int n = currAvail.length();
//         for(int i = 0; i < n; i++){
//             //pick
//             curr.append(currAvail.charAt(i));
//             pickAtEachNum(idx + 1, digits, curr, ans, mapChToNum);
//             curr.deleteCharAt(curr.length() - 1);
//         }
//     }

//     public List<String> letterCombinations(String digits) {
//         List<String> ans = new ArrayList<>();
//         HashMap < Integer , String > mapChToNum = new HashMap<>();
//         mapChToNum.put(2, "abc");
//         mapChToNum.put(3, "def");
//         mapChToNum.put(4, "ghi");
//         mapChToNum.put(5, "jkl");
//         mapChToNum.put(6, "mno");
//         mapChToNum.put(7, "pqrs");
//         mapChToNum.put(8, "tuv");
//         mapChToNum.put(9, "wxyz");
        
//         if(digits.length() == 0) return ans;

//         pickAtEachNum(0, digits, new StringBuilder(), ans, mapChToNum);

//         return ans;
//     }
// }


// using array

// TC = 4 ^ n
//SC = n
class Solution {

    private void pickAtEachNum(int idx, String digits, StringBuilder curr, List<String> ans, String[] mapChToNum){
        if(idx == digits.length()){
            ans.add(curr.toString());
            return;
        }

        int currNum = digits.charAt(idx) - '0';
        int n = mapChToNum[currNum].length();
        for(int i = 0; i < n; i++){
            //pick
            curr.append(mapChToNum[currNum].charAt(i));
            pickAtEachNum(idx + 1, digits, curr, ans, mapChToNum);
            curr.deleteCharAt(curr.length() - 1);
        }
    }

    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        
        if(digits.length() == 0) return ans;
        String mapChToNum[] = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        pickAtEachNum(0, digits, new StringBuilder(), ans, mapChToNum);

        return ans;
    }
}