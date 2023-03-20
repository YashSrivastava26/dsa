
import java.util.*;
class Solution{
    static List<Integer> minPartition(int N)
    {
        int currency[] = {1,2,5,10,20,50,100,200,500,2000};
        int n = currency.length;
        List<Integer> ans = new ArrayList<>();
        for(int i = n - 1; i >= 0; i--){
            int numOfCurrNote = N / currency[i];
            N = N % currency[i];
            while(numOfCurrNote-- != 0){
                ans.add(currency[i]);
            }
        }
        return ans;
    }
}