import java.util.*;

class Solution{

    public static void reverse(int[] arr, int start, int end){
        while(start < end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    static List<Integer> nextPermutation(int N, int arr[]){
        ArrayList<Integer> result = new ArrayList<>();
        int i = N - 2;
        while (i >= 0) {
            if(arr[i] < arr[i + 1])
                break;
            i--;
        }
        if(i == -1){
            for (int ele : arr) {
                result.add(ele);
            }
            Collections.sort(result);
        }
        else {
            int nextMaxIdx = N - 1;
            while(nextMaxIdx > i){
                if(arr[nextMaxIdx] > arr[i])
                    break;
                nextMaxIdx--;
            }
            int temp = arr[nextMaxIdx];
            arr[nextMaxIdx] = arr[i];
            arr[i] = temp;

            reverse(arr, i + 1, N - 1);
            for (int ele : arr) {
                result.add(ele);
            }
        }
        return result;
    }
}
