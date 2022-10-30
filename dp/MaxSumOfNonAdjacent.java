import java.util.Arrays;

/* public class MaxSumOfNonAdjacent {

    static int maxSum(int[] arr, int index){
        if(index == 0) return Math.max(0, arr[0]); 
        if(index < 0) return 0;

        int pick = arr[index] + maxSum(arr, index - 2);
        int notPick = maxSum(arr, index - 1);

        return Math.max(pick, notPick);
    }

    public static void main(String[] args) {
        int arr[] = {-1,-1,2,-1,4 };
        System.out.println(maxSum(arr , arr.length - 1));
    }
}
*/

public class MaxSumOfNonAdjacent {

    static int maxSum(int[] arr, int index, int[] dp){

        if(index == 0) return Math.max(0, arr[0]); 
        if(index < 0) return 0;

        if(dp[index] != -1) return dp[index];
        int pick = arr[index] + maxSum(arr, index - 2, dp);
        int notPick = maxSum(arr, index - 1, dp);

        return dp[index] = Math.max(pick, notPick);
    }

    public static void main(String[] args) {
        int arr[] = {-1,-8,-2,-1,-4 };
        int max_ele = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if(max_ele < arr[i]) max_ele = arr[i];
        }
        if(max_ele <= 0) System.out.println(max_ele);
        else{
            int dp[] = new int[arr.length];
            Arrays.fill(dp, -1);
            System.out.println(maxSum(arr , arr.length - 1, dp));
        }
    }
}

//------------------------------------------------------------------------------------------------------------------
//POSITIVE ONLY
/*
public class MaxSumOfNonAdjacent {

    static int maxSum(int[] arr, int index, int[] dp){
        if(index == 0) return arr[0]; 
        if(index < 0) return 0;

        if(dp[index] != -1) return dp[index];
        int pick = arr[index] + maxSum(arr, index - 2, dp);
        int notPick = maxSum(arr, index - 1, dp);

        return dp[index] = Math.max(pick, notPick);
    }

    public static void main(String[] args) {
        int arr[] = {-1,8,2,-1,4 };
        int dp[] = new int[arr.length + 1];
        Arrays.fill(dp, -1);
        for (int i : dp) {
            System.out.println(i);
        }        
        System.out.println(maxSum(arr , arr.length - 1, dp));
    }
} */
/*
public class MaxSumOfNonAdjacent {

    static int maxSum(int[] arr){
        int dp[] = new int[arr.length];
        dp[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            int pick = arr[i];
            if(i > 1) pick += dp[i - 2];
            int notPick = 0 + dp[i - 1];
            dp[i] = Math.max(pick, notPick);
        }
        return dp[arr.length - 1];

    }

    public static void main(String[] args) {
        int arr[] = {5,  5, 10, 100, 10, 5};
        System.out.println(maxSum(arr));
    }
}
*/
/* 
public class MaxSumOfNonAdjacent {

    static int maxSum(int[] arr){
        int prev2 = 0;
        int prev = arr[0];
        for (int i = 1; i < arr.length; i++) {
            int pick = arr[i] +  prev2;
            int notPick = 0 + prev;
            int curr = Math.max(pick, notPick);
            prev2= prev;
            prev = curr;
        }
        return prev;
    }

    public static void main(String[] args) {
        int arr[] = {5, 5, 10, 100, 10, 5};
        System.out.println(maxSum(arr));
    }
}*/