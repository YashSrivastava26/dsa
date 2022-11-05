import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

class Pair{
    int node, edgeWeight;
    Pair(int node, int edgeWeight){
        this.node = node;
        this.edgeWeight = edgeWeight;
    }
}

class Solution {

    private void dfs(int node, Deque<Integer> stack, int[] vis, ArrayList<ArrayList<Pair>> adj){
        vis[node] = 1;
        
        for (Pair adjNodePair : adj.get(node)) {
            if(vis[adjNodePair.node] == 0){
                dfs(adjNodePair.node, stack, vis, adj);
            }
        }

        stack.addLast(node);
    }

	public int[] shortestPath(int N,int M, int[][] edges) {
		int vis[] = new int[N];
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            adj.get(edges[i][0]).add(new Pair(edges[i][1], edges[i][2]));
        }

        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            if(vis[i] == 0) dfs(i, stack, vis, adj);
        }

        int path[] = new int[N];
        Arrays.fill(path, Integer.MAX_VALUE);
        path[0] = 0;
        while(!stack.isEmpty()){
            int popEle = stack.removeLast();
            int currDist = path[popEle];

            for (Pair adjPair : adj.get(popEle)) {
                path[adjPair.node] =  Math.min(path[adjPair.node], currDist + adjPair.edgeWeight);
            }
        }

        for (int i = 0; i < path.length; i++) {
            if(path[i] == Integer.MAX_VALUE) path[i] = -1;
        }
        return path;
	}
}