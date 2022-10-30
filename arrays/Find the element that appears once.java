
//TC = O(n)
// class Sol
// {
//     public static int search(int A[], int N)
//     {
//         int xor = 0;
//         for (int i = 0; i < A.length; i++) {
//             xor ^= A[i];
//         }
//         return xor;
//     }
// }



// only for sorted array
//TC = O(lon n)
//using binary search

class Sol
{
    public static int binarySearch(int[] arr, int low, int high){
        if(low == high) return arr[low];

        int mid = low + (high - low) / 2;

        //if mid is even and next element is equal to mid element that a element that appear once is at right
        if(mid % 2 == 0){
            if(arr[mid + 1] == arr[mid]) return binarySearch(arr, mid + 2, high);
            else return binarySearch(arr, low, mid);
        }

        //if mid is odd and next element is equal to mid element than ,element that appear once is at left
        else{
            if(arr[mid] == arr[mid + 1]) return binarySearch(arr, low, mid - 1);
            else return binarySearch(arr, mid + 1, high);
        }
    }

    public static int search(int A[], int N)
    {
        return binarySearch(A, 0, N - 1);
    }
}
