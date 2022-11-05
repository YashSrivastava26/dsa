import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;


class Solution {
    
    public int[] shortestPath(int[][] edges,int n,int m ,int src) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] it : edges) {
                adj.get(it[0]).add(it[1]);
                adj.get(it[1]).add(it[0]);
        }

        int dis[] = new int[n];
        Arrays.fill(dis, (int) 1e9);
        Queue<Integer> q = new LinkedList<>();

        q.add(src);
        dis[src] = 0;
        while(!q.isEmpty()){
            int node = q.poll();

            for (int adjNode : adj.get(node)) {
                if(dis[node] + 1 < dis[adjNode]){
                    q.add(adjNode);
                    dis[adjNode] = dis[node] + 1;
                }
            }
        }

        for (int i = 0; i < dis.length; i++) {
            if(dis[i] == (int) 1e9) dis[i] = -1;
        }
        return dis;
    }
}