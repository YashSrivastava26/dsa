import java.util.ArrayList;

class Solution {
    void rearrange(int arr[], int n) {
        ArrayList<Integer> positiveEle = new ArrayList<>();
        ArrayList<Integer> negativeEle = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] >= 0) positiveEle.add(arr[i]);
            else negativeEle.add(arr[i]);
        }
        for (int i = 0; i < arr.length; i++) {
            if(i % 2 == 0 ){
                if(!positiveEle.isEmpty()){
                    arr[i] = positiveEle.get(0);
                    positiveEle.remove(0);
                }
                else{
                    arr[i] = negativeEle.get(0);
                    negativeEle.remove(0);
                }
            }
            else{
                if(!negativeEle.isEmpty()){
                    arr[i] = negativeEle.get(0);
                    negativeEle.remove(0);
                }
                else{
                    arr[i] = positiveEle.get(0);
                    positiveEle.remove(0);
                }
            } 
        }
    }
}

/**
 * Alternatepositiveandnegativenumbers
 */
public class Alternatepositiveandnegativenumbers {

    public static void main(String[] args) {
        Solution s =new Solution();
        int arr[] = {-5 ,-2 ,5 ,2 ,4 ,7, 1, 8 ,0, -8};
        s.rearrange(arr, 10);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}