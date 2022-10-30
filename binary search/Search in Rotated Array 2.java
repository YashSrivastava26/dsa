class Solution {
    public static boolean Search(int N, int[] arr, int Key) {
        int start = 0, end = N - 1;
        while(start <= end){
            int mid = start + (end - start) / 2;
            
            if(arr[mid] == Key) return true; 
            if(arr[mid] == arr[start] && arr[mid] == arr[end]){
                start ++;
                end--;
            }

            else if(arr[start] <=arr[mid]){
                if(Key <= arr[mid] && Key >= arr[start]) 
                    end = mid - 1;
                else start = mid + 1;
            }
            else{
                if(Key > arr[mid] && Key <= arr[end]) 
                    start = mid + 1;
                else end = mid - 1;
            }
        }
        return false;
    }
}
