// class Solution {
//     public int findKthPositive(int[] arr, int k) {
//         int n = arr.length;
//         int chk = 1;
//         int i = 0;
//         while(k != 0){
//             if(i < n && arr[i] == chk){
//                 chk++;
//                 i++;
//             }
//             else{
//                 chk++;
//                 k--;
//             }
//         }
//         return chk - 1;
//     }
// }


//Binary Search
class Solution {

    int countMissingTillIdx(int[] arr, int idx){
        return arr[idx] - idx - 1;
    }

    public int findKthPositive(int[] arr, int k) {
        int n = arr.length;
        int high = n, low = 0;

        while(low <= high){
            int mid = low + ((high - low) >> 1);// right shift operation is less value than +/-
            //int mid = low + (high - low) / 2;

            int count = countMissingTillIdx(arr, mid);

            if(count < k) low = mid + 1;
            else high = mid - 1;
        }

        if(high == -1) return k;
        return (arr[high] + k - (countMissingTillIdx(arr, high)));
    }
}