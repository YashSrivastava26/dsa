import java.util.HashMap;
//O(n * n)
class Solution {
    public boolean isIsomorphic(String s, String t) {
        int n = s.length(), m = t.length();

        if(n != m) return false;

        HashMap < Character , Character > mp = new HashMap<>();

        for (int i = 0; i < n; i++) {
            Character ch = s.charAt(i), ch2 = t.charAt(i);

            if(mp.containsKey(ch)){
                if(ch2 != mp.get(ch)) return false;
            }
            else{
                if(mp.containsValue(ch2)) return false;//O(n) operation
                mp.put(ch, ch2);
            }
        }
        return true;
    }
}

//o(2 * n)
// class Solution {
//     private boolean isIsomorphic1(String s1, String s2, int n){
//         HashMap < Character , Character > mp = new HashMap<>();

//         for (int i = 0; i < n; i++) {
//             Character ch = s1.charAt(i), ch2 = s2.charAt(i);

//             if(mp.containsKey(ch)){
//                 if(ch2 != mp.get(ch)) return false;
//             }
//             else{
//                 mp.put(ch, ch2);
//             }
//         }
//         return true;
//     }
//     public boolean isIsomorphic(String s, String t) {
//         int n = s.length(), m = t.length();

//         if(n != m) return false;

//         if(isIsomorphic1(s, t, n) && isIsomorphic1(t, s, n)) return true;
//         return false;
//     }
// }