import java.util.Arrays;
//tc = O(n * m log(m))
// class Solution
// {
//     //Function to merge the arrays.
//     public static void merge(long arr1[], long arr2[], int n, int m) 
//     {
//         for (int i = 0; i < arr1.length; i++) {
//             if(arr1[i] > arr2[0]){
//                 long temp = arr1[i];
//                 arr1[i] = arr2[0];
//                 arr2[0] = temp;
//                 Arrays.sort(arr2);
//             }
//         }
//     }
// }

//gap method

class Solution
{
    //Function to merge the arrays.
    public static void merge(long arr1[], long arr2[], int n, int m) 
    {
        double size = n + m;
        double gap =(int) Math.ceil(size / 2.0);
        while(gap > 0){
            int left = 0, right = (int) gap;
            while(right < size){
                if(right < n && arr1[left] > arr1[right]){
                    long temp = arr1[left];
                    arr1[left] = arr1[right];
                    arr1[right] = temp;
                    
                }
                else if(left < n && right >= n && arr1[left] > arr2[right - n]){
                    long temp = arr1[left];
                    arr1[left] = arr2[right - n];
                    arr2[right - n] = temp;
                }
                else if(left >= n && right >= n && arr2[left - n] > arr2[right - n]){
                    long temp = arr2[left - n];
                    arr2[left - n] = arr2[right - n];
                    arr2[right - n] = temp;
                }
                left++;
                right++;
                
            }
            if(gap == 1) gap = 0;
            gap = Math.ceil(gap / 2.0);
        }
    }
}