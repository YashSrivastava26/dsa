class Solution {
    int count(int[] arr, int n, int x) {
        int low = 0, high = n - 1;
        int startPos = -1, endPos = -1;
        if(arr[0] == x) startPos = 0;
        else{
            while(low <= high){
                int mid = low + (high - low) / 2;
                if(mid > 0 && arr[mid] == x && arr[mid - 1] != x){
                    startPos = mid;
                    break;
                }
                else if(arr[mid] < x) low = mid + 1;
                else high = mid - 1;
            }
        }
        if(arr[n - 1] == x) endPos = n - 1;
        else{
            low = 0;
            high = n - 1;
            while(low <= high){
                int mid = low + (high - low) / 2;
                if(mid < n - 1 && arr[mid] == x && arr[mid + 1] != x){
                    endPos = mid;
                    break;
                }
                else if(arr[mid] > x) high = mid - 1;
                else low = mid + 1;
            }
        }
        if(startPos == -1 && endPos == -1) return -1;
        return endPos - startPos + 1;
    }
}