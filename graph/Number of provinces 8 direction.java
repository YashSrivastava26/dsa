import java.util.LinkedList;
import java.util.Queue;

class Pair{
    int row, col;
    Pair(int r, int c){
        row = r;
        col = c;
    }
}
class Solution {

    void dfs(char[][] grid, int i, int j){
        int n = grid.length, m = grid[0].length;
        grid[i][j] = '0';
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(i, j));
        while(!queue.isEmpty()){
            int row = queue.peek().row;
            int col = queue.peek().col;
            queue.remove();

            
            for (int k = -1; k <= 1; k++) {
                for (int k2 = -1; k2 <= 1; k2++) {
                    int r = row + k;
                    int c = col + k2;
                    if(r > 0 || r < n || c >= 0 || c < m || grid[r][c] == '1'){
                        queue.add(new Pair(r, c));
                        grid[r][c] = '0';
                    }
                }
            }
        }
    }

    public int numIslands(char[][] grid) {
        int n = grid.length, m = grid[0].length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(grid[i][j] == '1'){
                    dfs(grid, i , j);
                    count++;
                }
            }
        }
        return count;
        
    }
}
