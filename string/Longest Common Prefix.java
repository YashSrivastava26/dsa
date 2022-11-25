import java.util.Arrays;

// O(n * m)
// class Solution {
//     public String longestCommonPrefix(String[] strs) {
//         int n = strs.length;
//         StringBuffer ans = new StringBuffer();
//         int m = strs[0].length();
//         boolean over = false;

//         for (int i = 0; i < m; i++) {
//             char ch = strs[0].charAt(i);
//             for (int j = 1; j < n; j++) {
//                 if(i >= strs[j].length() || strs[j].charAt(i) != ch) over = true;
//             }
//             if(over) break;
//             ans.append(ch);
//         }
//         return ans.toString();
//     }
// }

// without using string buffer
// class Solution {
//     public String longestCommonPrefix(String[] strs) {
//         int n = strs.length;
//         int m = strs[0].length();
//         boolean flg = false;


//         for (int i = 0; i < m; i++) {
//             char ch = strs[0].charAt(i);
//             for (int j = 1; j < n; j++) {
//                 if(i >= strs[j].length() || strs[j].charAt(i) != ch) {
//                     flg = true;
//                     break;
//                 }
//             }
//             if(flg) return strs[0].substring(0, i);
//         }
//         return strs[0];
//     }
// }




//O(n log(m))
class Solution {
    public String longestCommonPrefix(String[] strs) {
        int n = strs.length;
        
        Arrays.sort(strs);
        int m = strs[0].length(), i;
        
        for (i = 0; i < m; i++) {
            if(strs[0].charAt(i) != strs[n - 1].charAt(i)) break;
        }
        return strs[0].substring(0, i);
    }
}