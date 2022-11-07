class Pair{
    int row, col, dist;
    Pair(int row, int col, int dist){
        this.row = row;
        this.col = col;
        this.dist = dist;
    }
}

class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0] == 1) return -1;
        
        Queue < Pair > q = new LinkedList<>();
        int n = grid.length, m = grid[0].length;

        int source[] = {0,0};
        int destination[] = {n - 1, m - 1};

        int delRow[] = {-1, 0, 1};
        int delCol[] = {-1, 0, 1};
        
        int dis[][] =new int[n][m];
        for (int[] is : dis) {
            Arrays.fill(is, (int)1e9);
        }

        q.add(new Pair(source[0], source[1], 1));
        dis[source[0]][source[1]] = 1;
        while(!q.isEmpty()){
            Pair pair = q.peek();
            int row = pair.row;
            int col = pair.col;
            int dist = pair.dist;
            q.remove();

            if(destination[0] == row && destination[1] == col) return dist;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    int nRow = row + delRow[i];
                    int nCol = col + delCol[j];

                    if(nCol < m && nRow < n && nCol >= 0 && nRow >= 0 && grid[nRow][nCol] == 0 && dis[nRow][nCol] > dist + 1){
                        q.add(new Pair(nRow, nCol, dist + 1));
                        dis[nRow][nCol] = dist + 1;
                    }
                }
            }
        }
        return -1;
    }
}