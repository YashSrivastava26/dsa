import java.util.ArrayList;

class Solution {

    public void dfs(int node, ArrayList<ArrayList<Integer>> adj,ArrayList<Integer> dfsList, boolean[] visited){
        dfsList.add(node);
        visited[node] = true;

        for (int b : adj.get(node)) {
            if(!visited[b])
                dfs(b, adj, dfsList, visited);
        }
    }

    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> dfsList = new ArrayList<>();
        boolean visited[] = new boolean[V];

        dfs(0, adj, dfsList, visited);
        return dfsList;
    }
}
