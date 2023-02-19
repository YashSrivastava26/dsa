import java.util.*;
class Solution {
    // You must implement this function
    static int seive[];
    static void sieve() {
        int n = 100100;
        seive = new int [n + 1];
        for(int i = 0; i <= n; i++){
            seive[i] = i;
        }
        
        for(int i = 2; i * i <= n; i++){
            if(seive[i] == i){
                for(int j = i * i; j <= n; j += i){
                    seive[j] = i;
                }
            }
        }
    }

    static List<Integer> findPrimeFactors(int n) {
        List<Integer> ans = new ArrayList<>();
        
        while(n != 1){
            ans.add(seive[n]);
            n /= seive[n];
        }
        Collections.sort(ans);
        return ans;
    }
}
