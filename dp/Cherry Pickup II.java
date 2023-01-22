// class Solution {
//     private int memoization(int row, int c1, int c2, int grid[][], int m, int[][][] dp){
        
//         if(c1 < 0 || c2 < 0 || c1 >= m || c2 >= m){
//             return 0;
//         }
//         if(row == grid.length - 1){
//             if(c1 == c2) {
//                 return grid[row][c1];
//             }
//             else {
//                 return grid[row][c1] + grid[row][c2];
                
//             }
//         }
        
//         if(dp[row][c1][c2] != -1){
//             return dp[row][c1][c2];
//         }
        
//         int delCol[] = {-1, 0, 1};
//         int maxi = 0;
//         for(int i = 0; i < 3; i++){
//             int newC1 = c1 + delCol[i];
//             for(int j = 0; j < 3; j++){
//                 int newC2 = c2 + delCol[j];
                
//                 int curr = memoization(row + 1, newC1, newC2, grid, m, dp);
//                 maxi = Math.max(curr, maxi);
//                 // System.out.println(maxi + " " + curr + " " + newC1 + " " + newC2 + " " + row);
//             }
//         }
//         if(c1 == c2) {
//             return dp[row][c1][c2] = maxi + grid[row][c1];
//         }
//         return dp[row][c1][c2] = maxi + grid[row][c1] + grid[row][c2];
//     }


//     public int cherryPickup(int[][] grid) {
//         int n = grid.length, m = grid[0].length;
//         int [][][] dp = new int[n][m][m];
//         for(int[][] two_D : dp){
//             for(int[] one_D : two_D){
//                 Arrays.fill(one_D, -1);
//             }
            
//         }
//         return memoization(0, 0, m - 1, grid, m, dp);
//     }
// }


//tabulation
// class Solution {
//     private boolean inRange(int c1, int c2, int m){
//         if(c1 < 0 || c2 < 0 || c1 >= m || c2 >= m){
//             return false;
//         }
//         return true;
//     }

//     public int cherryPickup(int[][] grid) {
//         int n = grid.length, m = grid[0].length;
//         int [][][] dp = new int[n][m][m];
        
//         for(int c1 = 0; c1 < m; c1++){
//             for(int c2 = 0; c2 < m; c2++){
//                 if(c1 == c2) {
//                     dp[n - 1][c1][c2] = grid[n - 1][c1];
//                 }
//                 else {
//                     dp[n - 1][c1][c2] = grid[n - 1][c1] + grid[n - 1][c2];
                
//                 }
//             }
//         }
        
//         for(int row = n - 2; row >= 0; row--){
//             for(int c1 = 0; c1 < m; c1++){
//                 for(int c2 = 0; c2 < m; c2++){
                    
//                     int delCol[] = {-1, 0, 1};
//                     int maxi = 0;
                    
//                     for(int i = 0; i < 3; i++){
//                         int newC1 = c1 + delCol[i];
//                         for(int j = 0; j < 3; j++){
//                             int newC2 = c2 + delCol[j];
                
//                             if(inRange(newC1, newC2, m)){
//                                 int curr = dp[row + 1][newC1][newC2];
//                                 maxi = Math.max(curr, maxi);
//                             }
//                         }
//                     }
                    
//                     if(c1 == c2) {
//                         dp[row][c1][c2] = maxi + grid[row][c1];
//                     }
//                     else{
//                         dp[row][c1][c2] = maxi + grid[row][c1] + grid[row][c2];
//                     }    
//                 }
//             }
//         }
//         return dp[0][0][m - 1];
//     }
// }

//space optimization
class Solution {
    private boolean inRange(int c1, int c2, int m){
        if(c1 < 0 || c2 < 0 || c1 >= m || c2 >= m){
            return false;
        }
        return true;
    }

    public int cherryPickup(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int [][] bottomRow = new int[m][m];
        
        for(int c1 = 0; c1 < m; c1++){
            for(int c2 = 0; c2 < m; c2++){
                if(c1 == c2) {
                    bottomRow[c1][c2] = grid[n - 1][c1];
                }
                else {
                    bottomRow[c1][c2] = grid[n - 1][c1] + grid[n - 1][c2];
                
                }
            }
        }
        
        for(int row = n - 2; row >= 0; row--){
            
            int currRow[][] = new int[m][m];
            for(int c1 = 0; c1 < m; c1++){
                for(int c2 = 0; c2 < m; c2++){
                    
                    int delCol[] = {-1, 0, 1};
                    int maxi = 0;
                    
                    for(int i = 0; i < 3; i++){
                        int newC1 = c1 + delCol[i];
                        for(int j = 0; j < 3; j++){
                            int newC2 = c2 + delCol[j];
                
                            if(inRange(newC1, newC2, m)){
                                int curr = bottomRow[newC1][newC2];
                                maxi = Math.max(curr, maxi);
                            }
                        }
                    }
                    
                    if(c1 == c2) {
                        currRow[c1][c2] = maxi + grid[row][c1];
                    }
                    else{
                        currRow[c1][c2] = maxi + grid[row][c1] + grid[row][c2];
                    }    
                }
            }
            bottomRow = currRow;
        }
        return bottomRow[0][m - 1];
    }
}