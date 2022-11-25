class Complete{

    int missingTillIdx(int arr[], int idx){
        return arr[idx] - (arr[0] + idx);
    }
    
  
    int KthMissingElement(int a[], int n, int k)
    {
        if(missingTillIdx(a, n - 1) == 0) return -1;
        int low = 0, high = n - 1;
        while(low <= high){
            int mid = low + (high - low) / 2;

            int count = missingTillIdx(a, mid);
            if(count < k) low = mid + 1;
            else high = mid - 1;
        }
        if(low == n) return -1;
        return a[high] + k - (missingTillIdx(a, high));
    }
  
    
}