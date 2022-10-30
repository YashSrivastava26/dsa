public class QuickSort {

    private static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp; 
    }

    //first element as pivot
    private static int partation(int[] arr, int start, int end){
        int pivot=arr[start],p1=start+1,i;
        for(i=start+1;i<=end;i++){
            if(arr[i]<pivot){
                if(i != p1) swap(arr, i, p1);
                p1++;
            }
        }
        swap(arr, start,  p1 - 1);
        return p1-1;
    }

    


    // //last element as pivot
    // private static int partation(int[] arr, int start, int end){
    //     int pivot = arr[end];
    //     int i = start - 1;
    //     for (int j = start; j < end ; j++) {
    //         if(arr[j] < pivot){
    //             i++;
    //             swap(arr, i, j);
    //         }
    //     }
    //     swap(arr,i + 1, end);
    //     return (i + 1);
    // }

    public static void sort_Quick(int[] arr, int start, int end){
        if(start < end){
            int pivot = partation(arr, start, end);
            sort_Quick(arr, start, pivot - 1);
            sort_Quick(arr, pivot + 1, end);
        }

    }

    public static void main(String[] args) {
        //int arr[] = {4, 2, 8, 3, 1, 5, 7,11,6};
        int arr[] = {1,24,2,3432,5,2532,5,23,5,43,5,46,2,43342,4,24,32,4,24,142424,23,432,4,23,43,2343,42,4254543,543,543,4534,54,345,34543,543};
        sort_Quick(arr, 0, arr.length  - 1);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}

