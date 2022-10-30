class Solution {
    int rowWithMax1s(int arr[][], int n, int m) {
        int traversePtrM = m, traversePtrN = 0,rowWithMax1 = -1;
        while(traversePtrN < n){
            while(traversePtrM > 0 && arr[traversePtrN][traversePtrM - 1] == 1){
                traversePtrM--;
                rowWithMax1 = traversePtrN;
            }
            traversePtrN++;
        }
        return rowWithMax1;
    }
}