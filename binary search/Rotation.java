class Solution {

    public int findPivot(int[] arr, int n){        
        int low = 0, high = n - 1;
        if(arr[0] < arr[n - 1]) return arr[0];
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(arr[mid] < arr[mid - 1]) return mid;
            if(arr[mid] > arr[mid + 1]) return mid + 1;

            if(arr[mid] >= arr[low])
                low = mid + 1;
            else 
                high = mid - 1;
        }
        return -1;
    }

    int findKRotation(int arr[], int n) {
        int pivotIdx = findPivot(arr, n);
        return Math.max(n - pivotIdx, pivotIdx);
    }
}
