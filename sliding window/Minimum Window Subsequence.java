//c++
// class Solution {
//   public:
//     string minWindow(string str1, string str2) {
//         int i = 0, j = 0;
//         int n = str1.length(), m = str2.length();
//         vector<int> ans(2, 0);      //ans[0] = minLen, ans[1] = left, ans[2] = right
//         ans[0] = n + 1;
        
//         while(i < n){
//             if(str1[i] == str2[j]){
//                 j++;
//                 if(j == m){
//                     int rev = i;
//                     j = m - 1;
//                     while(j >= 0){
//                         if(str1[rev] == str2[j]){
//                             j--;
//                         }
//                         rev--;
//                     }
                    
//                     if(ans[0] > i - rev){
//                         ans[0] = i - rev;
//                         ans[1] = rev + 1;
//                     } 
                    
//                     j = 0;
//                 }
//             }
//             i++;
//         }
//         if(ans[0] == n + 1){
//             return "";
//         }
//         return str1.substr(ans[1], ans[0]);
//     }
// };


class Solution {
    static String minWindow(String str1, String str2) {
        int i = 0, j = 0;
        int n = str1.length(), m = str2.length();
        int ans[] = new int[3];      //ans[0] = minLen, ans[1] = left, ans[2] = right
        ans[0] = n + 1;
        
        while(i < n){
            if(str1.charAt(i) == str2.charAt(j)){
                j++;
                if(j == m){
                    int rev = i;
                    j = m - 1;
                    while(j >= 0){
                        if(str1.charAt(rev) == str2.charAt(j)){
                            j--;
                        }
                        rev--;
                    }
                    
                    if(ans[0] > i - rev){
                        ans[0] = i - rev;
                        ans[1] = rev + 1;
                        ans[2] = i + 1;
                    } 
                    
                    j = 0;
                }
            }
            
            i++;
        }
        
        return str1.substring(ans[1], ans[2]);
    }
}