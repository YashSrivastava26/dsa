class Solution {
    int getOddOccurrence(int[] arr, int n) {
        int xor = 0;
        
        for(int it : arr){
            xor ^= it;
        }
        return xor;
    }
}