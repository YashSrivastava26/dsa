import java.util.*;
class Solution {
    
    private static boolean inRange(int nRow, int nCol, int n){
         if(nRow >= 0 && nRow < n && nCol >= 0 && nCol < n) return true;
         return false;
    }
    
    private static void tryAllPossible(int[][] m, int n, int row, int col, StringBuffer curr, ArrayList<String> ans){
        
        if(row == n - 1 && col == n - 1){
            ans.add(curr.toString());
            return;
        }
        
        int delRow[] = {0, 1, 0, -1};
        int delCol[] = {1, 0, -1, 0};
        char currAdd[] = {'R', 'D', 'L', 'U'};
        
        for(int i = 0; i < 4; i++){
            int nRow = delRow[i] + row;
            int nCol = delCol[i] + col;
            
            if(inRange(nRow, nCol, n) && m[nRow][nCol] == 1){
                m[nRow][nCol] = 0;
                curr.append(currAdd[i]);
                
                tryAllPossible(m, n, nRow, nCol, curr, ans);
                
                curr.deleteCharAt(curr.length() - 1);
                m[nRow][nCol] = 1;
            }
        }
        
    }
    
    public static ArrayList<String> findPath(int[][] m, int n) {
        // Your code here
        ArrayList<String> ans = new ArrayList<>();
        if(m[0][0] != 0){
            m[0][0] = 0;
            tryAllPossible(m, n, 0, 0, new StringBuffer(), ans);
            m[0][0] = 1;
        }
            
        if(ans.size() == 0)
            ans.add("-1");
        return ans;
    }
}