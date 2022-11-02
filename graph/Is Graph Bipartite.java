import java.util.LinkedList;
import java.util.Queue;

class Solution {

    public boolean dfs(int node, int[] vis, int color, int[][] graph){
        vis[node] = color;
        
        for (int i = 0; i < graph[node].length; i++) {
            for (int j = 0; j < vis.length; j++)
                System.out.print(vis[i]);
            int newNode = graph[node][i];
            if(vis[newNode] == 0){
                if(color == 1) dfs(newNode, vis, 2, graph);
                else dfs(newNode, vis, 1, graph);
            }
            else if(Math.abs(color - vis[i]) != 1) return false;
        }
        return true;
    }
    
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int vis[] = new int[n];
        for (int i = 0; i < vis.length; i++) {
            if(vis[i] == 0) 
                if(!dfs(i, vis, 1, graph))
                    return false;
        }
        return true;
    }
}
