class Trie{
    private Trie children[];

    private boolean containsKey(int bit){
        return children[bit] != null;
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
    public int findMaximumXOR(int[] nums) {
        Trie trie = new Trie();
        int n = nums.length;
        
        for(int i = 0; i < n; i++){
            trie.insert(nums[i]);
        }

        int ans = 0;
        for(int i = 0; i < n; i++){
            ans = Math.max(ans, trie.maxXor(nums[i]));
        }

        return ans;
    }
}