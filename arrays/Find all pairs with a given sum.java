import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;


class pair  {  
    long first, second;  
    public pair(long first, long second)  
    {  
        this.first = first;  
        this.second = second;  
    }  
}



class Solution {
    public pair[] allPairs( long A[], long B[], long N, long M, long X) {
        HashSet<Long> hash = new HashSet<>();
        ArrayList<pair> ans = new ArrayList<>();
        for (Long x : B) {
            hash.add(x);
        }

        Arrays.sort(A);  // bcz ans is according to increasing order of A

        for (Long x : A) {
            if(hash.contains(X - x))
                ans.add(new pair(x, X - x));
        }
        pair[] ret = new pair[ans.size()];
        return ans.toArray(ret);

    }
}
