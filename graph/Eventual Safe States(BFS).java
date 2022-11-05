import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {

    List<Integer> eventualSafeNodes(int V, List<List<Integer>> adj) {
        List<List<Integer>> revAdj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            revAdj.add(new ArrayList<>());
        }
        int inDegree[] = new int[V];
        for (int i = 0; i < V; i++) {
            for (int adjNode : adj.get(i)) {
                revAdj.get(adjNode).add(i);
                inDegree[i] ++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if(inDegree[i] == 0){ 
                q.add(i);
            }
        }
        List<Integer> ans = new ArrayList<>();
        while(!q.isEmpty()){
            int ele = q.poll();
            ans.add(ele);
            for (int adjEle : revAdj.get(ele)) {
                inDegree[adjEle]--;
                if(inDegree[adjEle] == 0) q.add(adjEle);
            }
        }
        Collections.sort(ans);
        return ans;
    }
}