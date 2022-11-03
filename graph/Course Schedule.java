class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int vis[] = 
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