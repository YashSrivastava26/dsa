
//brute force
// class Solution {
//     public int reversePairs(int[] nums) {
//         int count = 0;
//         for (int i = 0; i < nums.length; i++) {
//             long comp = 2 * nums[i];
//             int j = i - 1;
//             if(comp < Integer.MAX_VALUE && comp > Integer.MIN_VALUE){
//                 while(j >= 0){
//                     if(comp < nums[i]) count++;
//                     j--;
//                 }
//             }
//         }
//         return count;
//     }
// }


//modified merge sort approach
// class Solution {

//     int merge(int[] arr, int low, int mid, int high){
//         int count = 0;
//         int left[] = new int[mid - low + 1];
//         int right[] = new int[high - mid];
//         for (int i = 0; i < left.length; i++) {
//             left[i] = arr[low + i];
//         }
//         for (int i = 0; i < right.length; i++) {
//             right[i] = arr[mid + 1 + i];
//         }

//         int i = 0, j = 0;
//         while(i < left.length){
//             while(j < right.length && left[i] > (2 * (long)right[j])) j++;
//             count += j;
//             i++;
//         }
        
//         i = 0;
//         j = 0;
//         int k = low;
//         while(i < left.length && j < right.length){
//             if(left[i] <= right[j])
//                 arr[k++] = left[i++];
//             else
//                 arr[k++] = right[j++];
//         }
//         while(i < left.length)
//             arr[k++] = left[i++];

//         while(j < right.length)
//             arr[k++] = right[j++];

//         return count;
//     }

//     int mergeSort(int[] arr, int low, int high){
//         int countPairs = 0;
//         if(low < high){
//             int mid = low + (high - low) / 2;
//             countPairs += mergeSort(arr, low, mid);
//             countPairs += mergeSort(arr, mid + 1, high);

//             countPairs += merge(arr, low, mid, high);
//         }
//         return countPairs;
//     }

//     public int reversePairs(int[] nums) {
//         return mergeSort(nums, 0, nums.length - 1);
//     }
// }


class Solution {

    int merge(int[] arr, int low, int mid, int high){
        int count = 0;
        int temp[] =new int[high - low + 1];
        
        int i = low, j = mid + 1;
        while(i <= mid){
            while(j <= high && arr[i] > (2 * (long)arr[j])) j++;
            count += (j - mid + 1);
            i++;
        }

        i = low;
        j = mid + 1;
        int k = 0;
        while(i <= mid && j <= high){
            if(arr[i] <= arr[j])
                temp[k++] = arr[i++];
            else    
                temp[k++] = arr[j++];
        }

        while(i <= mid)
            temp[k++] = arr[i++];

        while(j <= high)
            temp[k++] = arr[j++];
        
        for (i = 0; i < temp.length; i++) {
            arr[low + i] = temp[i];
        }
        return count;
    }

    int mergeSort(int[] arr, int low, int high){
        int countPairs = 0;
        if(low < high){
            int mid = low + (high - low) / 2;
            countPairs += mergeSort(arr, low, mid);
            countPairs += mergeSort(arr, mid + 1, high);

            countPairs += merge(arr, low, mid, high);
        }
        return countPairs;
    }

    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }
}