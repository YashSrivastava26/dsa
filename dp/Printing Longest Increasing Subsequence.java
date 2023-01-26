import java.util.*;
class Solution{
    public ArrayList<Integer> longestIncreasingSubsequence(int n, int arr[]){
        
        int dp[] = new int[n];
        int prevMax[] = new int[n];
        Arrays.fill(dp, 1);
        int maxi = 0, maxiIdx = -1;
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < i; j++){
                if(arr[i] > arr[j] && 1 + dp[j] > dp[i]){
                    dp[i] = 1 + dp[j];
                    prevMax[i] = j;
                }
            }
            if(maxi < dp[i]){
                maxi = dp[i];
                maxiIdx = i;
            }
        }
        // System.out.println(maxi + " " + maxiIdx);
        // for(int it : prevMax){
        //     System.out.print(it + " ");
        // }
        ArrayList<Integer> lis = new ArrayList<>();
        int i = maxi - 1;
        while(i >= 0){
            lis.add(arr[maxiIdx]);
            i--;
            maxiIdx = prevMax[maxiIdx];
        }
        Collections.reverse(lis);
        return lis;
    }
}