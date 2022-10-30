
import java.util.LinkedList;
import java.util.Queue;

class Pair{
    int row, col, level;
    Pair(int r, int c, int l){
        row = r;
        col = c;
        level = l;
    }
}

class Solution
{

    
    public void disOf1(int[][] grid, Queue<Pair> queue, int[][] ans, int[][] vis){
            
        int delRow[] = {-1, 0, 1, 0};
        int delCol[] = {0, 1, 0, -1};

        while(!queue.isEmpty()){
            int row = queue.peek().row;
            int col = queue.peek().col;
            int lvl = queue.peek().level;
            queue.remove();
            ans[row][col] = lvl;

            
            int newRow, newCol;
            for (int i = 0; i < delCol.length; i++) {
                newRow = row + delRow[i];
                newCol = col + delCol[i];
                if(newCol >=0 && newCol < grid[0].length && newRow >= 0 && newRow < grid.length && vis[newRow][newCol] == 0){
                    queue.add(new Pair(newRow, newCol, lvl + 1));                    
                    vis[newRow][newCol] = 1;
                }
            }
            
        }
    }

    //Function to find distance of nearest 1 in the grid for each cell.
    public int[][] nearest(int[][] grid)
    {
        int n = grid.length, m = grid[0].length;
        int vis[][] = new int[n][m]; 
        int ans[][] = new int[n][m];
        Queue<Pair> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(grid[i][j] == 1){ 
                    queue.add(new Pair(i, j, 0));
                    vis[i][j] = 1;
                }
                vis[i][j] = 0;
            }
        }
        disOf1(grid, queue, ans, vis);
        return ans;
    }
}