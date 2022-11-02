import java.security.KeyStore.PrivateKeyEntry;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

// class Solution {

//     private boolean dfs(int node, int[] color, int currColor, int[][] graph){
//         color[node] = currColor;
//         int nextColor = currColor == 1 ? 2 : 1;
        
//         for (int i = 0; i < graph[node].length; i++) {
//             int newNode = graph[node][i];
//             System.out.println(node + " " + currColor + " " + newNode + " " + color[newNode] + " " + nextColor);
//             if(color[newNode] != 0 && color[newNode] != nextColor) return false;
//             if(color[newNode] == 0) if(!dfs(newNode, color, nextColor, graph)) return false;
//         }
//         return true;
//     }
//     public boolean isBipartite(int[][] graph) {
//         int n = graph.length;
//         int color[] = new int[n];
//         for (int i = 0; i < color.length; i++) {
//             if(color[i] == 0) 
//                 if(!dfs(i, color, 1, graph))
//                     return false;
//         }
//         return true;
//     }
// }

// bfs
class Pair{
    int node, nodeColor;
    Pair(int node, int nodeColor){
        this.node = node;
        this.nodeColor = nodeColor;
    }
}

class Solution {

    private boolean check(int node, int[] color, int[][] graph){
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(node, 1));
        color[node] = 1;
        
        while(!q.isEmpty()){
            int currNode = q.peek().node;

            int nextColor = q.peek().nodeColor == 1 ? 2 : 1;
            q.remove();

            for (int i = 0; i < graph[currNode].length; i++) {
                int nextNode = graph[currNode][i];
                if(color[nextNode] == 0){ 
                    q.add(new Pair(nextNode, nextColor));
                    color[nextNode] = nextColor;
                }
                else if(nextColor != color[nextNode]) return false;
            }

        }
        return true;
    }
    
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int color[] = new int[n];
        Queue<Pair> q = new LinkedList<>();
        for (int i = 0; i < color.length; i++) {
            if(color[i] == 0) 
                if(!check(i, color, graph)) return false;
        }
        return true;
    }
}

