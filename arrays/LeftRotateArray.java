// gfg
class Solution
{
    private  void reverse(long[] arr, int start, int end){
        while(start < end){
            long temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
    
    void leftRotate(long arr[], int n, int d)
    {
        d = d % n;
        if(d == 0) return;
        reverse(arr, 0, d - 1);
        reverse(arr, d, n - 1);
        reverse(arr, 0, n - 1);
        
    }
}



