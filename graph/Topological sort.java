import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

class Solution
{

    private static void dfs(int node, ArrayList<ArrayList<Integer>> adj, int[] vis, Deque<Integer> stack){
        vis[node] = 1;

        for (int i = 0; i < adj.get(node).size(); i++) {
            int newNode = adj.get(node).get(i);
            if(vis[newNode] == 0) dfs(newNode, adj, vis, stack);
        }
        stack.addLast(node);
    }

    //Function to return list containing vertices in Topological order. 
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        int vis[] = new int[V];
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < vis.length; i++) {
            if(vis[i] == 0) dfs(i, adj, vis, stack);
        }
        int ans[] = new int[V];
        int i = 0;
        while(!stack.isEmpty()){
            ans[i] = stack.pollLast();
            i++;
        }
        return ans;
    }
}

