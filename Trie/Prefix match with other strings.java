class Trie{
    private Trie children[];
    
    private boolean containsKey(char ch){
        return children[ch - 'a'] != null;
    }
    
    private void put(char ch, Trie child){
        children[ch - 'a'] = child;
    }
    
    private Trie getChild(char ch){
        return children[ch - 'a'];
    }
    
    Trie(){
        children = new Trie[26];
    }
    
    void insert(String word){
        Trie node = this;
        int n = word.length();
        
        for(int i = 0; i < n; i++){
            char ch = word.charAt(i);
            if(!node.containsKey(ch)){
                node.put(ch, new Trie());
            }
            node = node.getChild(ch);
        }
    }
    
    boolean check(String word, int k){
        if(k > word.length()){
            return false;
        }
        Trie node = this;
        for(int i = 0; i < k; i++){
            char ch = word.charAt(i);
            if(!node.containsKey(ch)){
                return false;
            }
            node = node.getChild(ch);
        }
        return true;
    }
}
class Solution
{
    public int klengthpref(String[] arr, int n, int k, String str)
    {
        if(k > str.length()){
            return 0;
        }
        Trie trie = new Trie();
        trie.insert(str);
        
        int ans = 0;
        for(int i = 0; i < n; i++){
            if(trie.check(arr[i], k)){
                ans++;
            }
        }
        return ans;
    }
}