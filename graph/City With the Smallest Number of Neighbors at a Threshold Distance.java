class Solution {
    int findCity(int n, int m, int[][] edges, int distanceThreshold) {
        int dist[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dist[i][j] = Integer.MAX_VALUE;
            }
        }
        for (int i = 0; i < m; i++) {
            int node1 = edges[i][0];
            int node2 = edges[i][1];
            int wt = edges[i][2];
            dist[node1][node2] = wt;
            dist[node2][node1] = wt;
        }
        for (int i = 0; i < n; i++){
            dist[i][i] = 0;
        }
        for (int via = 0; via < n; via++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dist[i][via] != Integer.MAX_VALUE && dist[via][j] != Integer.MAX_VALUE
                            && dist[i][via] + dist[via][j] < dist[i][j]) {
                        dist[i][j] = dist[i][via] + dist[via][j];
                    }
                }
            }
        }

        int mini = n, city = -1;
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (dist[i][j] <= distanceThreshold)
                    count++;
            }
            if (count <= mini) {
                mini = count;
                city = i;
            }
        }
        return city;
    }
}


