import java.util.*;

class Solution{
    static List<Integer> minPartition(int N)
    {
        int currency[] = {2000, 500, 200, 100, 50, 20, 10, 5, 2, 1};
        int currN = N;
        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i < 10; i++){
            while(currN >= currency[i]){
                ans.add(currency[i]);
                currN -= currency[i];
            }
        }
        return ans;
    }
}