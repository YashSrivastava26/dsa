class Solution {

    private boolean isValid(char[][] board, int row, int col, char ch){
        for(int i = 0; i < 9; i++){
            //col check
            if(board[row][i] == ch){
                return false;
            }

            //row check
            if(board[i][col] == ch){
                return false;
            }

            //box check
            int rowBox =3 * (row / 3) + i / 3;
            int colBox = 3 * (col / 3) + i % 3;

            if(board[rowBox][colBox] == ch){
                return false;
            }
        }
        return true;
    }

    private boolean solve(char[][] board){
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){

                if(board[i][j] != '.'){
                    continue;
                }

                for(char ch = '1'; ch <= '9'; ch++){
                    if(isValid(board, i, j, ch)){
                        board[i][j] = ch;
                        if(solve(board)){
                            return true;
                        }
                        else{
                            board[i][j] = '.';
                        }
                    }
                }
                return false;
            }
        }
        return true;
    }

    public void solveSudoku(char[][] board) {
        solve(board);
    }
}