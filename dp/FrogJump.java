import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.lang.Math;

/*
//MEMOIZATION 
//TC = O(N)=> only n element are processed in recursion others are taken from dp
//SC = O(N) + O(N) => one is for recursion stack space other is for memory of dp array
public class FrogJump {
    static Integer minEnergyWay(ArrayList<Integer> arr, int index, int[] dp){
        if(index == 0) return 0;
        if(index == 1) return Math.abs((arr.get(1) - arr.get(0)));

        if(dp[index] != -1) return dp[index];
        int lEnergy = minEnergyWay(arr, index - 1, dp) + Math.abs(arr.get(index) - arr.get(index - 1));
        int rEnergy = minEnergyWay(arr, index - 2, dp) + Math.abs(arr.get(index) - arr.get(index - 2));
        

        return dp[index] = Math.min(lEnergy, rEnergy);
    }
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(List.of(30, 10, 60, 10, 60, 50));
        int dp[] = new int[arr.size()];
        Arrays.fill(dp, -1);
        System.out.println(minEnergyWay(arr, arr.size() - 1, dp));
        
    }
}
*/

//TABULATION 
//TAKING BASE CASE FROM ABOVE RECURSION WHERE INDEX = 0 RETURN 0 AS DP[0] = 0
// DP[1] AS ABS OF ARR[1] - ARR[0]
//FOR LOOP FROM 2 -> N-1
//IN ABOVE RECURSIVE FUN JUST REPLACE minEnergyWay RECURSIVE CALL WITH DP[I - 1] AND DP[I - 2] RESPECTIVELY
//ANSWER WILL BE ATORE AT LAST POSITION (i.e. n-1 index)
/*
public class FrogJump {
    static Integer minEnergyWay(ArrayList<Integer> arr){
        ArrayList<Integer> dp = new ArrayList<>(arr.size() - 1);
        dp.add(0, 0);
        dp.add(1, Math.abs(arr.get(1) - Math.abs(0)));
        for (int i = 2; i < arr.size(); i++) {            
            int first = dp.get(i - 1) + Math.abs(arr.get(i) - arr.get(i - 1));
            int second = dp.get(i - 2) + Math.abs(arr.get(i) - arr.get(i - 2));
            dp.add(i, Math.min(first, second));;
        }
        return dp.get(arr.size() - 1);

    }
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(List.of(30, 10, 60, 10, 60, 50));
        System.out.println(minEnergyWay(arr));
        
    }
}
*/
//SPACE OPTIMIZATION WITH HELP OF CURR,PREV,PRE2 VARIABLE AS WE DO NOT NEED WHOLE ARRAY DP[] IN TABULATION
public class FrogJump {
    static Integer minEnergyWay(ArrayList<Integer> arr){
        int curr, prev, prev2;
        prev2 = 0;
        prev = Math.abs(arr.get(1) - Math.abs(0));
        for (int i = 2; i < arr.size(); i++) {            
            int first = prev + Math.abs(arr.get(i) - arr.get(i - 1));
            int second = prev2 + Math.abs(arr.get(i) - arr.get(i - 2));
            curr = Math.min(first, second);
            prev2 = prev;
            prev = curr;
        }

        //after for loop we will be at size but answer will be at n - 1 
        //so we return prev
        return prev;

    }
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(List.of(30, 10, 60, 10, 60, 50));
        System.out.println(minEnergyWay(arr));
        
    }
}
