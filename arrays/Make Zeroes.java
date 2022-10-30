class Solution
{
    public void  MakeZeros(int[][] matrix)
    {
        int matrixClone[][] = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrixClone.length; i++) {
            System.arraycopy(matrix[i], 0, matrixClone[i], 0, matrix[i].length);
        }
        
        for (int i = 0; i < matrixClone.length; i++) {
            for (int j = 0; j < matrixClone[i].length; j++) {
                if(matrixClone[i][j] == 0){
                    if(i > 0){
                        matrix[i][j] += matrixClone[i - 1][j];
                        matrix[i - 1][j] = 0;
                    }
                    if(i < matrix.length - 1){
                        matrix[i][j] += matrixClone[i + 1][j];
                        matrix[i + 1][j] = 0;
                    }
                    if(j > 0){
                        matrix[i][j] += matrixClone[i][j - 1];
                        matrix[i][j - 1] = 0;
                    }
                    if(j < matrix[0].length - 1){
                        matrix[i][j] += matrixClone[i][j + 1];
                        matrix[i][j + 1] = 0;
                    }
                }
            }
        }
    }
}