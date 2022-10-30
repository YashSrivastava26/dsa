class Solution
{
    void merge(int arr[], int l, int m, int r)
    {
        int n1 = m - l + 1;
        int n2 = r - m;

        int left[] = new int[n1];
        int right[] = new int[n2];

        // for (int i = 0; i < arr.length; i++) {
        //     if(i <= m) left[i] = arr[l + i];
        //     else right[i - m - 1] = arr[i];
        // }
        for (int i = 0; i < n1; ++i)
            left[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            right[j] = arr[m + 1 + j];

        int i = 0, j = 0, k = l;
        while(i < n1 && j < n2){
            if(left[i] <= right[i]){
                arr[k] = left[i];
                i++;
            }
            else{
                arr[k] = right[j];
                j++;
            }
            k++;
        }
        while(i < n1){
            arr[k] = left[i];
            i++;
            k++;
        }
        while(j < n2){
            arr[k] = right[j];
            j++;
            k++;
        }
    }
    void mergeSort(int arr[], int l, int r)
    {
        if(l < r){
            int middle = l + (r - l) / 2;
            mergeSort(arr, l, middle);
            mergeSort(arr, middle + 1, r);

            merge(arr, l, middle, r);
        }
    }
}