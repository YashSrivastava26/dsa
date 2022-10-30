// class Solution {
//     void pushZerosToEnd(int[] arr, int n) {
//         int j = -1,count = 0;
//         for (int i = 0; i < arr.length; i++) {
//             if(arr[i] != 0){
//                 j++;
//                 arr[j] = arr[i]; 
//             }
//             else if(arr[i] == 0) count++;
//         }
//         for (int i = arr.length - 1; count > 0;count--, i--) {
//             arr[i] = 0;
//         }
//     }
// }


class Solution {
    public void moveZeroes(int[] arr) {
        int sizeOfZeroWindow = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == 0) sizeOfZeroWindow++;
            else if(sizeOfZeroWindow > 0){
                arr[i - sizeOfZeroWindow] = arr[i];
                arr[i] = 0;
            }
        }
    }
}
/**
 * PushZeroToEnd
 */
public class PushZeroToEnd {

    public static void main(String[] args) {
        int arr[] = {1,2,3,0,5,2,0,0,8,9,7,0,0,0,5};
        Solution s = new Solution();
        s.moveZeroes(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
