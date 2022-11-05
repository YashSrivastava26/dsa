import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

class Pair{
    String word;
    int dis;
    Pair(int dis, String word)
    {
        this.dis = dis;
        this.word = word;
    }
}

class Solution
{
    public int wordLadderLength(String startWord, String targetWord, String[] wordList){
        Set<String> setOfWordList = new HashSet<>();
        Queue<Pair> q = new LinkedList<>();

        for (int i = 0; i < wordList.length; i++) {
            setOfWordList.add(wordList[i]);
        }


        q.add(new Pair(1, startWord));
        setOfWordList.remove(startWord);
        while(!q.isEmpty()){
            String word = q.peek().word;
            int currDis = q.peek().dis;
            q.remove();

            if(word.equals(targetWord)) return currDis;
            for (int i = 0; i < word.length(); i++) {
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    char arrOfWordString[] = word.toCharArray();
                    arrOfWordString[i] = ch;
                    String replacedString = new String(arrOfWordString);
                    if(setOfWordList.contains(replacedString)){
                        setOfWordList.remove(replacedString);
                        q.add(new Pair(currDis + 1, replacedString));
                    }
                }
                
            }
        }
        return 0;
    }
}