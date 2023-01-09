import java.util.*;

//using loop to see issafe
// class Solution {

//     private boolean isSafe(int row, int col, char[][] board, int n){
//         int i = row;
//         int j = col;

//         //upper daigonal
//         while(i >= 0 && j >= 0){
//             if(board[i][j] == 'Q'){
//                 return false;
//             }
//             i--;
//             j--;
//         }

//         //check Row
//         j = col;
//         while(j >= 0){
//             if(board[row][j] == 'Q'){
//                 return false;
//             }
//             j--;
//         }

//         //lower daigonal
//         i = row;
//         j = col;

//         while(i < n && j >= 0){
//             if(board[i][j] == 'Q'){
//                 return false;
//             }
//             i++;
//             j--;
//         }
//         return true;
//     }

//     private List<String> makeBoard(char[][] board, int n){
//         List<String> ans = new ArrayList<>();

//         for(int i = 0; i < n; i++){
//             String s = new String(board[i]);
//             ans.add(s);
//         }
//         return ans;
//     }

//     private void putQueenInCol(int col, char[][] board, List<List<String>> ans, int n){
//         if(col == n){
//             ans.add(makeBoard(board, n));
//             return;
//         }

//         for(int row = 0; row < n; row++){
//             if(isSafe(row, col, board, n)){
//                 System.out.println(isSafe(row, col, board, n) + " " + row + " " + col);
//                 board[row][col] = 'Q';
//                 putQueenInCol(col + 1, board, ans, n);
//                 board[row][col] = '.';
//             }
//         }
//     }

//     public List<List<String>> solveNQueens(int n) {
//         List<List<String>> ans = new ArrayList<>();
//         char[][] board = new char[n][n];

//         for(int i = 0; i < n; i++){
//             for(int j = 0; j < n; j++){
//                 board[i][j] = '.';
//             }
//         }
        
//         putQueenInCol(0, board, ans, n);
        
//         return ans;
//     }
// }

//using hashing
//Tc = n! * n
class Solution {

    private List<String> makeBoard(char[][] board, int n){
        List<String> ans = new ArrayList<>();

        for(int i = 0; i < n; i++){
            String s = new String(board[i]);
            ans.add(s);
        }
        return ans;
    }

    private void putQueenInCol(int col, char[][] board, List<List<String>> ans, int n, boolean[] inRowPresent, boolean[] lowerDaigonal, boolean[] upperDaigonal){
        if(col == n){
            ans.add(makeBoard(board, n));
            return;
        }

        for(int row = 0; row < n; row++){
            
            if(inRowPresent[row] || lowerDaigonal[row + col] || upperDaigonal[(col - row) + (n - 1)]){
                continue;
            }

            board[row][col] = 'Q';
            inRowPresent[row] = true;
            lowerDaigonal[row + col] = true;
            upperDaigonal[(col - row) + (n - 1)] = true;

            putQueenInCol(col + 1, board, ans, n, inRowPresent, lowerDaigonal, upperDaigonal);
            
            inRowPresent[row] = false;
            lowerDaigonal[row + col] = false;
            upperDaigonal[(col - row) + (n - 1)] = false;

            board[row][col] = '.';
        }
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        char[][] board = new char[n][n];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                board[i][j] = '.';
            }
        }

        boolean inRowPresent[] = new boolean[n];
        boolean lowerDaigonal[] = new boolean[2 * n - 1];
        boolean upperDaigonal[] = new boolean[2 * n - 1];

        
        putQueenInCol(0, board, ans, n,inRowPresent, lowerDaigonal, upperDaigonal);
        
        return ans;
    }
}