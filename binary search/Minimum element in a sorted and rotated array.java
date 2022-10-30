class Solution {
    public int findMin(int[] arr) {
        int n = arr.length;
        int low = 0, high = n - 1;
        if(n == 1) return arr[0];
        if(arr[low] < arr[high]) return arr[low];
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(arr[mid] < arr[mid - 1]) return arr[mid];
            if(arr[mid] > arr[mid + 1]) return arr[mid + 1];
            else if(arr[mid] < arr[low]) high = mid - 1;
            else low = mid + 1;
        }
        return -1;
    }
}



// //minValue method
// class Solution
// {
//     int findMin(int arr[], int n)
//     {
//         int low = 0, high = n - 1;
//         int minValue = Integer.MAX_VALUE;
//         while(low <= high){
//             if(arr[low] < arr[high]){
//                 minValue = Math.min(arr[low], minValue);
//                 break;
//             }

//             int mid = low + (high - low) / 2;
//             if(arr[mid] >= arr[low]){
//                 minValue = Math.min(minValue, arr[low]);
//                 low = mid + 1;
//             }
//             else{
//                 minValue = Math.min(minValue, arr[mid]);
//                 high = mid -1;
//             }
//         }
//         return minValue;
//     }
// }