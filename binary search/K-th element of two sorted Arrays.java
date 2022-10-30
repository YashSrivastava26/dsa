// brute force
// class Solution {
//     public long kthElement( int arr1[], int arr2[], int n, int m, int k) {
//         int i = 0, j = 0, idx = 0;
//         while(i < n && j < m){
//             System.out.println(arr1[i] + " " + arr2[i] + " " + idx);
//             if(arr1[i] <= arr2[j]){
//                 idx++;
//                 if(idx == k) return (long) arr1[i];
//                 i++;
//             }
//             else{
//                 idx++;
//                 if(idx == k) return (long) arr2[j];
//                 j++;
//             }
//         }        

//         while(i < n){
//             System.out.println(arr1[i] + " " + arr2[i] + " " + idx);
//             idx++;
//             if(idx == k) return (long) arr1[i];
//             i++;
//         }
//         while(j < n){
//             System.out.println(arr1[i] + " " + arr2[i] + " " + idx);
//             idx++;
//             if(idx == k) return (long) arr2[j];
//             j++;
//         }
//         return -1;
//     }
// }


//binary search

class Solution {
    public long kthElement(int arr1[], int arr2[], int n, int m, int k) {
        if(m < n){
            return kthElement(arr2, arr1, m, n, k);
        }

        int low = Math.max(k - m, 0), high = Math.min(n, k);
        while(low <= high){
            int cut1 = low + (high - low) / 2;
            int cut2 = k - cut1;

            int l1 = cut1 == 0 ? Integer.MIN_VALUE : arr1[cut1 - 1]; 
            int l2 = cut2 == 0 ? Integer.MIN_VALUE : arr2[cut2 - 1]; 
            int r1 = cut1 == n ? Integer.MAX_VALUE : arr1[cut1]; 
            int r2 = cut2 == m ? Integer.MAX_VALUE : arr2[cut2]; 

            if(l1 <= r2 && l2 <= r1){
                return Math.max(l1, l2);
            }
            else if(l1 > r2) high = cut1 - 1;
            else low = cut1 + 1;
        }
        return -1;
    }
}