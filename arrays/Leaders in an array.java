import java.util.ArrayList;
import java.util.Collections;

class Solution{

    static ArrayList<Integer> leaders(int arr[], int n){
        int  maxi = Integer.MIN_VALUE;
        ArrayList<Integer> leaderList = new ArrayList<>();
        for (int ptr = arr.length - 1; ptr >= 0; ptr--) {
            if(arr[ptr] >= maxi){
                leaderList.add(arr[ptr]);
                maxi = arr[ptr];
            }
        }
        Collections.reverse(leaderList);
        return leaderList;
    }
}
