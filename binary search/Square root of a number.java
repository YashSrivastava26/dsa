class Solution
{
    long floorSqrt(long x)
    {
	    long low = 0, high = x;
        while(low <= high){
            long mid = low + (high - low) / 2;
            
            if(mid * mid == x || (mid * mid < x && (mid + 1) * (mid + 1) > x)) return mid;
            else if(mid * mid > x && (mid - 1) * (mid - 1) < x) return mid - 1;
            else if(mid * mid < x) low = mid + 1;
            else high = mid -1;
        }
        return -1;
	}
}