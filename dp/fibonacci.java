import java.util.Arrays;
import java.util.Scanner;

//MEMONIZATION
/* public class fibonacci {
    static public int f(int n, int[] dp){
        if(n <= 1)
            return n;
        if(dp[n] != -1)
            return dp[n];
        return dp[n] = f(n-1, dp) + f(n-2, dp);
    } 
    public static void main(String[] args) {
        int n;
        System.out.print("enter n:");
        Scanner s = new Scanner(System.in);
        n = s.nextInt();
        
        int dp[] = new int[n+1];
        Arrays.fill(dp, -1);
        System.out.println(f(n, dp)); 
    }
    
} */

//TABULATION
/* public class fibonacci {
    static public int f(int n, int[] dp){
        for(int i = 2; i < dp.length; i++)
            dp[i] = dp[i-1] + dp[i-2];
        return dp[n];
    } 
    public static void main(String[] args) {
        int n;
        System.out.print("enter n:");
        Scanner s = new Scanner(System.in);
        n = s.nextInt();
        
        int dp[] = new int[n+1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        dp[1] = 1;
        System.out.println(f(n, dp)); 
    }
    
}*/

//SPACE OPTAMIZATION

public class fibonacci {
    static public int f(int n){      
        int prev = 1; 
        int prev2 = 0;
        for(int i = 2; i <= n; i++){
            int curr = prev + prev2;
            prev2 = prev;
            prev = curr;
        }
        return prev;
    } 
    public static void main(String[] args) {
        int n;
        System.out.print("enter n:");
        Scanner s = new Scanner(System.in);
        n = s.nextInt();
        System.out.println(f(n)); 
    }
    
}

