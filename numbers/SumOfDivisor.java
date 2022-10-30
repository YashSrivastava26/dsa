import java.lang.Thread.State;

class Solution{

    static long sumDivisor(long n){
        long result = 0;
        for (int i = 1; i <= Math.sqrt(n); i++) {
            if(n % i == 0){
                if(i * i == n) result += i;
                else result += i + n / i;
            }
        }
        return result;
    }

    static long sumOfDivisors(int N){
        int result = 0;
        for (int i = 1; i <= N; i++) {
            result += sumDivisor(i);
        }
        return result;
    }
}