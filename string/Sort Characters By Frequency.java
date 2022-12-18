import java.util.*;

class Pair{
    char ch;
    int freq;

    Pair(char ch){
        this.ch = ch;
    }
}

class Solution {
    public String frequencySort(String s) {
        int n = s.length();
        if(n <= 1) return s;
        
        Pair charFreq[] = new Pair[75];

        for(int i = 0; i < 75; i ++){
            char ch = (char)(i + 48);
            charFreq[i] = new Pair(ch);
        }
        for(int i = 0; i < n; i++){
            int ch = s.charAt(i) - '0';
            charFreq[ch].freq ++;
        }

        Arrays.sort(charFreq, (x, y) -> y.freq - x.freq);


        StringBuffer ans = new StringBuffer();
        for(int i = 0; i < 75; i++){
            char ch = charFreq[i].ch;
            while(charFreq[i].freq != 0){
                ans.append(ch);
                charFreq[i].freq--;
            }
        }
        return ans.toString();
    }
}