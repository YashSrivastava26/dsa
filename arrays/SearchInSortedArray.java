import java.util.Scanner;

class Solution{

    static int binarySearch(int[] arr, int key, int start, int end){
        if(start < end){
            int mid = start + (end - start) / 2;
            if(arr[mid] == key) return 1;
            else if(arr[mid] > key) return binarySearch(arr, key, start, mid - 1);
            else return binarySearch(arr, key, mid + 1, end);
        }
        return -1;
    }


    static int searchInSorted(int arr[], int N, int K)
    {
        return binarySearch(arr, K, 0, N - 1);        
    }
}

// class Solution{
//     static int searchInSorted(int arr[], int N, int K)
//     {
//         int start = 0, end = N;
//         int mid = 0;
//         while(start < end){
//             mid = start + (end - start) / 2;
//             if(K == arr[mid]) return 1;
//             else if(K > arr[mid]){
//                 start = mid + 1;
//             }
//             else{
//                 end = mid - 1;
//             }
//         }
//         return -1;
//     }
// }

/**
 * SearchInSortedArray
 */
public class SearchInSortedArray {

    public static void main(String[] args) {
        int arr[] = new int[864557];
        Scanner s = new Scanner(System.in);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = s.nextInt();
        }
        System.out.println(Solution.searchInSorted(arr, arr.length, 878726));
    }
}
