import java.util.ArrayList;

class Solution {

    private boolean checkCycle(int node, ArrayList<ArrayList<Integer>> adj, boolean[] vis, boolean[] pathVis){
        vis[node] = true;
        pathVis[node] = true;
        for (int newNode : adj.get(node)) {
            if(!vis[newNode]) {
                if(checkCycle(newNode, adj, vis, pathVis)) 
                    return true;
            }
            else if(pathVis[newNode]) return true;
        }
        pathVis[node] = false;
        return false;
    }
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean vis[] = new boolean[V];
        boolean pathVis[] = new boolean[V];
        for (int i = 0; i < vis.length; i++) {
            if(!vis[i]){
                if(checkCycle(i, adj, vis, pathVis)) return true;
            }
        }
        return false;
    }
}