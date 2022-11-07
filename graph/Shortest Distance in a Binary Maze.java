import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Pair{
    int row, col, dist;
    Pair(int row, int col, int dist){
        this.row = row;
        this.col = col;
        this.dist = dist;
    }
}

class Solution {

    int shortestPath(int[][] grid, int[] source, int[] destination) {
        
        if(grid[source[0]][source[1]] == 0) return -1;
        
        Queue < Pair > q = new LinkedList<>();
        int n = grid.length, m = grid[0].length;
        int delRow[] = {-1, 0, 1, 0};
        int delCol[] = {0, 1, 0, -1};

        int dis[][] =new int[n][m];
        for (int[] is : dis) {
            Arrays.fill(is, (int)1e9);
        }
        q.add(new Pair(source[0], source[1], 0));
        dis[source[0]][source[1]] = 0;
        while(!q.isEmpty()){
            Pair pair = q.peek();
            int row = pair.row;
            int col = pair.col;
            int dist = pair.dist;
            q.remove();

            if(destination[0] == row && destination[1] == col) return dist;
            for (int i = 0; i < 4; i++) {
                int nRow = row + delRow[i];
                int nCol = col + delCol[i];

                if(nCol < m && nRow < n && nCol >= 0 && nRow >= 0 && grid[nRow][nCol] == 1 && dis[nRow][nCol] > dist + 1){
                    q.add(new Pair(nRow, nCol, dist + 1));
                    dis[nRow][nCol] = dist + 1;
                }
            }
        }
        return -1;
    }
}
