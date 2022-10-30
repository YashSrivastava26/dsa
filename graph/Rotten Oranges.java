import java.util.LinkedList;
import java.util.Queue;

class cordTime{
    int row ,col, time;
    cordTime(int r, int c, int t){
        row = r;
        col = c;
        time = t;
    }
}


class Solution
{

    private int bfs(int[][] grid, Queue<cordTime> queue){
        int t = 0;
        while(!queue.isEmpty()){
            int r = queue.peek().row;
            int c = queue.peek().col;
            t = queue.peek().time;
            queue.remove();
            if(r > 0 && grid[r - 1][c] == 1){ 
                queue.add(new cordTime(r - 1, c, t + 1));
                grid[r - 1][c] = 2;
            }
            if(c > 0 && grid[r][c - 1] == 1){ 
                queue.add(new cordTime(r , c - 1, t + 1));
                grid[r][c - 1] = 2;
            }
            if(r < grid.length - 1 && grid[r + 1][c] == 1){ 
                queue.add(new cordTime(r + 1, c, t + 1));
                grid[r + 1][c] = 2;
            }
            if(c < grid[0].length - 1 && grid[r][c + 1] == 1){ 
                queue.add(new cordTime(r, c + 1, t + 1));
                grid[r][c + 1] = 2;
            }
        }
        return t;
    }

    //Function to find minimum time required to rot all oranges. 
    public int orangesRotting(int[][] grid)
    {
        Queue<cordTime> queue = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == 2){ 
                    queue.add(new cordTime(i, j, 0));
                }
            }
        }
        int time = bfs(grid, queue);
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == 1) return -1;
            }
        }
        return time;
    }
}
