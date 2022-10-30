public class HeapSort {
    
    private static void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
    
    private static void heapify(int[] arr, int end, int start){
        int minIdx = start;
        int left = 2 * start + 1;
        int right = 2 * start + 2;

        if(left < end && arr[left] < arr[minIdx]) minIdx = left;
        if(right < end && arr[right] < arr[minIdx]) minIdx = right;

        if(minIdx != start){ 
            swap(arr, minIdx, start);
            
            heapify(arr, end, minIdx);
        }
    }

    public static void heapSort(int[] arr){
        int n = arr.length;

        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        for(int i = n - 1; i > 0 ; i--){
            swap(arr, 0, i);
            heapify(arr, i, 0);
        }
    }

    public static void main(String[] args) {
        int arr[] = {23,4,4,7,24,5,2,35,23,52,5,3};
        
        heapSort(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
