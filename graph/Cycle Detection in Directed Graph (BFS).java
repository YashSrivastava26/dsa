import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        int inDegree[] = new int[V];
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < adj.get(i).size(); j++) {
                int ele = adj.get(i).get(j);
                if(ele == i) return true;
                inDegree[ele] ++;
            }
        }
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < inDegree.length; i++) {
            if(inDegree[i] == 0) q.add(i);
        }
        int counterOfDequeueEle = 0;
        while(!q.isEmpty()){
            int ele = q.poll();
            counterOfDequeueEle++;
            for (int i = 0; i < adj.get(ele).size(); i++) {
                int adjEle = adj.get(ele).get(i);
                inDegree[adjEle]--;
                if(inDegree[adjEle] == 0) q.add(adjEle);
            }
        }
        if(counterOfDequeueEle < V) return false;
        return true;
    }
}