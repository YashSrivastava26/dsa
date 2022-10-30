public class InsertionSort {

    // public static void sort_Insertion(int[] arr){
    //     int n = arr.length;
    //     for(int i = 1; i < n; i++){
    //         int key = arr[i];
    //         int j = i - 1;
    //         while(j>=0 && arr[j] > key){
    //             arr[j + 1] = arr[j];
    //             j--;
    //         }
    //         arr[j + 1] = key; 
    //     }
    // }

    //recursive insertion sort
    public static void sort_Insertion(int[] arr, int idx){
        if(idx >= arr.length) return;
        int key = arr[idx];
        int i = idx - 1;
        while(i >=0 && arr[i] > key){
            arr[i + 1] = arr[i];
            i--;
        }
        arr[i + 1] = key;
        sort_Insertion(arr, idx + 1);
    }
    public static void main(String[] args) {
        int arr[] = {5,3,5,4,25,6666,734,62446,414,23,46};
        sort_Insertion(arr, 0);
        for (int x : arr) {
            System.out.print(x + " ");
        }
        System.out.println();
    }
}
