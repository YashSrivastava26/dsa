//taking two arrays of size number of rows and number of columns

// class Solution {
//     public void setZeroes(int[][] matrix) {
//         int rowChk[] = new int[matrix.length];
//         int colChk[] = new int[matrix[0].length];
//         Arrays.fill(colChk, 1);
//         Arrays.fill(rowChk, 1);

//         for (int i = 0; i < matrix.length; i++) {
//             for (int j = 0; j < matrix[i].length; j++) {
//                 if(matrix[i][j] == 0){
//                     rowChk[i] = 0;
//                     colChk[j] = 0;
//                 }
//             }
//         }
//         for (int i = matrix.length - 1; i >= 0; i--) {
//             for (int j = matrix[0].length - 1; j >= 0; j--) {
//                 if(rowChk[i] == 0 || colChk[j] == 0) matrix[i][j] = 0;
//             }
//         }
//     }
// }



//taking 2 arrays  as 0th row and 0th column of main matrix
class Solution {
    public void setZeroes(int[][] matrix) {
        boolean wL = true;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if(matrix[i][j] == 0){
                    if(i == 0)
                        wL = false;
                    else
                        matrix[0][j] = 0;
                        matrix[i][0] = 0;
                }
            }
        }
        for (int i = matrix.length - 1; i >= 0; i--) {
            for (int j = matrix[0].length - 1; j >= 0; j--) {
                if(i == 0 ){
                    if(!wL || matrix[0][j] == 0) matrix[i][j] = 0;
                }
                else if(matrix[i][0] == 0 || matrix[0][j] == 0) matrix[i][j] = 0;
            }
        }
    }
}