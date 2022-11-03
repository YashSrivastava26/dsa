import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Solution
{
    //Function to return list containing vertices in Topological order. 
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        int inDegree[] = new int[V];
        for(int i = 0; i < V; i++){
            for(int j = 0; j < adj.get(i).size(); j++){
                inDegree[adj.get(i).get(j)]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < inDegree.length; i++) {
            if(inDegree[i] == 0)  q.add(i);
        }

        int ans[] = new int[V];
        int i = 0;
        
        while(!q.isEmpty()){
            ans[i] = q.poll();
            for (int j = 0; j < adj.get(ans[i]).size(); j++) {
                int adjNode = adj.get(ans[i]).get(j);
                inDegree[adjNode] --;
                if(inDegree[adjNode] == 0) q.add(adjNode);
            }
            i++;
        }
        return ans;
    }
}