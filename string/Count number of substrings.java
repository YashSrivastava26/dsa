import java.util.HashMap;

// class Solution
// {

//     long atMostKDistinct(String S, int K){
//         int n = S.length();
//         int left = 0;
//         long ans = 0;
        
//         HashMap < Character, Integer > freqMap = new HashMap<>();
//         for(int i = 0; i < n; i ++){
//             char ch = S.charAt(i);
//             freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);

//             while(freqMap.size() > K){
//                 char chLeft = S.charAt(left);
//                 left++;
//                 freqMap.put(chLeft, freqMap.get(chLeft) - 1);
//                 if(freqMap.get(chLeft) == 0){
//                     freqMap.remove(chLeft);
//                 }
//             }

//             ans += i - left + 1;
//         }
//         return ans;
//     }
//     long substrCount (String S, int K) {
//         return atMostKDistinct(S, K) - atMostKDistinct(S, K - 1);
//     }
// }


class Solution
{

    long atMostKDistinct(String S, int K){
        int n = S.length();
        int left = 0;
        long ans = 0;
        int size = 0;
        
        int freqMap[] = new int[26];
        for(int i = 0; i < n; i ++){
            char ch = S.charAt(i);
            if(freqMap[ch - 'a'] == 0) size++;
            freqMap[ch - 'a']++;

            while(size > K){
                char chLeft = S.charAt(left);
                left++;
                freqMap[chLeft - 'a'] --;
                if(freqMap[chLeft - 'a'] == 0){
                    size--;
                }
            }

            ans += i - left + 1;
        }
        return ans;
    }
    long substrCount (String S, int K) {
        return atMostKDistinct(S, K) - atMostKDistinct(S, K - 1);
    }
}