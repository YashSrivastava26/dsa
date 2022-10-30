class Solution 
{
    int findOnce(int arr[], int n)
    {
        if(n == 1) return arr[0];
        int low = 0, high = n - 1;
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(arr[mid] != arr[mid - 1] && arr[mid] != arr[mid + 1]) return arr[mid];

            else if(arr[mid] == arr[mid + 1]){
                if((mid - low) % 2 == 1) high = mid - 1;
                else low = mid + 2;
            }
            else {
                if((mid - low) % 2 == 1) low = mid + 1;
                else high = mid - 2;
            }
        }
        return 0;
    }
}