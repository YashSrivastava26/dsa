import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    // Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> bfs = new ArrayList<>();
        boolean visited[] = new boolean[V];

        Queue<Integer> que = new LinkedList<>();
        
        que.add(0);
        visited[0] = true;

        while(!(que.isEmpty())){
            Integer popElement = que.poll();
            bfs.add(popElement);
            for (int i = 0; i < adj.get(popElement).size(); i++) {
                if(visited[adj.get(popElement).get(i)] == false)
                    que.add(adj.get(popElement).get(i));
                    visited[adj.get(popElement).get(i)] = true;
            }
        }
        return bfs;
    }
}
