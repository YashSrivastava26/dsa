// class Solution {

//     public static void sort_Insertion(int[] arr, int Idx){
//         int n = arr.length;
//         for(int i = Idx; i < n; i++){
//             int key = arr[i];
//             int j = i - 1;
//             while(j>=0 && arr[j] > key){
//                 arr[j + 1] = arr[j];
//                 j--;
//             }
//             arr[j + 1] = key; 
//         }
//     }

//     public void merge(int[] nums1, int m, int[] nums2, int n) {
//         for (int i = 0; i < nums2.length; i++) {
//             nums1[m + i] = nums2[i];
//         }
        
//         sort_Insertion(nums1, m);
//     }
// }


class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i < nums2.length; i++) {
            int key = nums2[i];
            int j = m + i - 1;
            while(j >= 0 && nums1[j] > key){
                nums1[j + 1] = nums1[j];
                j--;
            }
            nums1[j + 1] = key;
        }
    }
}