import java.util.ArrayList;
import java.util.List;


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
    private boolean inRange(int rowIdx, int colIdx, int n, int m){
        if(rowIdx >= 0 && colIdx >= 0 && rowIdx < n && colIdx < m) return true;
        return false;
    }
    
    public List<Integer> numOfIslands(int rows, int cols, int[][] operators) {
        DisJointSet dSet = new DisJointSet(rows * cols);

        
        int vis[][] = new int[rows][cols];

        int delRow[] = {-1, 0, 1, 0};
        int delCol[] = {0, -1, 0, 1};
        int countIsland = 0;

        List<Integer> ans = new ArrayList<>();
        
        int len = operators.length;
        for (int i = 0; i < len; i++) {
            int placeAtRow = operators[i][0];
            int placeAtCol = operators[i][1];
            
            if(vis[placeAtRow][placeAtCol] != 1){
                countIsland ++;
                vis[placeAtRow][placeAtCol] = 1;
                int node = placeAtRow * cols + placeAtCol;

                for (int j = 0; j < 4; j++) {
                    int adjRow = delRow[j] + placeAtRow;
                    int adjCol = delCol[j] + placeAtCol;

                    if(inRange(adjRow, adjCol, rows, cols) && vis[adjRow][adjCol] == 1){
                        int adjNode = adjRow * cols + adjCol;
                        if(dSet.findParent(adjNode) != dSet.findParent(node)){
                            dSet.unionSet(node, adjNode);
                            countIsland--;
                        }
                    }
                }
            }
            ans.add(countIsland);
        }
        return ans;
    } 
}