import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

// class Solution {

//     static void dfs(ArrayList<ArrayList<Integer>> adj, int node, boolean[] visited){
//         for (int i = 0; i < adj.get(node).size(); i++) {
//             if(adj.get(node).get(i) == 1 && visited[i] == false){
//                 visited[i] = true;
//                 dfs(adj, i, visited);
//             }
//         }
//     }

//     static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
//         int noOfNodes = adj.size();
//         boolean visited[] = new boolean[noOfNodes];
//         Queue<Integer> queue = new LinkedList<>();
//         int count = 0;

//         for (int i = 0; i < visited.length; i++) {
//             if(visited[i] == false){
//                 dfs(adj, i, visited);
//                 count++;
//             }
//         }       
//         return count;
//     }
// }

class Solution {

    static void dfs(int[][] adj, int node, boolean[] visited){
        for (int i = 0; i < adj[node].length; i++) {
            if(adj[node][i] == 1 && visited[i] == false){
                visited[i] = true;
                dfs(adj, i, visited);
            }
        }
    }

    public int findCircleNum(int[][] isConnected) {
        boolean visited[] = new boolean[isConnected.length];
        int count = 0;

        for (int i = 0; i < visited.length; i++) {
            if(visited[i] == false){
                dfs(isConnected, i, visited);
                count++;
            }
        }       
        return count;
    }
}