import java.util.ArrayList;
import java.util.Arrays;
import java.util.Currency;
import java.util.List;

class Solution
{
    public int[][] overlappedInterval(int[][] intervals)
    {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int mergeStart = intervals[0][0], mergeEnd = intervals[0][1];
        ArrayList<int[]> result = new ArrayList<>();
        for (int i = 1; i < intervals.length; i++) {
            if(intervals[i][0] > mergeEnd){
                result.add(new int[]{mergeStart, mergeEnd});
                mergeStart = intervals[i][0];
                mergeEnd = intervals[i][1];
            }
            else{
                mergeEnd = Math.max(mergeEnd, intervals[i][1]);
                mergeStart = Math.min(mergeStart, intervals[i][0]);
            }
        }
        result.add(new int[]{mergeStart, mergeEnd});
        return result.toArray(new int[result.size()][]);
    }
}
