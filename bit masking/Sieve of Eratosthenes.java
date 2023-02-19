import java.util.*;
class Solution{
    static ArrayList<Integer> sieveOfEratosthenes(int n){
        boolean seive[] = new boolean[n + 1];
        
        for(int i = 2; i <= n; i++){
            seive[i] = true;
        }
        
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = 2; i * i <= n; i++){
            if(seive[i]){
                for(int j = i * i; j <= n; j += i){
                    seive[j] = false;
                }
            }
        }
        
        for(int i = 0; i <= n; i++){
            if(seive[i]){
                ans.add(i);
            }
        }
        return ans;
    }
}