class Solution
{

    static long merge(long[] arr, int low, int mid, int high){
        long count = 0;
        long temp[] = new long[high - low + 1];
        int i = low, j = mid + 1, k = 0;
        while(i <= mid && j <= high) {
            if(arr[i] <= arr[j]){
                temp[k] = arr[i];
                i++;
            }
            else{
                temp[k] = arr[j];
                j++; 
                count += mid - i + 1;
            }
            k++;
        }

        while(i <= mid){
            temp[k] = arr[i];
            i++;
            k++; 
        }
        while(j <= high){
            temp[k] = arr[j];
            j++;
            k++; 
        }

        for (i = 0; i < temp.length; i++) {
            arr[low + i] = temp[i];
        }

        return count;
    }

    static long mregeSort(long[] arr, int low, int high){
        long count = 0;
        if(low < high){
            int mid = low + (high - low ) / 2;
            count += mregeSort(arr, low, mid);
            count += mregeSort(arr, mid + 1, high);

            count += merge(arr, low, mid, high);
        }
        return count;
    }

    // arr[]: Input Array
    // N : Size of the Array arr[]
    //Function to count inversions in the array.
    static long inversionCount(long arr[], long N)
    {
        long count = mregeSort(arr, 0, arr.length - 1);
        return count;
    }
}



