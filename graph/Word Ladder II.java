
import java.util.*;
class Solution
{
    public ArrayList<ArrayList<String>> findSequences(String startWord, String targetWord, String[] wordList)
    {
        Set<String> st = new HashSet<>();
        for (int i = 0; i < wordList.length; i++) {
            st.add(wordList[i]);
        }

        ArrayList<ArrayList<String>> ans = new ArrayList<>();
        Queue< ArrayList < String >> q = new LinkedList<>();
        ArrayList < String > ls = new ArrayList<>();
        ArrayList < String > usedOnLvl = new ArrayList<>();
        ls.add(startWord);
        q.add(ls);
        usedOnLvl.add(startWord);
        int lvl = 0;
        while(!q.isEmpty()){
            ArrayList < String > seq= q.poll();
            if(seq.size() > lvl){
                lvl++;
                for (String seqWord : usedOnLvl) {
                    st.remove(seqWord);
                }
                usedOnLvl.clear();
            }

            String word = seq.get(seq.size() - 1);
            if(word.equals(targetWord)){
                if(ans.size() == 0){
                    ans.add(seq);
                }
                else if(ans.size() == ans.get(0).size()){
                    ans.add(seq);
                }
            }
            for (int i = 0; i < word.length(); i++) {
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    char replaceWordArr[] = word.toCharArray();
                    replaceWordArr[i] = ch;
                    String replaceString = new String(replaceWordArr);
                    if(st.contains(replaceString)){
                        seq.add(replaceString);
                        //ArrayList <String> temp = new ArrayList<>(seq);
                        q.add(seq/*temp*/);
                        usedOnLvl.add(replaceString);
                        seq.remove(seq.size() - 1);
                    }
                }
            }

        }
        return ans;
    }
}