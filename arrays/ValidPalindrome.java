// class Solution {

//     public boolean isPalindromeAlphaNumericOnly(String s){
//         for (int i = 0; i < s.length() / 2; i++) {
//             if(s.charAt(i) != s.charAt(s.length() - 1 - i)) return false;
//         }
//         return true;
//     }

//     public boolean isPalindrome(String s) {
//         int chk;
//         String alphaNumeric = "";
//         for (int i = 0; i < s.length(); i++) {
//             chk = s.charAt(i);
//             if(chk >= 48 && chk <= 57) alphaNumeric = alphaNumeric + s.charAt(i);
//             else if(chk >= 65 && chk <= 90) alphaNumeric = alphaNumeric + Character.toLowerCase(s.charAt(i));
//             else if(chk >= 97 && chk <= 122) alphaNumeric = alphaNumeric + s.charAt(i);
//         }
//         return isPalindromeAlphaNumericOnly(alphaNumeric);
//     }
// }


//optimize
class Solution {
    public boolean isPalindrome(String s) {
        int start = 0, end = s.length() - 1;
        int chkStart, chkEnd;
        while(start < end){
            chkEnd = s.charAt(end);
            chkStart = s.charAt(start);

            if(!((chkStart >= 48 && chkStart <= 57) || (chkStart >= 65 && chkStart <= 90) || (chkStart >= 97 && chkStart <= 122)))
                start ++;
            
            else if(!((chkEnd >= 48 && chkEnd <= 57) || (chkEnd >= 65 && chkEnd <= 90) || (chkEnd >= 97 && chkEnd <= 122)))
                end--;
            
            else {
                char endChar, startChar;
                if(chkEnd >= 65 && chkEnd <= 90) endChar = Character.toLowerCase(s.charAt(end));
                else endChar = s.charAt(end);

                if(chkStart >= 65 && chkStart <= 90) startChar = Character.toLowerCase(s.charAt(start));
                else startChar = s.charAt(start);
                
                if(endChar != startChar) return false;
                start ++;
                end --;
            }
            
        }
        return true;
    }
}
/**
 * ValidPalindrome
 */
public class ValidPalindrome {

    public static void main(String[] args) {
        String s = "race a car";
        Solution sol = new Solution();
        System.out.println(sol.isPalindrome(s));
    }
}