// class Solve {

//    int consective1s(int[] arr){
//        int i = -1, j = -1, maxi = 0;
//        while(j < arr.length){
//            if(i == -1){
//                i = 0; 
//                j = 0;
//            }
//            if(arr[j] == 0){
//                maxi = Math.max(maxi, j - i + 1);
//                i = j;
//            }
//            j++;
//        }
//        return maxi;
//    }

//     // m is maximum of number zeroes allowed to flip
//     int findZeroes(int arr[], int n, int m) {
//         if(m == 0) return consective1s(arr);
//         int maxWindowSize = 0, i = -1, j = -1, noOfZeros = 0;
//         while(j < n){
//             if(j == -1){
//                 if(arr[0] == 0) noOfZeros++;
//                 i++;
//             }
//             else if(noOfZeros == m){
//                 if(j == n - 1 || arr[j + 1] == 0) {
//                     maxWindowSize = Math.max(maxWindowSize, j - i + 1);
//                     while(arr[i] != 0) i++;
//                     i++;
//                 }
//             }
//             else if(noOfZeros < m && j < n - 1){
//                 if(arr[j + 1] == 0) noOfZeros++;
//             }
//             j++;
//         }
//         return maxWindowSize= Math.max(maxWindowSize, j - i);
//     }
// }



//simple code


public class MaximizeNumberof1s {

    public static int findZeroes(int[] arr, int n, int m){
        int left = 0, right = 0, bestWindow = 0, noOfZeros = 0;
        while(right < n){
            if(noOfZeros <= m){
                if(arr[right] == 0) noOfZeros++;
                right++;
            }
            else if(noOfZeros > m){
                if(arr[left] == 0) noOfZeros--;
                left++;
            }
            if((right - left) > bestWindow && noOfZeros <= m)
                bestWindow = right - left;
        }
        return bestWindow;
    }

    public static void main(String[] args) {
        int arr[] = {1, 1, 0, 1, 0, 0, 1, 0, 0, 1, 1};
        int m = 2;
        System.out.println(findZeroes(arr, arr.length, m));
    }
}
