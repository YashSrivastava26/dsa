import java.util.ArrayList;

class Solution {

    private boolean detectCycle(ArrayList<ArrayList<Integer>> adj, int node, boolean[] vis, boolean[] pathVisited){
        vis[node] = true;
        pathVisited[node] = true;

        for (Integer adjEle : adj.get(node)) {
            if(!vis[adjEle]){
                if(detectCycle(adj, adjEle, vis, pathVisited)) return true;
            }
            else if(pathVisited[adjEle]) return true;
            
        }
        pathVisited[node] = false;
        return false;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        boolean vis[] = new boolean[numCourses];
        boolean pathVisited[] = new boolean[numCourses]; 
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        
        for (int i = 0; i < prerequisites.length; i++) {
            adj.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }

        for (int i = 0; i < vis.length; i++) {
            if(!vis[i] && detectCycle(adj, i, vis, pathVisited)) return false;
        }
        return true;
    }
}


// kahns algo bfs
// class Solution {
//     public boolean canFinish(int n, int[][] prerequisites) {
//         ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

//         for (int i = 0; i < n; i++) {
//             adj.add(new ArrayList<>());
//         }

//         for (int i = 0; i < prerequisites.length; i++) {
//             adj.get(prerequisites[i][0]).add(prerequisites[i][1]);
//         }

//         int inDegree[] = new int[n];

//         for (int i = 0; i < n; i++) {
//             for (int j = 0; j < adj.get(i).size(); j++) {
//                 inDegree[adj.get(i).get(j)]++;
//             }
//         }

//         Queue<Integer> q = new LinkedList<>();

//         for (int i = 0; i < n;i++) {
//             if(inDegree[i] == 0) q.add(i);
//         }

//         int idx = 0;
//         while(!q.isEmpty()){
//             int node = q.poll();
//             idx++;
//             for (int i = 0; i < adj.get(node).size(); i++) {
//                 int adjNode = adj.get(node).get(i);
//                 inDegree[adjNode]--;
//                 if(inDegree[adjNode] == 0) q.add(adjNode);
//             }
//         }
//         if(idx == n) return true;
//         return false;
//     }
// }