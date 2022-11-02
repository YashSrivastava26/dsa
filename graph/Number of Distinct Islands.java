import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
class Solution {

    void dfs(int[][] vis, int row, int col, ArrayList<String> island, int basei, int basej){
        vis[row][col] = 2;
        island.add(Integer.toString(row - basei) + Integer.toString(col - basej));
        int delRow[] = {-1, 0, 1, 0};
        int delCol[] = {0, 1, 0, -1};

        for (int i = 0; i < 4; i++) {
            int newRow = row + delRow[i];
            int newCol = col + delCol[i];

            if(newCol >= 0 && newRow >= 0 && newCol < vis[0].length && newRow < vis.length && vis[newRow][newCol]  == 1)
                dfs(vis, newRow, newCol, island, basei, basej);
        }
        
    }

    int countDistinctIslands(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int vis[][] = grid.clone();
        Set<ArrayList<String>> ans = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(vis[i][j] == 1){
                    ArrayList<String> island = new ArrayList<>();
                    dfs(vis, i, j, island, i, j);
                    System.out.println(island);
                    if(!ans.contains(island))ans.add(island);
                }
            }
        }
        return ans.size();
    }
}