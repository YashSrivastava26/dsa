import java.util.Arrays;
import java.util.PriorityQueue;

class Pair{
    int row, col, work;
    Pair(int row, int col, int work){
        this.row = row;
        this.col = col;
        this.work = work;
    }
}
class Solution {

    boolean inRange(int row, int col, int n, int m){
        if(row >= 0 && col >= 0 && row < n && col < m) return true;
        return false;
    }
    
    int MinimumEffort(int heights[][]) {
        PriorityQueue < Pair > pq = new PriorityQueue<>((x, y) -> x.work - y.work);
        int n = heights.length, m = heights[0].length;
        int workArr[][] = new int[n][m];
        //O(n)
        for (int[] is : workArr) {
            Arrays.fill(is, (int) 1e9);
        }

        int delRow[] = {-1, 0, 1, 0};
        int delCol[] = {0, 1, 0, -1};

        pq.add(new Pair(0,0,0));
        workArr[0][0] = 0;
        while(!pq.isEmpty()){
            Pair firstPair = pq.peek();
            int row = firstPair.row;
            int col = firstPair.col;
            int work = firstPair.work;
            pq.remove();

            if(row == n - 1 & col == m - 1) return work;

            for (int i = 0; i < 4; i++) {
                int nRow = row + delRow[i];
                int nCol = col + delCol[i];

                if(inRange(nRow, nCol, n ,m) ){
                    int nWork = Math.max(work, Math.abs(heights[nRow][nCol] - heights[row][col]));
                    if(workArr[nRow][nCol] > nWork){
                        pq.add(new Pair(nRow, nCol, nWork));
                        workArr[nRow][nCol] = nWork;
                    }
                }
                    
            }
        }
        
        return -1;
    }
}