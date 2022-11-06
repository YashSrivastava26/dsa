import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

class Pair{
    String word;
    int steps;
    Pair(String word, int steps){
        this.word = word;
        this.steps = steps;
    }
}
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> st = new HashSet<>();
        //O(n)
        for (String word : wordList) {
            st.add(word);
        }

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(beginWord, 1));
        st.remove(beginWord);
        //O(listlength * wordlength * 26)
        while(!q.isEmpty()){
            String word = q.peek().word;
            int steps = q.peek().steps;
            q.remove();

            if(word.equals(endWord)) return steps;

            for (int i = 0; i < word.length(); i++) {
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    char replaceWordArray[] = word.toCharArray();
                    replaceWordArray[i] = ch;
                    String temp = new String(replaceWordArray);
                    if(st.contains(temp)){
                        st.remove(temp);
                        q.add(new Pair(temp, steps + 1));
                    }
                }
            }
        }
        return 0;
    }
}