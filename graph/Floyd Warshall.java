class Solution
{
    public void shortest_distance(int[][] matrix)
    {
        int n = matrix.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(matrix[i][j] == -1){
                    matrix[i][j] = (int) 1e9;
                }
                if(i == j) matrix[i][j] = 0;
            }
        }
        
        for (int via = 0; via < n; via++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                        matrix[i][j] = Math.min(matrix[i][via] + matrix[via][j], matrix[i][j]);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(matrix[i][j] == (int) 1e9){
                    matrix[i][j] = -1;
                }
            }
        }
    }
}