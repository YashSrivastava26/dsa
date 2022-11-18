import java.util.Arrays;

class Solution {

    static boolean isPlaced(int[] a, int n, int k, int mid){
        int lastPlaced = a[0];
        k--;

        for (int i = 1; i < n; i++) {
            if(a[i] - lastPlaced >= mid){ 
                k--;
                lastPlaced = a[i];
            }
        }
        if(k <= 0) return true;
        return false;
    }

    public static int solve(int n, int k, int[] a) {
        
        Arrays.sort(a);
        int low = 1;
        int high = a[n - 1] - a[0];

        while(low <= high){
            int mid = low + (high - low) / 2;

            if(isPlaced(a,n,k,mid)){
                low = mid + 1;
            }
            else high = mid - 1;
        }

        return high;
    }
}