import java.util.ArrayList;
import java.util.PriorityQueue;

class Pair{
    int node, wt;
    Pair(int wt, int node){
        this.node = node;
        this.wt = wt;
    }
}
class Solution
{
    //Function to find sum of weights of edges of the Minimum Spanning Tree.
    static int spanningTree(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj) 
    {
        PriorityQueue < Pair > pq= new PriorityQueue<>((x, y) -> x.wt - y.wt);
        int vis[] = new int[V];
        pq.add(new Pair(0 , 0));
        int mstWeight = 0;
        while(!pq.isEmpty()){
            Pair currPair = pq.poll();
            int wt = currPair.wt;
            int node = currPair.node;

            if(vis[node] == 0){
                mstWeight += wt;
                vis[node] = 1; 
                for (ArrayList < Integer > it : adj.get(node)) {
                    int adjNode = it.get(0);
                    int adjWeight = it.get(1);
                    if(vis[adjNode] == 0){
                        pq.add(new Pair(adjWeight, adjNode));
                    }
                }
            }
        }
        return mstWeight;
    }
}