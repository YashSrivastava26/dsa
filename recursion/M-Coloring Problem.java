import java.util.*;
class solve {
    // Function to determine if graph can be coloured with at most M colours
    // such
    // that no two adjacent vertices of graph are coloured with same colour.
    
    private boolean isValidColor(boolean[][] graph, int v, int[] colorArr, int color){
        int n = graph.length;
        
        for(int i = 0; i < n; i++){
            if(graph[v][i] && colorArr[i] == color){
                return false;
            }
        }
        return true;
    }
    
    private boolean tryAllColours(boolean graph[][], int v, int m, int[] colorArr){
        if(v == graph.length){
            return true;
        }
        
        for(int i = 0; i < m; i++){
            if(isValidColor(graph, v, colorArr, i)){
                colorArr[v] = i;
                if(tryAllColours(graph, v + 1, m, colorArr)){
                    return true;
                }
                colorArr[v] = -1;
            }
        }
        return false;
    }
    
    public boolean graphColoring(boolean graph[][], int m, int n) {
        int colorArr[] = new int[n];
        Arrays.fill(colorArr, -1);
    
        return tryAllColours(graph, 0, m, colorArr);
    }
}