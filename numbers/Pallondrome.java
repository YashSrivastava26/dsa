// class Solution
// {
//     public String is_palindrome(int n)
//     {
//         int x = n, rev = 0;
//         while(x != 0){
//             rev = rev * 10 +  x % 10;
//             x /= 10;
//         }
//         if(n == rev) return "Yes";
//         return "No";
//     }
// }

// leetcode
class Solution {
    public boolean isPalindrome(int x) {
        int n = x, rev = 0;
        while(n != 0){
            rev = rev * 10 + n % 10;
            n /= 10;
        }
        if(x == rev) return true;
        return false;
    }
}