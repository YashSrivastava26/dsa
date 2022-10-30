import java.util.Arrays;

//RECURSION

// public class Solution {
//     private static int maxPoints(int arr[][], int day, int last){
//         if(day == 0) {
//             if(last == 0) return Math.max(arr[0][1], arr[0][2]);
//             if(last == 1) return Math.max(arr[0][0], arr[0][2]);
//             if(last == 2) return Math.max(arr[0][0], arr[0][1]);
//             if(last == 3) return Math.max(arr[0][0], Math.max(arr[0][1], arr[0][2]));
//         }

//         int maxi = 0;
//         for (int i = 0; i < 3; i++) {
//             if(i != last){
//                 int point = arr[day][i] + maxPoints(arr, day - 1, i);
//                 maxi = Math.max(maxi, point);
//             }
//         }
//         return maxi;
//     }

//     public static int ninjaTraining(int n, int points[][]) {

//         return maxPoints(points, n - 1, 3)
//     }

// }

// // memoization
// import java.util.Arrays;

// public class Solution {
//     private static int maxPoints(int arr[][], int day, int last, int dp[][]){
        
        
//         if(day == 0) {
//             if(last == 0) return  dp[0][0] = Math.max(arr[0][1], arr[0][2]);
//             if(last == 1) return  dp[0][1] = Math.max(arr[0][0], arr[0][2]);
//             if(last == 2) return  dp[0][2] = Math.max(arr[0][0], arr[0][1]);
//             if(last == 3) return  dp[0][3] = Math.max(arr[0][0], Math.max(arr[0][1], arr[0][2]));
//         }

//         if(dp[day][last] != -1) return dp[day][last];

//         for (int i = 0; i < 3; i++) {
//             if(i != last){
//                 int point = arr[day][i] + maxPoints(arr, day - 1, i, dp);
//                 dp[day][last] = Math.max(dp[day][last], point);
//             }
//         }
//         return dp[day][last];
//     }

//     public static int ninjaTraining(int n, int points[][]) {
//         int dp[][] = new int[n + 1][4];
//         for (int[] row: dp)
//             Arrays.fill(row, -1);
//         return maxPoints(points, n - 1, 3, dp);
//     }

// }


// //tabulation

// import java.util.Arrays;

// public class Solution {

//     public static int ninjaTraining(int n, int points[][]) {
//         int table[][] = new int[n][4];

//         table[0][0] = Math.max(points[0][1], points[0][2]);
//         table[0][1] = Math.max(points[0][0], points[0][2]);
//         table[0][2] = Math.max(points[0][0], points[0][1]);
//         table[0][3] = Math.max(points[0][0], Math.max(points[0][1], points[0][2]));
        
//         for (int day = 1; day < n; day++) {
//             for (int last = 0; last < 4; last++) {
//                 table[day][last] = 0;
//                 for(int activity = 0; activity < 4; activity++){
//                     if(activity != last){
//                         int point = points[day][activity] + table[day - 1][activity];
//                         table[day][last] = Math.max(table[day][last], point);
//                     }

//                 }
//             }
//         }
//         return table[n - 1][3];
//     }

// }


// // space optimization
public class Solution {

    public static int ninjaTraining(int n, int points[][]) {
        int prev[] = new int[4];
        prev[0] = Math.max(points[0][1], points[0][2]);
        prev[1] = Math.max(points[0][0], points[0][2]);
        prev[2] = Math.max(points[0][0], points[0][1]);
        prev[3] = Math.max(points[0][0], Math.max(points[0][1], points[0][2]));
        
        for (int day = 1; day < n; day++) {
            
            int temp[] = new int[4];
            for (int last = 0; last < 4; last++) {
                temp[last] = 0;
                for(int activity = 0; activity < 3; activity++){
                    if(activity != last){
                        int point = points[day][activity] + prev[activity];
                        temp[last] = Math.max(temp[last], point);
                    }
                }
            }
            
            prev = temp;
        }
        return prev[3];
    }

}