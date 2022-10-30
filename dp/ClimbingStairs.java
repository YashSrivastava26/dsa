import java.util.Arrays;

public class ClimbingStairs {
    static int countways(int n, int[] dp){
        if(n < 0) System.out.println("invalid input");
        if(n <= 1) return 1;

        if(dp[n] != -1) return dp[n];
        return dp[n] = countways(n - 1, dp) + countways(n - 2, dp);
    } 
    public static void main(String[] args) {
        int n = 2;
        int dp[] = new int[n + 1];
        Arrays.fill(dp, -1);

        System.out.println(countways(n, dp));
    }
}