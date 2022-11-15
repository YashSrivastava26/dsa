import java.util.ArrayList;
import java.util.HashSet;

class Edge{
    int src, dest;
    Edge(int src, int dest){
        this.src = src;
        this.dest = dest;
    }
};


class DisJointSet{
    ArrayList < Integer > size = new ArrayList<>();
    ArrayList < Integer > parent = new ArrayList<>();
    DisJointSet(int V){
        for (int i = 0; i <= V; i++) {
            parent.add(i);
            size.add(1);
        }
    }


    int findParent(int node){
        if(parent.get(node) == node) return node;
        int ult_p = findParent(parent.get(node));
        parent.set(node, ult_p);
        return parent.get(node);
    }

    void unionSet(int x, int y){
        int parent_x = findParent(x);
        int parent_y = findParent(y);

        if(parent_x == parent_y) return;
        if(size.get(parent_x) < size.get(parent_y)){
            parent.set(parent_x, parent_y);
            size.set(parent_y, size.get(parent_y) + size.get(parent_x));
        }
        else{
            parent.set(parent_y, parent_x);
            size.set(parent_x, size.get(parent_y) + size.get(parent_x));
        }
    }
    int findComponents(){
        int count = 0;
        for (int i = 0; i < parent.size(); i++) {
            if(parent.get(i) == i) count++;
        }
        return count - 1;
    }
    void printArr(){
        for (int i = 0; i < parent.size(); i++) {
            System.out.println(parent.get(i) + " " + size.get(i));
        }

        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
    }
}

class Solution {

    static boolean inRange(int row, int col, int n){
        if(row >= 0 && col >= 0 && row < n && col < n) return true;
        return false;
    }
    
    public int largestIsland(int[][] grid) {
        int n = grid.length;
        DisJointSet dSet = new DisJointSet(n * n);

        int dRow[] = {-1, 0, 1, 0};
        int dCol[] = {0, -1, 0, 1};
        //O(n * n)
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if(grid[row][col] == 1){
                    int node = row * n + col;
                    for (int i = 0; i < 4; i++) {
                        int nRow = dRow[i] + row;
                        int nCol = dCol[i] + col;
                        if(inRange(nRow, nCol, n) && grid[nRow][nCol] == 1){
                            int adjNode = nRow * n + nCol;
                            dSet.unionSet(node, adjNode);
                        }
                    }
                }
            }
        }

        int maxCount = 0;
        //TC = O(n * n * 4 * log(n))
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if(grid[row][col] == 0){
                    int node = row * n + col;
                    HashSet <Integer> neighbourParent = new HashSet<>();
                    for (int i = 0; i < 4; i++) {
                        int nRow = dRow[i] + row;
                        int nCol = dCol[i] + col;
                        if(inRange(nRow, nCol, n)){
                            if(grid[nRow][nCol] == 1){
                                int adjNode = nRow * n + nCol;
                                int adjParent = dSet.findParent(adjNode);
                                neighbourParent.add(adjParent);
                            }
                        }
                    }

                    int count = 0;
                    for (Integer it : neighbourParent) {
                        //System.out.println(it + " " + dSet.size.get(it));
                        count += dSet.size.get(it);
                    }
                    maxCount = Math.max(maxCount, count + 1);
                }
            }
        }

        for (int i = 0; i < n * n; i++) {
            //System.out.println(dSet.size.get(i) + " " + i);
            maxCount = Math.max(maxCount, dSet.size.get(i));
        }
        
        return maxCount;
    }
}