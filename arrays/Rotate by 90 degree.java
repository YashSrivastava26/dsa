

// anti clockwise rotate 90 degree
// class Solution
// {
//     //Function to rotate matrix anticlockwise by 90 degrees.
//     static void rotateby90(int matrix[][], int n) 
//     { 
//         for (int row = 0; row < n; row++) {
//             for (int col = row + 1; col < n; col++) {
//                 int temp = matrix[row][col];
//                 matrix[row][col] = matrix[col][row];
//                 matrix[col][row] = temp;
//             }
//         }

//         for (int col = 0; col < n; col++) {
//             for (int row = 0; row < n / 2; row++) {
//                 int temp = matrix[row][col];
//                 matrix[row][col] = matrix[n - row - 1][col];
//                 matrix[n - row - 1][col] = temp;
//             }
//         }
//     }
// }


// clockwise rotate 90 degree

class Solution {
    public void rotate(int[][] matrix) {
        int noOfRows = matrix.length, noOfCols = matrix[0].length;
        for (int i = 0; i < noOfRows; i++) {
            for (int j = i + 1; j < noOfCols; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for (int i = 0; i < noOfRows; i++) {
            for (int j = 0; j < noOfCols / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][noOfCols - j - 1];
                matrix[i][noOfCols - j - 1] = temp;
            }
        }
    }
}