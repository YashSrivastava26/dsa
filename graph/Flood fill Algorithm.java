class Solution
{

    private void dfs(int[][] img, int row, int col, int clr, int newcolor){
        if(row < 0 || row >= img.length || col < 0 || col >= img[0].length || img[row][col] != clr || img[row][col] == newcolor) return;
        img[row][col] = newcolor;
        dfs(img, row - 1, col, clr, newcolor);
        dfs(img, row + 1, col, clr, newcolor);
        dfs(img, row, col - 1, clr, newcolor);
        dfs(img, row, col + 1, clr, newcolor);
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor)
    {
        int clr = image[sr][sc];
        dfs(image, sr, sc, clr, newColor);
        return image;
    }
}