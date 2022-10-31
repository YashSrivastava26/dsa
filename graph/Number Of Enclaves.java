class Solution {

    private void dfs(int[][] grid, int[][] vis, int row, int col){
        int n = grid.length, m = grid[0].length;
        vis[row][col] = 1;

        int delRow[] = {-1, 0, 1, 0};
        int delCol[] = {0, 1, 0, -1};
        for (int i = 0; i < 4; i++) {
            int newRow = row + delRow[i];
            int newCol = col + delCol[i];
            if(newRow >= 0 && newCol >= 0 && newCol < m && newRow < n && vis[newRow][newCol] == 0 && grid[newRow][newCol] == 1)
                dfs(grid, vis, newRow, newCol);
        }
    }

    public int numberOfEnclaves(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int vis[][] = new int[n][m];

        for (int i = 0; i < n; i++) {
            if(grid[i][m - 1] == 1) dfs(grid, vis, i, m - 1);
            if(grid[i][0] == 1) dfs(grid, vis, i, 0);
        }
        for (int i = 0; i < m; i++) {
            if(grid[n - 1][i] == 1) dfs(grid, vis, n - 1, i);
            if(grid[0][i] == 1) dfs(grid, vis, 0, i);            
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(grid[i][j] == 1 && vis[i][j] == 0) ans++;
            }
        }
        return ans;
    }
}