import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
class Pair{
    int number, steps;
    Pair(int number, int steps){
        this.steps = steps;
        this.number = number;
    }
}
class Solution {
    int minimumMultiplications(int[] arr, int start, int end) {

        int steps[] = new int[(int)1e5];
        Arrays.fill(steps, Integer.MAX_VALUE);

        Queue < Pair > q = new LinkedList<>();
        q.add(new Pair(start, 0));
        steps[start] = 0;

        while(!q.isEmpty()){
            int num = q.peek().number;
            int step = q.peek().steps;
            q.remove();

            if(num == end) return step;
            for (int i = 0; i < arr.length; i++) {
                int newNum = (num * arr[i]) % (int)1e5;
                if(steps[newNum] > step + 1){
                    steps[newNum] = step + 1;
                    q.add(new Pair(newNum, step + 1));
                }
            }
        }
        return -1;
    }
}