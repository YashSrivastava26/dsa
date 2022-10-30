public class BubbleSort {
    // iterative
    // public static void sort_Bubble(int[] arr){
    //     for (int i = 0; i < arr.length; i++) {
    //         for (int j = i + 1; j < arr.length; j++) {
    //             if(arr[i] > arr[j]) {
    //                 arr[i] = arr[i] + arr[j];
    //                 arr[j] = arr[i] - arr[j];
    //                 arr[i] = arr[i] - arr[j];
    //             }
    //         }
    //     }
    // }

    //recursive
    public static void sort_Bubble(int[] arr, int idx){
        if(idx >= arr.length) return;
        for (int i = idx + 1; i < arr.length; i++) {
            if(arr[i] < arr[idx]){
                arr[i] = arr[i] + arr[idx];
                arr[idx] = arr[i] - arr[idx];
                arr[i] = arr[i] - arr[idx];
            }
        }
        sort_Bubble(arr, idx + 1);
    }

    public static void main(String[] args) {
        int arr[] = {5,3,5,4,25,6666,734,62446,414,23,46};
        sort_Bubble(arr, 0);
        for (int x : arr) {
            System.out.print(x + " ");
        }
        System.out.println();
    }
}
