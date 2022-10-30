import java.util.*;
//bfs
// class Pair{
//     int node, prev;

//     Pair(int node, int prev){
//         this.node = node;
//         this.prev = prev;
//     }
// }


// class Solution {

//     private boolean detectCycle(ArrayList<ArrayList<Integer>> adj, int node, boolean[] vis){
//         Queue<Pair> queue = new LinkedList<>();
//         vis[node] = true;
//         queue.add(new Pair(node, -1));
//         while(!queue.isEmpty()){
//             int ele = queue.peek().node;
//             int prev = queue.peek().prev;
            
//             queue.remove();
//             for (int i = 0; i < adj.get(ele).size(); i++) {
//                 if(!vis[adj.get(ele).get(i)]){
//                     queue.add(new Pair(adj.get(ele).get(i), ele));
//                     vis[adj.get(ele).get(i)] = true;
//                 }
//                 else if(vis[adj.get(ele).get(i)] && adj.get(ele).get(i) != prev) return true;
//             }
//         }
//         return false;
//     }

//     // Function to detect cycle in an undirected graph.
//     public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
//         boolean vis[] = new boolean[adj.size()];
//         for (int i = 0; i < vis.length; i++) {
//             if(!vis[i]){
//                 if(detectCycle(adj, i, vis)) return true;
//             }
//         }
//         return false;
//     }
// }



//dfs

class Solution {

    private boolean detectCycle(ArrayList<ArrayList<Integer>> adj, int node, int parent, boolean[] vis){
        vis[node] = true;
        for (int i = 0; i < adj.get(node).size(); i++) {
            int ele = adj.get(node).get(i);
            if(!vis[ele]){ 
                if(detectCycle(adj, ele, node, vis)) return true;
            }
            else if(vis[ele] && ele != parent) return true;
        }
        return false;
    }

    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean vis[] = new boolean[adj.size()];
        for (int i = 0; i < vis.length; i++) {
            if(!vis[i]){
                if(detectCycle(adj, i, -1, vis)) return true;
            }
        }
        return false;
    }
}