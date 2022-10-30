// using reverse digit fun

// class Solution {

//     public int reverse(int n){
//         int reversedNum = 0;
//         while(n != 0){
//             reversedNum = (10 * reversedNum) + n % 10;
//             n = n / 10;
//         }
//         return reversedNum;
//     }

//     public boolean isSameAfterReversals(int num) {
//         int reversed1, reversed2;

//         reversed1 = reverse(num);
//         System.out.println(reversed1);
//         reversed2 = reverse(reversed1);
//         System.out.println(reversed2);

//         if(reversed2 == num) return true;
//         return false;
//     }
// }


//using observation

class Solution {
    public boolean isSameAfterReversals(int num) {
        if(num == 0 || num % 10 != 0) return true;
        return false;
    }
}
