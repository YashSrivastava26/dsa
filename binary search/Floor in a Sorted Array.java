class Solution{
    
    // Function to find floor of x
    // arr: input array
    // n is the size of array
    static int findFloor(long arr[], int n, long x)
    {
        int low = 0, high = n - 1, floorIdx = -1;
        long floor = 0;
        if(x < arr[0]) return -1;
        if(x > arr[n - 1]) return n - 1;
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(arr[mid] == x) return mid;
            else if(arr[mid] > x){ 
                high = mid - 1;
                if(high >= 0 && arr[high] <= x){
                    floor = Math.max(floor, arr[high]);
                    floorIdx = high;
                }
            }
            else
                low = mid + 1;
        }
        return floorIdx;
    }
    
}