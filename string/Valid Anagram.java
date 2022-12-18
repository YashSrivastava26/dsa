// import java.util.HashMap;

// class Solution {
//     public boolean isAnagram(String s, String t) {
//         int n = s.length(), m = t.length();
//         if(n != m) return false;
//         HashMap<Character, Integer> hash = new HashMap<>();

//         for(int i = 0; i < n; i++){
//             char ch = s.charAt(i);
//             if(hash.containsKey(ch)){
//                 hash.put(ch, hash.get(ch) + 1);
//             }
//             else{
//                 hash.put(ch, 1);
//             }
//         }
//         //System.out.println(hash.entrySet());
//         for(int i = 0; i < n; i++){
//             char ch = t.charAt(i);
//             if(hash.containsKey(ch)){
//                 hash.put(ch, hash.get(ch) - 1);
//                 if(hash.get(ch) < 0) return false;
//             }
//             else{
//                 return false;
//             }
//         }
//         //System.out.println(hash.entrySet());
//         return true;
//     }
// }


class Solution {
    public boolean isAnagram(String s, String t) {
        int n = s.length(), m = t.length();
        if(n != m) return false;
        int chFreq[] = new int[26];

        for(int i = 0; i < n; i++){
            chFreq[s.charAt(i) - 'a'] ++;
            chFreq[t.charAt(i) - 'a'] --;
        }

        for(int i = 0; i < 26; i++){
            if(chFreq[i] != 0) return false;
        }
        return true;
    }
}