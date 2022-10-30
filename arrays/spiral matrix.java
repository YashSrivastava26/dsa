import java.util.*;

// class Solution {
//     public List<Integer> spiralOrder(int[][] matrix) {
//         int startRow = 0, endRow = matrix.length - 1, startCol = 0, endCol = matrix[0].length - 1;
//         ArrayList<Integer> spiralIteration = new ArrayList<>();
//         while(startRow <= endRow && startCol <= endCol){
            
//             for (int i = startCol; i <= endCol; i++) {
//                 spiralIteration.add(matrix[startRow][i]);
//             }
//             startRow++;

//             for (int i = startRow; i <= endRow; i++) {
//                 spiralIteration.add(matrix[i][endCol]);
//             }
//             endCol--;

//             if(startRow <= endRow){
//                 for (int i = endCol; i >= startCol; i--) {
//                     spiralIteration.add(matrix[endRow][i]);
//                 }
//                 endRow--;
//             }

//             if(startCol <= endCol){
//                 for (int i = endRow; i >= startRow; i--) {
//                     spiralIteration.add(matrix[i][startCol]);
//                 }
//                 startCol++;
//         }
//         }
//         return spiralIteration;
//     }
// }