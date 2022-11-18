import java.util.Arrays;

class Solution 
{

    static int numOfSubArraysWithMaxSum(int[] arr, int n, int mid){
        int count = 1;
        int sum = 0;
        for (int it : arr) {
            sum += it;
            if(sum >= mid){
                count++;
                sum = 0;
            }
        }
        return count;
    }

    //Function to find minimum number of pages.
    public static int findPages(int[]A,int N,int M)
    {
        Arrays.sort(A);

        int low = A[0];
        int high = 0;
        for (int i = M - 1; i < A.length; i++) {
            high += A[i];
        }

        while(high <= low){
            int mid = (low + high) >> 1;

            if(numOfSubArraysWithMaxSum(A, N, mid) <= M){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return high;
    }
};