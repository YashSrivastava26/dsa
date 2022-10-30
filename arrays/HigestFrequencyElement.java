import java.util.Arrays;

class Solution {
    int maxRepeating(int[] arr, int n, int k) {
        int hash[] = new int[k];
        Arrays.fill(hash, 0);
        for (int i = 0; i < n; i++) {
            ++hash[arr[i]];
        }
        int maxi = hash[0], maxiIdx = 0;
        for (int i = 0; i < hash.length; i++) {
            if(hash[i] > maxi){
                maxiIdx = i;
                maxi = hash[i];
            }
        }
        return maxiIdx;
    }
}

