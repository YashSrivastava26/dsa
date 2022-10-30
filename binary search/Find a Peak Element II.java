
// brute force
// class Solution {
//     public int[] findPeakGrid(int[][] mat) {
//         int n = mat.length;
//         int m = mat[0].length;
//         for (int i = 0; i < n; i++) {
//             for (int j = 0; j < m; j++) {
//                 if((i == 0 || mat[i][j] > mat[i -1][j]) && (j == 0 || mat[i][j] > mat[i][j - 1]) && (j == m - 1 || mat[i][j] > mat[i][j + 1]) && (i == n - 1 || mat[i][j] > mat[i + 1][j])) {
//                     int res[] = {i, j};
//                     return res;
//                 }
//             }
//         }
//         int res[] = {-1, -1};
//         return res;
//     }
// }


// binary search intution
class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int low = 0, high = mat[0].length - 1;
        while(low <= high){
            int maxRow = 0;
            int mid = low + (high - low) / 2;
            for (int i = 1; i < mat.length; i++) {
                if(mat[i][mid] > mat[maxRow][mid]) maxRow = i;
            }

            boolean isLeftSmall = mid == 0 ? true : mat[maxRow][mid] > mat[maxRow][mid - 1] ? true : false;
            boolean isRightSmall = mid == mat[0].length - 1 ? true : mat[maxRow][mid] > mat[maxRow][mid + 1] ? true : false;
            if(isLeftSmall && isRightSmall){
                int res[] = {maxRow, mid};
                return res;
            } 
            else if(isLeftSmall)
                low = mid + 1;
            else high = mid - 1;
        }
        int res[] = {-1,-1};
        return res;
    }
}