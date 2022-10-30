import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> pascaltriangle = new ArrayList<>();
        List<Integer> prev = null, curr;
        for (int i = 0; i < numRows; i++) {
            curr = new ArrayList<>();
            for (int j = 0; j <= i ; j++) {
                if(j == 0 || j == i){
                    curr.add(1);
                }
                else{
                    
                    curr.add(prev.get(j - 1) + prev.get(j));
                }
            }
            pascaltriangle.add(curr);
            prev = curr;
        }
        return pascaltriangle;
    }
}

