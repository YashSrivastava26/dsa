import java.util.ArrayList;

class Solution {
    // Function to return the adjacency list for each vertex.
    public ArrayList<ArrayList<Integer>> printGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>(adj.size());
        for (int i = 0; i < adj.size(); i++) {
            adj.get(i).add(0,i);
            result.add(new ArrayList<>(adj.get(i)));
        }
        return result;
    }
}
