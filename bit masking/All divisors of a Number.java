import java.util.*;

class Solution {
    public static void print_divisors(int n) {
        ArrayList<Integer> pair = new ArrayList<>();
        
        for(int i = 1; i <= Math.sqrt(n); i++){
            if(n % i == 0){
                System.out.print(i + " ");
                if(i * i != n){
                    pair.add(n / i);
                }
            }
        }
        for(int i = pair.size() - 1; i >= 0; i--){
            System.out.print(pair.get(i) + " ");
        }
        
    }
}