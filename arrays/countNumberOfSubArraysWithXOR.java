import java.util.HashMap;

class Solution{
    static int subsetXOR(int arr[], int N, int K) {
        HashMap<Integer,Integer> prefixXOR = new HashMap<>();
        int xor = 0, count = 0;
        for (int i = 0; i < arr.length; i++) {
            xor ^= arr[i];
            
            if(xor == K) count++;

            if(prefixXOR.containsKey(xor ^ K)){
                count += prefixXOR.get(xor ^ K); 
            }

            if(prefixXOR.containsKey(xor ^ K))
                prefixXOR.put(xor, prefixXOR.get(xor) + 1);
            else 
                prefixXOR.put(xor, 1);
        }
        return count;
    }
}