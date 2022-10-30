class Solution
{
    //Function to return list containing first n fibonacci numbers.
    public static long[] printFibb(int n) 
    {
        long secondprev = 0;
        long result[] = new long[n];
        result[0] = 1;
        for (int i = 1; i < result.length; i++) {
            result[i] = result[i - 1] + secondprev;
            secondprev = result[i - 1];
        } 
        return result;
    }
}
