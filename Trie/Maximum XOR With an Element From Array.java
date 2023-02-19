import java.util.*;
class Trie{
    private Trie children[];

    private boolean containsKey(int bit){
        return (children[bit] != null);
    }
    
    private void put(int bit, Trie child){
        children[bit] = child;
    }

    private Trie getChild(int bit){
        return children[bit];
    }

    Trie(){
        children = new Trie[2];
    }

    public void insert(int n){
        Trie curr = this;
        for(int i = 31; i >= 0; i--){
            int currBit = (n >> i) & 1;

            if(!curr.containsKey(currBit)){
                curr.put(currBit, new Trie());
            }
            curr = curr.getChild(currBit);
        }
    }

    public int maxXor(int n){
        Trie curr = this;

        int ret = 0;
        for(int i = 31; i>= 0; i--){
            int bit = (n >> i) & 1;

            if(curr.containsKey(1 - bit)){
                curr = curr.getChild(1 - bit);
                ret = ret | (1 << i);
            }
            else{
                curr = curr.getChild(bit);
            }
        }
        return ret;
    }
};
class Solution {
    public int[] maximizeXor(int[] nums, int[][] queries) {
        Trie trie = new Trie();
        int n = nums.length, m = queries.length;

        ArrayList<ArrayList<Integer>> que = new ArrayList<>();

        for(int i = 0; i < m; i++){
            que.add(new ArrayList<Integer>());
            que.get(i).add(queries[i][0]);
            que.get(i).add(queries[i][1]);
            que.get(i).add(i);
        }

        Arrays.sort(nums);
        Collections.sort(que, (a, b)-> a.get(1) - b.get(1));

        int i = 0, j = 0;
        int ans[] = new int[m];
        while(j < m){
            int xi = que.get(j).get(0);
            int mi = que.get(j).get(1);
            int idx = que.get(j).get(2);

            while(i < n && nums[i] <= mi){
                trie.insert(nums[i]);
                i++;
            }
            
            if(i == 0){
                ans[idx] = -1;
            }
            else{
                ans[idx] = trie.maxXor(xi);
            }
            
            j++;
        }
        return ans;
    }
}