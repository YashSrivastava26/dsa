class Solution
{
    public int NthRoot(int n, int m)
    {
        int low = 0, high = m;
        while(low <= high){
            int mid = low + (high - low) / 2;
            int chk =(int)Math.pow(mid, n);
            if(chk == m) return mid;
            else if(chk < m) low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }
}