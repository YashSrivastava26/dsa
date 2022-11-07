//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
@SuppressWarnings("unchecked") class Shortest_Path_in_Weighted_undirected_graph {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int edges[][] = new int[m][3];
            for (int i = 0; i < m; i++) {
                edges[i][0] = sc.nextInt();
                edges[i][1] = sc.nextInt();
                edges[i][2] = sc.nextInt();
            }
            Solution obj = new Solution();
            List<Integer> ans = obj.shortestPath(n, m, edges);
            for (int e : ans) {
                System.out.print(e + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Pair{
    int dist, node;
    Pair(int node, int dist){
        this.node = node;
        this.dist = dist;
    }
}
class Solution {
    public static List<Integer> shortestPath(int n, int m, int edges[][]) {
        
        ArrayList < ArrayList < Pair > > adj = new ArrayList<>(); 
        //O(n)
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        //O(m)
        for (int i = 0; i < m; i++) {
            adj.get(edges[i][0]).add(new Pair(edges[i][1], edges[i][2]));
            adj.get(edges[i][1]).add(new Pair(edges[i][0], edges[i][2]));
        }

        PriorityQueue< Pair > pq = new PriorityQueue<>((x, y) -> x.dist - y.dist);
        int dis[] = new int[n + 1];
        int parent[] = new int[n + 1];
        //O(n)
        for (int i = 0; i < n + 1; i++) {
            parent[i] = -1;
            dis[i] = (int)1e9;

        }
        pq.add(new Pair(1, 0));
        dis[1] = 0;
        //O(V* ((V * log(heapSize)) + log(heapSize)))
        //O(V * log(heapSize) * (V + 1))
        //O(V^2 * log(V^2))
        //O(V^2 * 2 * log(V))
        //O(E * log(V))

        while(!pq.isEmpty()){
            Pair pair = pq.peek();
            int node = pair.node;
            int currDist = pair.dist;
            pq.remove();

            for (Pair it : adj.get(node)) {
                int adjNode = it.node;
                int edgeWeight = it.dist;

                if(edgeWeight + currDist < dis[adjNode]){
                    dis[adjNode] = edgeWeight + currDist;
                    pq.add(new Pair(adjNode, currDist + edgeWeight));
                    parent[adjNode] = node;
                }
            }
        }
        List < Integer > ans = new ArrayList<>();
        if(dis[n] == (int) 1e9){
            ans.add(-1);
            return ans;
        }
        int node = n;
        //O(n)
        while(parent[node] != -1){
            ans.add(node);
            node = parent[node];
        } 
        ans.add(1);
        Collections.reverse(ans);
        return ans;
    }
}