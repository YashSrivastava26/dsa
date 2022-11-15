import java.util.ArrayList;
import java.util.HashMap;

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

    int maxRemove(int[][] stones,int n) {

        int maxRow = 0;
        int maxCol = 0;
        
        for (int i = 0; i < n; i++) {
            maxRow = Math.max(maxRow, stones[i][0]);
            maxCol = Math.max(maxCol, stones[i][1]);
        }

        DisJointSet dSet = new DisJointSet(maxRow + maxCol + 1);
        HashMap < Integer, Integer> stoneNodes = new HashMap<>();
        for (int i = 0; i < stones.length; i++) {
            int rowNode = stones[i][0];
            int colNode = stones[i][1] + maxRow + 1;

            dSet.unionSet(rowNode, colNode);

            stoneNodes.put(rowNode, 1);
            stoneNodes.put(colNode, 1);
        }

        int componentsCnt = 0;
        for (HashMap.Entry<Integer, Integer> it : stoneNodes.entrySet()) {
            int parentNode = dSet.findParent(it.getKey());
            if(parentNode == it.getKey()) componentsCnt++;
        }

        return n - componentsCnt;

    }
};