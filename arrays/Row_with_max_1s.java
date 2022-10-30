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

/**
 * Row_with_max_1s
 */
public class Row_with_max_1s {

    public static void main(String[] args) {
        int arr[][] = {{0,1,1,1}, {0,0,1,1},{1,1,1,1},{0,0,0,0}};
        Solution s = new Solution();
        System.out.println(s.rowWithMax1s(arr, 4, 4));
    }
}

