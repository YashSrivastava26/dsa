class Solution
{
    static int searchInsertK(int Arr[], int N, int k)
    {
        int low = 0, high = N - 1;
        int mid = 0;
        if(Arr[N - 1] < k) return N;
        while(low <= high){
            mid = low + (high - low) / 2;
            if(Arr[mid] == k) return mid;
            else if(mid > 0 && Arr[mid - 1] < k && Arr[mid] > k)return mid;
            else if(Arr[mid + 1] > k && Arr[mid] < k) return mid + 1; 
            else if(Arr[mid] > k) high = mid - 1;
            else low = mid + 1;
        }
        return mid;
    }
}
