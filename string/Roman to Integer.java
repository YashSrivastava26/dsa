// class Solution {

//     private int romanMapsToInt(char ch){
//         if(ch == 'I') return 1;
//         if(ch == 'V') return 5;
//         if(ch == 'X') return 10;
//         if(ch == 'L') return 50;
//         if(ch == 'C') return 100;
//         if(ch == 'D') return 500;
//         if(ch == 'M') return 1000;
//         else return 0;
//     }

//     public int romanToInt(String s) {
//         int subtract = 0;
//         int ans = 0;
//         int n = s.length();

//         for(int i = n - 1; i >= 0;){
//             int digitVal = romanMapsToInt(s.charAt(i));
//             ans += digitVal;
//             i--;
//             while(i >= 0 && romanMapsToInt(s.charAt(i)) < digitVal){
//                 subtract += romanMapsToInt(s.charAt(i));
//                 i--;
//             }
//         }

//         //System.out.println(ans + " " + subtract);
//         return ans - subtract;
//     }
// }



class Solution {

    private int romanMapsToInt(char ch){
        if(ch == 'I') return 1;
        if(ch == 'V') return 5;
        if(ch == 'X') return 10;
        if(ch == 'L') return 50;
        if(ch == 'C') return 100;
        if(ch == 'D') return 500;
        else return 1000;
    }

    public int romanToInt(String s) {
        int ans = 0;
        int n = s.length();

        for(int i = 0; i < n - 1; i++){
            int digitVal = romanMapsToInt(s.charAt(i));
            if(digitVal < romanMapsToInt(s.charAt(i + 1))){
                ans -= digitVal; 
            }
            else {
                ans += digitVal;
            }
        }

        return ans + romanMapsToInt(s.charAt(n - 1));
    }
}