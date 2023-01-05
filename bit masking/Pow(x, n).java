// class Solution {
//     public double myPow(double x, int n) {
//         if(x == 1 || x == 0) return x;
//         if(n == 0) return 1;

//         if(n % 2 == 1) return x * myPow(x, n - 1);
//         else if(n % 2 == 0) return myPow(x * x, n /2);
//         else return 1 / myPow(x, -n);
//     }
// }


class Solution {
    public double myPow(double x, int n) {
        long nn = n;
        //dont do -1 * n as it is integer multiplication
        if(nn < 0) nn = -1 * nn;
        double ans = 1;

        while(nn > 0){
            if(nn % 2 == 1){
                ans *= x;
                nn -= 1;
            }
            else{
                x *= x;
                nn /= 2;
            }
        }
        if(n < 0) ans = 1 / ans;
        return ans;
    }
}