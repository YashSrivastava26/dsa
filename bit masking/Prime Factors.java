import java.util.*;
class Solution
{
    public int[] AllPrimeFactors(int n)
    {
        ArrayList<Integer> ans = new ArrayList<>();
        if(n % 2 == 0){
            ans.add(2);
            while(n % 2 == 0){
                n /= 2;
            }
        }
        
        
        for(int i = 3 ; i <= Math.sqrt(n); i += 2){
            if(n % i == 0){
                ans.add(i);
                while(n % i == 0){
                    n /= i;
                }
            }
        }
        if(n > 2){
            ans.add(n);
        }
        return ans.stream().mapToInt(i -> i).toArray();
    }
}