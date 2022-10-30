import java.util.Arrays;

class Solution
{
    static int closest3Sum(int A[], int N, int X)
    {
        Arrays.sort(A);
        int sum = 0, diff = Integer.MAX_VALUE;
        for (int i = 0; i < A.length; i++) {
            int left = i + 1, right = A.length - 1;
            while(left < right){
                if(A[i] + A[left] + A[right] == X)
                    return X;
                else if(A[i] + A[left] + A[right] < X) left++;
                else right--;
                if(Math.abs(X - (A[i] + A[left] + A[right])) < diff){
                    sum = A[i] + A[left] + A[right];
                    diff = Math.abs(X - sum);
                }
            }
        }
        return sum;
    }
}
