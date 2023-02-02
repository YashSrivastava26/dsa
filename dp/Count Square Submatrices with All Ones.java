// class Solution {
//     public int countSquares(int[][] matrix) {
//         int n = matrix.length, m = matrix[0].length;
//         int count[][] = new int[n][m];

//         int ans = 0;
//         for(int i = 0; i < n; i++){
//             count[i][0] = matrix[i][0];
//             ans += count[i][0];
//         }

//         for(int i = 1; i < m; i++){
//             count[0][i] = matrix[0][i];
//             ans += count[0][i];
//         }
//         for(int i = 1; i < n; i++){
//             for(int j = 1; j < m; j++){
//                 if(matrix[i][j] == 1){
//                     count[i][j] = Math.min(count[i - 1][j], Math.min(count[i - 1][j - 1], count[i][j - 1])) + 1;
//                     ans += count[i][j];
//                 }
//             }

//         }
//         return ans;
//     }
// }

class Solution {
    public int countSquares(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        int countPrev[] = new int[m];

        int ans = 0;

        for(int i = 0; i < m; i++){
            countPrev[i] = matrix[0][i];
            ans += countPrev[i];
        }
        for(int i = 1; i < n; i++){
            int curr[] = new int[m];
            curr[0] = matrix[i][0];
            ans += curr[0];
            for(int j = 1; j < m; j++){
                if(matrix[i][j] == 1){
                    curr[j] = Math.min(countPrev[j], Math.min(countPrev[j - 1], curr[j - 1])) + 1;
                    ans += curr[j];
                }
            }
            countPrev = curr;
        }
        return ans;
    }
}