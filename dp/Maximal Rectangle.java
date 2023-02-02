import java.util.*;
class Solution {

    public int largestRecInHistogram(int[] heights) {
        int n = heights.length;
        Deque<Integer> linearlyIncreasing = new LinkedList<>();
        int prevMin[] = new int[n];
        int nextMin[] = new int[n];
        

        for(int i = 0; i < n; i++){
            int curr = heights[i];
            if(linearlyIncreasing.size() != 0)
            while(linearlyIncreasing.size() != 0 && curr <= heights[linearlyIncreasing.peekLast()]){
            // System.out.println(curr + " sfsf " + heights[linearlyIncreasing.peekLast()]);
                linearlyIncreasing.removeLast();
            }
            if(linearlyIncreasing.size() == 0){
                prevMin[i] = 0;
            }
            else{
                prevMin[i] = linearlyIncreasing.peekLast() + 1;
            }
            linearlyIncreasing.add(i);
            // System.out.println(prevMin[i] + " " + linearlyIncreasing);
        }

        linearlyIncreasing.clear();
        int area = 0;
        for(int i = n - 1; i >= 0; i--){
            int curr = heights[i];
            while(linearlyIncreasing.size() != 0 && curr <= heights[linearlyIncreasing.peekLast()]){
                linearlyIncreasing.removeLast();
            }
            if(linearlyIncreasing.size() == 0){
                nextMin[i] = n - 1;
            }
            else{
                nextMin[i] = linearlyIncreasing.peekLast() - 1;
            }
            linearlyIncreasing.add(i);
            // System.out.println(nextMin[i] + " " + linearlyIncreasing);

            int currArea = (nextMin[i] - prevMin[i] + 1) * heights[i];
            // System.out.println(i + " " + area + " " + currArea + " " + nextMin[i] + " " + prevMin[i]);
            area = Math.max(currArea, area);
        }

        return area;
    }

    public int maximalRectangle(char[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        int[] rowRec = new int[m];

        int area = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                // System.out.print(rowRec[j] + " " + matrix[i][j] + " ------???--- ");
                if(matrix[i][j] == '0'){
                    rowRec[j] = 0;
                }
                else{
                    rowRec[j] ++;      
                }
                // System.out.print(rowRec[j] + " " );
            }
            // System.out.println();
            area = Math.max(largestRecInHistogram(rowRec), area);
        }
        return area;
    }
}