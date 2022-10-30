class Solution
{
    public static void sort012(int a[], int n)
    {
        int noOfZero = 0, noOfOne = 0, noOfTwo = 0;
        for (int i = 0; i < a.length; i++) {
            if(a[i] == 0) noOfZero++;
            else if(a[i] == 1) noOfOne++;
            else noOfTwo++;
        }
        for (int i = 0; i < a.length; i++) {
            if(i < noOfZero) a[i] = 0;
            else if(i < noOfZero + noOfOne) a[i] = 1;
            else a[i] = 2;
        }
    }
}
