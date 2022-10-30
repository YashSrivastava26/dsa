
import java.util.Arrays;
import java.util.HashSet;
// count elements in intersection
// class Solution {
//     public static int NumberofElementsInIntersection(int a[], int b[], int n, int m) {
//         Arrays.sort(a);
//         Arrays.sort(b);
//         int count = 0, i = 0,j = 0;//i iterate through a[] and j through b[]
//         while(i < n && j < m){
//             if(a[i] == b[j]) {
//                 if((i == 0 || j == 0) || a[i] != a[i - 1]) count++;
//                 i++;
//                 j++;
//             }
//             else if(a[i] > b[i]) j++;
//             else i++;
//         }
//         System.out.println(count);
//         System.out.println(a[i]);
//         System.out.println(b[j]);
//         return count;
//     }
// }

//return intersection
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0, j = 0;
        HashSet<Integer> set = new HashSet<>();
        while(i < nums1.length && j < nums2.length){
            if(nums1[i] == nums2[j]){
                set.add(nums1[i]);
                i++; 
                j++;
            }
            else if(nums1[i] < nums2[j]) i++;
            else j++;
        }
        return set.stream().mapToInt(Integer::intValue).toArray();
    }
}