// class Solution{
    
//     private int memoization(int currDay, int lastDay, int[][] points, int[][] dp){
//         if(currDay  == 0){
//             int maxi = 0;
//             for(int i = 0; i < 3; i++){
//                 if(i != lastDay){
//                     maxi = Math.max(maxi, points[0][i]);
//                 }
//             }
//             return maxi;
//         }
        
//         if(dp[currDay][lastDay] != -1){
//             return dp[currDay][lastDay];
//         }
//         int maxi = 0;
//         for(int i = 0; i < 3; i++){
//             if(i != lastDay){
//                 maxi = Math.max(points[currDay][i] + memoization(currDay - 1, i, points, dp), maxi);
//             }
//         }
        
//         return dp[currDay][lastDay] = maxi;
//     }
    
//     public int maximumPoints(int points[][],int N){
//         int dp[][] = new int[N][4];
//         for(int[] row : dp){
//             Arrays.fill(row, -1);
//         }
        
//         return memoization(N - 1, 3, points, dp);
//     }
// }


// class Solution{
    
//     public int maximumPoints(int points[][],int N){
//         int dp[][] = new int[N][4];
        
//         dp[0][0] = Math.max(points[0][1], points[0][2]);
//         dp[0][1] = Math.max(points[0][0], points[0][2]);
//         dp[0][2] = Math.max(points[0][1], points[0][0]);
//         dp[0][3] = Math.max(points[0][0], Math.max(points[0][1], points[0][2]));
        
//         for(int curr = 1; curr < N; curr++){
//             for(int last = 0; last < 4; last++){
                
//                 for(int task = 0; task < 3; task++){
//                     if(task != last){
//                         dp[curr][last] = Math.max(points[curr][task] + dp[curr - 1][task], dp[curr][last]);
//                     }
//                 }
                
//             }
//         }
        
//         return dp[N - 1][3];
//     }
// }


class Solution{
    
    public int maximumPoints(int points[][],int N){
        int prevDay[] = new int[4];
        prevDay[0] = Math.max(points[0][1], points[0][2]);
        prevDay[1] = Math.max(points[0][0], points[0][2]);
        prevDay[2] = Math.max(points[0][1], points[0][0]);
        prevDay[3] = Math.max(points[0][0], Math.max(points[0][1], points[0][2]));
        
        for(int currDay = 1; currDay < N; currDay++){
            int curr[] = new int[4];
            for(int last = 0; last < 4; last++){
                
                for(int task = 0; task < 3; task++){
                    if(task != last){
                        curr[last] = Math.max(points[currDay][task] + prevDay[task], curr[last]);
                    }
                }
                
            }
            prevDay = curr;
        }
        
        return prevDay[3];
    }
}