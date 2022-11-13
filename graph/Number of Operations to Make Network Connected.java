import java.util.ArrayList;

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
}


class Solution {
    public int makeConnected(int n, int[][] connections) {
        int m = connections.length;
        int edgeUsed = 0;
        DisJointSet dSet = new DisJointSet(n);
        //O(m * 4 * alpha * 2)
        for (int i = 0; i < m; i++) {
            int src = connections[i][0];
            int dest = connections[i][1];
            if(dSet.findParent(src) != dSet.findParent(dest)){
                dSet.unionSet(src, dest);
                edgeUsed++;
            }
        }
        //O(n)
        int edgeNeed = dSet.findComponents() - 1;
        int remaningEdge = m - edgeUsed;
        
        if(edgeNeed > remaningEdge) return -1;
        return edgeNeed;
    }
}