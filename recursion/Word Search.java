class Solution {
    private boolean inRange(int i, int j, int n, int m){
        if(i >= 0 && j >= 0 && i < n && j < m){
            return true;
        }
        return false;
    }
    
    private boolean dfs(int i, int j, int idx, String word, char[][] board, int vis[][], int n, int m){
        if(idx == word.length() - 1){
            if(word.charAt(idx) == board[i][j]){
                return true;
            }
            return false;
        }
        if(word.charAt(idx) != board[i][j]){
            return false;
        }
        
        int delRow[] = {1, 0, -1, 0};
        int delCol[] = {0, 1, 0, -1};
        
        for(int k = 0; k < 4; k++){
            int nR = delRow[k] + i;
            int nC = delCol[k] + j;
            if(inRange(nR, nC, n, m) && vis[nR][nC] == 0){
                vis[nR][nC] = 1;
                
                if(dfs(nR, nC, idx + 1, word, board, vis, n, m)){
                    return true;
                }
                
                vis[nR][nC] = 0;
            }
        }
        return false;
    }

    public boolean exist(char[][] board, String word) {
        int n = board.length, m = board[0].length;
        if(word.length() > n * m){
            return false;
        }
        
        int vis[][] = new int[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                
                vis[i][j] = 1;
                if(dfs(i, j, 0, word, board, vis, n, m)){
                    return true;
                }
                vis[i][j] = 0;
                
            }
        }
        return false;
    }
}