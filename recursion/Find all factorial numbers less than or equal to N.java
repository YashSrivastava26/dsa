import java.util.ArrayList;

class Solution{
    static ArrayList<Long> factorialNumbers(long N){
        ArrayList<Long> result = new ArrayList<Long>();
        int i = 2;
        Long prod = 1l;
        while(prod <= N){
            result.add(prod);
            prod *= i;
            i ++;
        }
        return result;
    }
}
