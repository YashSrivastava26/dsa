import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import javax.swing.plaf.nimbus.NimbusLookAndFeel;

class Solution
{
    static int[] findOrder(int n, int m, ArrayList<ArrayList<Integer>> prerequisites) 
    {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            adj.get(prerequisites.get(i).get(1)).add(prerequisites.get(i).get(0));
        }

        int inDegree[] = new int[n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < adj.get(i).size(); j++) {
                inDegree[adj.get(i).get(j)]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < n;i++) {
            if(inDegree[i] == 0) q.add(i);
        }

        int ans[] = new int[n];
        int idx = 0;
        while(!q.isEmpty()){
            int node = q.poll();
            ans[idx++] = node;
            for (int i = 0; i < adj.get(node).size(); i++) {
                int adjNode = adj.get(node).get(i);
                inDegree[adjNode]--;
                if(inDegree[adjNode] == 0) q.add(adjNode);
            }
        }
        if(idx == n) return ans;
        return new int[]{};
    }
}