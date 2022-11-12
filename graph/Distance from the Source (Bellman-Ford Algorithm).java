import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    static int[] bellman_ford(int V, ArrayList<ArrayList<Integer>> edges, int S) {
        int dist[] = new int[V];
        Arrays.fill(dist, (int) 1e8);
        dist[S] = 0;
        for (int i = 0; i < V - 1; i++) {
            for (int j = 0; j < edges.size(); j++) {
                int u = edges.get(j).get(0);
                int v = edges.get(j).get(1);
                int wt = edges.get(j).get(2);
                if(dist[u] != 1e9 && dist[u] + wt < dist[v]){
                    dist[v] = dist[u] + wt;
                }
            }
        }
        for(int j = 0; j < edges.size(); j++) {
            int u = edges.get(j).get(0);
            int v = edges.get(j).get(1);
            int wt = edges.get(j).get(2);
            if(dist[u] + wt < dist[v]){
                return new int[]{-1};
            }
        }
        return dist;
    }
}