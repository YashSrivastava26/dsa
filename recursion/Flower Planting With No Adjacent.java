import java.util.*;
class Solution {

    private boolean isValid(ArrayList<ArrayList<Integer>> adj, int v, int[] color, int currTry){

        for(int adjecent : adj.get(v)){
            if(color[adjecent - 1] == currTry){
                return false;
            }
        }
        return true;
    }

    private boolean tryAllCombo(ArrayList<ArrayList<Integer>> adj, int v, int[] color, int n){
        if(v == n + 1){
            return true;
        }

        for(int i = 1; i <= 4; i++){
            if(isValid(adj, v, color, i)){
                color[v - 1] = i;
                if(tryAllCombo(adj, v + 1, color, n)){
                    return true;
                }
                color[v - 1] = 0;
            }
        }
        return false;
    }

    public int[] gardenNoAdj(int n, int[][] paths) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i = 0; i <= n; i++){
            adj.add(new ArrayList<Integer>());
        }

        int m = paths.length;
        for(int i = 0; i < m; i++){
            adj.get(paths[i][0]).add(paths[i][1]);
            adj.get(paths[i][1]).add(paths[i][0]);
        }
        int color[] = new int[n];
        tryAllCombo(adj, 1, color, n);
        return color;
    }
}