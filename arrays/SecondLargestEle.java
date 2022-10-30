class Solution {
    int print2largest(int arr[], int n) {
        int maxi = arr[0], secondMax = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if(arr[i] > maxi && arr[i] > secondMax){
                secondMax = maxi;
                maxi = arr[i];
            }
            else if(arr[i] > secondMax && arr[i] < maxi){
                secondMax = arr[i];
            }
        }
        return secondMax;
    }
}
