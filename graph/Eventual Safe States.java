import java.util.ArrayList;
import java.util.List;

// class Solution {

//     private boolean dfs(List<List<Integer>> adj, int[] vis, int[] pathVis, int node, int[] check){
//         vis[node] = 1;
//         pathVis[node] = 1;
//         check[node] = 0;

//         for (int i = 0; i < adj.get(node).size(); i++) {
//             int newNode = adj.get(node).get(i);
//             if(vis[newNode] == 0){ 
//                 if(dfs(adj, vis, pathVis, newNode, check) == true)
//                     return true;
//             }
//             else if(pathVis[newNode] == 1)
//                 return true;
//         }

//         pathVis[node] = 0;
//         check[node] = 1;
//         return false;
//     }

//     List<Integer> eventualSafeNodes(int V, List<List<Integer>> adj) {
//         int vis[] = new int[V];
//         int pathVis[] = new int[V];
//         int check[] = new int[V];
//         List<Integer> ans = new ArrayList<>();
//         for (int i = 0; i < pathVis.length; i++) {
//             if(vis[i] == 0){
//                 dfs(adj, vis, pathVis, i , check);
//             }
//         }
//         for (int i = 0; i < check.length; i++) {
//             if(check[i] == 1) ans.add(i);
//         }
//         return ans;
//     }
// }


//using vis as a check
class Solution {

    private boolean dfs(List<List<Integer>> adj, int[] vis, int[] pathVis, int node){
        vis[node] = 1;
        pathVis[node] = 1;

        for (int i = 0; i < adj.get(node).size(); i++) {
            int newNode = adj.get(node).get(i);
            if(vis[newNode] == 0){ 
                if(dfs(adj, vis, pathVis, newNode) == true)
                    return true;
            }
            else if(pathVis[newNode] == 1)
                return true;
        }

        pathVis[node] = 0;
        vis[node] = 2;
        return false;
    }

    List<Integer> eventualSafeNodes(int V, List<List<Integer>> adj) {
        int vis[] = new int[V];
        int pathVis[] = new int[V];
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < pathVis.length; i++) {
            if(vis[i] == 0){
                dfs(adj, vis, pathVis, i);
            }
        }
        for (int i = 0; i < vis.length; i++) {
            if(vis[i] == 2) ans.add(i);
        }
        return ans;
    }
}