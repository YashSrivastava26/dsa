import java.util.ArrayList;
import java.util.Collections;

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
}
class Solution
{
    //Function to find sum of weights of edges of the Minimum Spanning Tree.
    static int spanningTree(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj) 
    {
        ArrayList < Edge > edges = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            for (ArrayList < Integer > it : adj.get(i)) {
                int node = i;
                int adjNode = it.get(0);
                int wt = it.get(1);
                Edge temp = new Edge(wt, node, adjNode);
                edges.add(temp);
            }
        }

        Collections.sort(edges);

        int n = edges.size();
        DisJointSet dSet = new DisJointSet(V);
        int mstWeight = 0;
        for (int i = 0; i < n; i++) {
            int node1 = edges.get(i).src;
            int node2 = edges.get(i).dest;
            int wt = edges.get(i).eWt;
            //System.out.println(node1 + " " + dSet.findParent(node1) + "----" + node2 + " " + dSet.findParent(node2));
            if(dSet.findParent(node1) != dSet.findParent(node2)){
                
                mstWeight += wt;
                dSet.unionSet(node1, node2);
                //System.out.println(node1 + " " + dSet.findParent(node1) + "----" + node2 + " " + dSet.findParent(node2) + "         " + mstWeight);
            }

        }
        return mstWeight;
    }
}