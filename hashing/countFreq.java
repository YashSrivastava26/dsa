import java.util.Arrays;

class Solution{
    //Function to count the frequency of all elements from 1 to N in the array.
    public static void frequencyCount(int arr[], int N, int P)
    {
        int hash[] = new int[P];
        Arrays.fill(hash, 0);
        for (int i = 0; i < arr.length; i++) {
            hash[arr[i] - 1] ++;
        }
        for (int i = 0; i < N; i++) {
            if(i >= hash.length) arr[i] = 0;
            else arr[i] = hash[i];
        }
    }
}
