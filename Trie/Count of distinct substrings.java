class Trie{
    Trie children[];
    
   boolean containsKey(char ch){
        return children[ch - 'a'] != null;
    }
    
    void put(char ch, Trie child){
        children[ch - 'a'] = child;
    }
    
    Trie getChild(char ch){
        return children[ch - 'a'];
    }
    
    Trie(){
        children = new Trie[26];
    }
    
}
/*You are required to complete this method */
class GfG
{
   public static int countDistinctSubstring(String s)
   {
        Trie root = new Trie(); 
        int n = s.length();
        
        int ans = 0;
        for(int i = 0 ; i < n; i++){
            Trie node = root;
            
            for(int j = i; j < n; j++){
                char ch = s.charAt(j);
                if(!node.containsKey(ch)){
                    ans++;
                    node.put(ch, new Trie());
                }
                node = node.getChild(ch);
            }
        }
        return ans + 1;

   }
}