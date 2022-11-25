import java.util.Arrays;

class Solution 
{

    static int numOfSubArraysWithMaxSum(int[] arr, int n, int mid){
        int count = 1;
        int subArraySum = 0;
        for (int i = 0; i < arr.length; i++) {
            subArraySum += arr[i];
            if(subArraySum > mid){
                subArraySum = arr[i];
                count++;
            }
        }
        return count;
    }

    //Function to find minimum number of pages.
    public static int findPages(int[]a,int N,int M)
    {
        int low = 0, high = 0;
        for (int i = 0; i < a.length; i++) {
            low = Math.max(low, a[i]);
            high += a[i]; 
        }

        int result = 0;
        while(low <= high){
            int mid = (low + high) >> 1;

            int count = numOfSubArraysWithMaxSum(a, N, mid);
            if(count > M){
                low = mid + 1;
            }
            else {
                high = mid - 1;
                result = mid;
            }
        }
        return result;
    }
};