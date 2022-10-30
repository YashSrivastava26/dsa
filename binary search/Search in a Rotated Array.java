// class Solution
// {

//     boolean isSorted(int[] arr, int start, int end){
//         for (int i = start + 1; i <= end; i++) {
//             if(!(arr[i] >= arr[i - 1])) return false;
//         }
//         return true;
//     }

//     int search(int arr[], int low, int high, int key)
//     {
//         // l: The starting index
//         // h: The ending index, you have to search the key in this range
//         // Complete this function
//         if(low <= high){            
//             int mid = low + (high - low) / 2;
//             if(arr[mid] == key) return mid;
//             else if(isSorted(arr, low, mid)){
//                 if(key >= arr[low] && key < arr[mid]) return search(arr, low, mid - 1, key);
//                 else return search(arr, mid + 1, high, key);
//             }
//             else{
//                 if(key > arr[mid] && key <= arr[high]) return search(arr, mid + 1, high, key);
//                 else return search(arr, low, mid - 1, key);
//             }
//         }
//         return -1;
//     }
// }

class Solution
{
    int search(int arr[], int low, int high, int key)
    {
        // l: The starting index
        // h: The ending index, you have to search the key in this range
        // Complete this function
        if(low <= high){            
            int mid = low + (high - low) / 2;
            if(arr[mid] == key) return mid;
            else if(arr[low] <= arr[mid]){
                if(key >= arr[low] && key < arr[mid]) return search(arr, low, mid - 1, key);
                else return search(arr, mid + 1, high, key);
            }
            else{
                if(key > arr[mid] && key <= arr[high]) return search(arr, mid + 1, high, key);
                else return search(arr, low, mid - 1, key);
            }
        }
        return -1;
    }
}