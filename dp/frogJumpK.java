import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//normal recursion
/*public class frogJumpK {
    static int minENergy(ArrayList<Integer> arr, int index, int k, int[] dp){
        if(index == 0) return 0;
        
        int min=  Integer.MAX_VALUE;
        int jumpi;
        if(index < k){
            for (int i = 1; i <= index ; i++) {
                jumpi = minENergy(arr, index - i, k, dp) + Math.abs(arr.get(index) - arr.get(index - i));
                min = Math.min(min, jumpi);
            }
        }
        else if(index >= k){
            for (int i = 1; i <= k ; i++) {
                jumpi = minENergy(arr, index - i, k, dp) + Math.abs(arr.get(index) - arr.get(index - i));
                min = Math.min(min, jumpi);
            }   
        }
        return min;
    }
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(List.of(30, 10, 60, 10, 60, 50));
        int k = 5;
        int dp[] = new int[arr.size() + 1];
        Arrays.fill(dp, -1);
        System.out.println(minENergy(arr, arr.size() - 1, k, dp));
    }    
}*/
/* 
public class frogJumpK {
    static int minENergy(ArrayList<Integer> arr, int index, int k, int[] dp){
        if(index == 0) return 0;
        
        int min=  Integer.MAX_VALUE;
        int jumpi;
        for (int i = 1; i <= k ; i++) {
            if(index - i >= 0){//don not call recursion when it goes to negative i.e. index < k
                jumpi = minENergy(arr, index - i, k, dp) + Math.abs(arr.get(index) - arr.get(index - i));
                min = Math.min(min, jumpi);
            }
        }
        return min;
    }
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(List.of(30, 10, 60, 10, 60, 50));
        int k = 5;
        int dp[] = new int[arr.size() + 1];
        Arrays.fill(dp, -1);
        System.out.println(minENergy(arr, arr.size() - 1, k, dp));
    }    
}
*/
/*
//MEMONIZATION
public class frogJumpK {
    static int minENergy(ArrayList<Integer> arr, int index, int k, int[] dp){
        if(index == 0) return 0;
        if(dp[index] != -1) return dp[index];
        int min=  Integer.MAX_VALUE;
        int jumpi;
        for (int i = 1; i <= k ; i++) {
            if(index - i >= 0){//don not call recursion when it goes to negative i.e. index < k
                jumpi = minENergy(arr, index - i, k, dp) + Math.abs(arr.get(index) - arr.get(index - i));
                min = Math.min(min, jumpi);
            }
        }
        return dp[index] = min;
    }
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(List.of(30, 10, 60, 10, 60, 50));
        int k = 5;
        int dp[] = new int[arr.size() + 1];
        Arrays.fill(dp, -1);
        System.out.println(minENergy(arr, arr.size() - 1, k, dp));
    }    
}
*/

public class frogJumpK {
    static int minENergy(ArrayList<Integer> arr, int k){
        int dp[] = new int[arr.size()];
        dp[0] = 0;
        int jumpi;
        for(int j = 1; j < arr.size(); j ++){
            int min=  Integer.MAX_VALUE;
            for (int i = 1; i <= k ; i++) {
                if(j - i >= 0){//don not call recursion when it goes to negative i.e. j < k//j is index and i is jump
                    jumpi = dp[j - i] + Math.abs(arr.get(j) - arr.get(j - i));
                    min = Math.min(min, jumpi);
                }
            }
            dp[j] = min;
        }
        return dp[arr.size() - 1];
    }
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(List.of(30, 10, 60, 10, 60, 50));
        int k = 5;
        int dp[] = new int[arr.size() + 1];
        Arrays.fill(dp, -1);
        System.out.println(minENergy(arr, k));
    }    
}
