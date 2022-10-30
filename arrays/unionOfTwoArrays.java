
import java.util.ArrayList;

class Solution
{
    //Function to return a list containing the union of the two arrays.
    public static ArrayList<Integer> findUnion(int arr1[], int arr2[], int n, int m)
    {
        ArrayList<Integer> result = new ArrayList<>();
        int i = 0, j = 0, k = 0;
        while(i < n && j < m){
            if(arr1[i] < arr2[j]){
                if(result.isEmpty() || result.get(k - 1) != arr1[i]){ 
                    result.add(arr1[i]);
                    k++;
                }
                i++;
            }
            else{
                if(result.isEmpty() || result.get(k - 1) != arr2[j]){
                    result.add(arr2[j]);
                    k++;
                }
                j++;
            }
        }
        while(i < n){
            if(result.get(k - 1) != arr1[i]){
                result.add(arr1[i]);
                    k++;
            }
            i++;
        }
        while(j < m){
            if(result.get(k - 1) != arr2[j]){
                result.add(arr2[j]);
                    k++;
            }
            j++;
        }
        return result;
    }
}
