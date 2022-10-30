import java.util.HashMap;

class GfG
{
    int maxLen(int arr[], int n)
    {
        HashMap<Integer, Integer> runningSum = new HashMap<>();
        int sum = 0, maxi = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            if(runningSum.containsKey(sum)) maxi = Math.max(i - runningSum.get(sum), maxi);
            else{
                runningSum.put(sum, i);
            }
        }
        return maxi;
    }
}
