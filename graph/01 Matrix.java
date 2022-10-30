import java.util.LinkedList;
import java.util.Queue;

class Pair{
    int row, col, level;
    Pair(int row, int col, int level){
        this.row = row;
        this.col = col;
        this.level = level;
    }
}
// class Solution {

//     private void disFun(int[][] mat, Queue<Pair> q, int[][] vis, int[][] dist){
//         int delRow[] = {-1, 0, 1, 0};
//         int delCol[] = {0, 1, 0, -1};

//         while(!q.isEmpty()){
//             int row = q.peek().row;
//             int col = q.peek().col;
//             int level = q.peek().level;
//             q.remove();

//             dist[row][col] = level;
//             for (int i = 0; i < 4; i++) {
//                 int newRow = row + delRow[i];
//                 int newCol = col + delCol[i];

//                 if(newCol >= 0 && newRow >= 0 && newCol < mat[0].length && newRow < mat.length && vis[newRow][newCol] == 0){
//                     q.add(new Pair(newRow, newCol, level + 1));
//                     vis[newRow][newCol] = 1;
//                 }
//             }
//         }
//     }

//     public int[][] updateMatrix(int[][] mat) {
//         int n = mat.length, m = mat[0].length;
//         int vis[][] = new int[n][m];
//         int dist[][] = new int[n][m];
//         Queue<Pair> q = new LinkedList<>();

//         for (int i = 0; i < n; i++) {
//             for (int j = 0; j < m; j++) {
//                 if(mat[i][j] == 0){
//                     q.add(new Pair(i, j, 0));
//                     vis[i][j] = 1;
//                 }
//                 else vis[i][j] = 0;
//             }
//         }
//         disFun(mat, q, vis, dist);
//         return dist;
//     }
// }

//taking visited array and ans matrix same
class Solution {

    private void disFun(int[][] mat, Queue<Pair> q, int[][] dist){
        int delRow[] = {-1, 0, 1, 0};
        int delCol[] = {0, 1, 0, -1};

        while(!q.isEmpty()){
            int row = q.peek().row;
            int col = q.peek().col;
            int level = q.peek().level;
            q.remove();
            for (int i = 0; i < 4; i++) {
                int newRow = row + delRow[i];
                int newCol = col + delCol[i];

                if(newCol >= 0 && newRow >= 0 && newCol < mat[0].length && newRow < mat.length && dist[newRow][newCol] == -1){
                    q.add(new Pair(newRow, newCol, level + 1));
                    dist[newRow][newCol] = level + 1;
                }
            }
        }
    }

    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length, m = mat[0].length;
        int dist[][] = new int[n][m];
        Queue<Pair> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(mat[i][j] == 0){
                    q.add(new Pair(i, j, 0));
                    dist[i][j] = 0;
                }
                else dist[i][j] = -1;
            }
        }
        disFun(mat, q, dist);
        return dist;
    }
}