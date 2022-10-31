import java.util.LinkedList;
import java.util.Queue;


//leetcode
// class Solution{

//     static void replace(char a[][],int row, int col, int[][] vis){
//         int n = a.length, m = a[0].length;
//         vis[row][col] = 1;

//         int delRow[] = {-1, 0, 1, 0};
//         int delCol[] = {0, 1, 0, -1};
        
//         for (int i = 0; i < 4; i++) {
//             int newRow = row + delRow[i];
//             int newCol = col + delCol[i];
//             if(newCol < m - 1 && newRow < n && newCol >= 0 && newRow >= 0 && a[newRow][newCol] == 'O' && vis[newRow][newCol] == 0)
//                 replace(a, newRow, newCol, vis);
//         }
//     }

//     static char[][] solve(char a[][])
//     {
//         int n = a.length, m = a[0].length;            
//         int vis[][] = new int[n][m];
//         for (int i = 0; i < n; i++) {
//             if(a[i][0] == 'O' && vis[i][0] == 0) replace(a, i, 0, vis);
//             if(a[i][m - 1] == 'O' && vis[i][ m - 1] == 0) replace(a, i, m - 1, vis);  
//         }
//         for (int i = 0; i < m; i++) {
//             if(a[0][i] == 'O' && vis[0][i] == 0) replace(a, 0, i, vis);
//             if(a[n - 1][i] == 'O' && vis[ n - 1][i] == 0) replace(a,  n - 1, i, vis); 
//         }

//         for (int i = 0; i < n; i++) {
//             for (int j = 0; j < m; j++) {
//                 if(vis[i][j] == 1) a[i][j] = 'O';
//                 else a[i][j] = 'X';
//             }
//         }
//         return a;

//     }
// }

//gfg
class Solution{

    private static void dfs(char[][] board, char[][] ans, int row, int col){
        int delRow[] = {-1, 0, 1, 0}, delCol[] = {0, 1, 0, -1};
        ans[row][col] = '#';

        for (int i = 0; i < delCol.length; i++) {
            int newRow = row + delRow[i], newCol = col + delCol[i];

            if(newRow >= 0 && newCol >= 0 && newRow < board.length && newCol < board[0].length && board[newRow][newCol] == 'O' && ans[newRow][newCol] != '#')
                dfs(board, ans, newRow, newCol);
        }
    }

    static char[][] fill(int n, int m, char board[][])
    {
        char ans[][] = board.clone();

        for (int i = 0; i < n; i++) {
            if(board[i][m - 1] == 'O')
                dfs(board, ans, i, m - 1);
            if(board[i][0] == 'O')
                dfs(board, ans, i, 0);
        }
        for (int i = 0; i < m; i++) {
            if(board[n - 1][i] == 'O') 
                dfs(board, ans, n - 1, i);
            if(board[0][i] == 'O')
                dfs(board, ans, 0, i);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(ans[i][j] == 'O') ans[i][j] = 'X';
                else if(ans[i][j] == '#') ans[i][j] = 'O';
            }
        }
        return ans;

    }
}