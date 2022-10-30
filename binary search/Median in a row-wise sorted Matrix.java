class Solution {
    int median(int matrix[][], int R, int C) {
        int mid = C / 2;
        int medianSum = 0;
        for (int i = 0; i < matrix.length; i++) {
            medianSum += matrix[i][mid];
        }
        return medianSum / matrix.length;      
    }
}