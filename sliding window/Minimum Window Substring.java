// class Solution {
//     private boolean haveAllChars(int[] mapS, int[] mapT){
//         for(int i = 0; i < 58; i++){
//             if(mapT[i] > mapS[i]){
//                 return false;
//             }
//         }
//         return true;
//     }
//     public String minWindow(String s, String t) {
//         int[] mapT = new int[58];
//         int[] mapS = new int[58];
//         int n = s.length(), m = t.length();

//         for(int i = 0; i < m; i++){
//             mapT[t.charAt(i) - 'A'] ++;
//         }

//         int ans[] = {Integer.MAX_VALUE, 0, 0};
//         int left = 0;
//         for(int right = 0; right < n; right++){
//             mapS[s.charAt(right) - 'A']++;

//             while(haveAllChars(mapS, mapT)){
//                 if(ans[0] > right - left + 1){
//                     ans[0] = right - left + 1;
//                     ans[1] = left;
//                     ans[2] = right + 1;
//                 }

//                 mapS[s.charAt(left) - 'A']--;
//                 left++;
//             }
//         }

//         return s.substring(ans[1], ans[2]);
//     }
// }


class Solution {
    public String minWindow(String s, String t) {
        int[] mapT = new int[58];
        int[] mapS = new int[58];
        int n = s.length(), m = t.length();
        int need = 0, have = 0;

        for(int i = 0; i < m; i++){
            if(mapT[t.charAt(i) - 'A'] == 0){
                need ++;
            }
            mapT[t.charAt(i) - 'A'] ++;
        }

        int ans[] = {Integer.MAX_VALUE, 0, 0};
        int left = 0;
        for(int right = 0; right < n; right++){
            mapS[s.charAt(right) - 'A']++;
            
            if(mapS[s.charAt(right) - 'A'] == mapT[s.charAt(right) - 'A']){
                have++;
            }

            // System.out.println(left + " " + right + " " + have + " " + need);
            while(have >= need){
                if(ans[0] > right - left + 1){
                    ans[0] = right - left + 1;
                    ans[1] = left;
                    ans[2] = right + 1;
                }

                mapS[s.charAt(left) - 'A']--;
                if(mapS[s.charAt(left) - 'A'] == mapT[s.charAt(left) - 'A'] - 1){
                    have--;
                }
                left++;
            }

        }

        return s.substring(ans[1], ans[2]);
    }
}