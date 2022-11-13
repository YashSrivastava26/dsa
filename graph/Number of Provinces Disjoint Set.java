import java.util.ArrayList;

class Edge implements Comparable < Edge >{
    int src, dest, eWt;
    Edge(int eWt, int src, int dest){
        this.eWt = eWt;
        this.src = src;
        this.dest = dest;
    }
    public int compareTo(Edge compareEdge){
        return this.eWt - compareEdge.eWt;
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
    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        ArrayList < Edge > edges = new ArrayList<>();
        int n = adj.size();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(adj.get(i).get(j) == 1){
                    int node1 = i;
                    int node2 = j;
                    edges.add(new Edge(1, node1, node2));
                    edges.add(new Edge(1, node2, node1));
                }
            }
        }

        DisJointSet dSet = new DisJointSet(V);
        for (int i = 0; i < edges.size(); i++) {
            dSet.unionSet(edges.get(i).src, edges.get(i).dest);
        }

        return dSet.findComponents();
    }
};