// without using trie 
// class Solution {
//     public boolean isPrefixString(String s, String[] words) {
//         StringBuilder res = new StringBuilder ("");
//         for (String word : words) {
//             res.append (word);
//             if (s.equals (res.toString()))
//                 return true;
//             if(res.length() > s.length()){
//                 return false;
//             }
//         }
//         return false;
//     }
// }

class Trie{
    private Trie children[];
    private boolean isLeaf;
    
    private boolean containsKey(char ch){
        return children[ch - 'a'] != null;
    }
    
    private void put(char ch, Trie child){
        children[ch - 'a'] = child;
    }
    
    private Trie getChild(char ch){
        return children[ch - 'a'];
    }

    private void setLeaf(){
        isLeaf = true;
    }

    private boolean getLeaf(){
        return isLeaf;
    }
    
    Trie(){
        children = new Trie[26];
        isLeaf = false;
    }
    
    void insert(String word[]){
        Trie node = this;
        int n = word.length;
        
        for(int i = 0; i < n; i++){
            int m = word[i].length();
            for(int j = 0; j < m; j++){
                char ch = word[i].charAt(j);
                if(!node.containsKey(ch)){
                    node.put(ch, new Trie());
                }
                node = node.getChild(ch);
            }
            node.setLeaf();
        }
    }
    
    boolean check(String word){
        Trie node = this;
        int n = word.length();
        for(int i = 0; i < n; i++){
            char ch = word.charAt(i);
            if(!node.containsKey(ch)){
                return false;
            }
            node = node.getChild(ch);
        }
        return node.getLeaf();
    }
}

class Solution {
    public boolean isPrefixString(String s, String[] words) {
        Trie trie = new Trie();
        trie.insert(words);

        return trie.check(s);
    }
}