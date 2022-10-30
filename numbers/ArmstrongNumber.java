class Solution {
    static String armstrongNumber(int n){
        int digitsCube = 0;
        for (int i = 0; i < 3; i++) {
            digitsCube = digitsCube +(int) Math.pow(n % 10, 3);
            n /= 10;
        }
        if(digitsCube == n) return "Yes";
        return "No";
    }
}
