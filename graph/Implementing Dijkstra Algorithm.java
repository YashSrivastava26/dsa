import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;


class Pair{
    int dist, node;
    Pair(int dist, int node){
        this.dist = dist;
        this.node = node;
    }
}



class Solution
{
    //Function to find the shortest distance of all the vertices
    //from the source vertex S.
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {
        int dis[] = new int[V];
        Arrays.fill(dis, (int) 1e9);
        PriorityQueue<Pair> q = new PriorityQueue<>((x, y) -> x.dist - y.dist);

        dis[S] = 0;
        q.add(new Pair(0, S));
        while(!q.isEmpty()){
            int node = q.peek().node;
            int currDis = q.peek().dist;
            q.remove();

            for (int i = 0; i < adj.get(node).size(); i++) {
                int adjNode = adj.get(node).get(i).get(0);
                int disAdjnode = adj.get(node).get(i).get(1) + currDis;
                if(dis[adjNode] > disAdjnode){
                    dis[adjNode] = disAdjnode;
                    q.add(new Pair(disAdjnode, adjNode));
                }
            }
        }
        return dis;
    }
}