#include<bits/stdc++.h>
using namespace std;

// class Solution {
// public:
//     int lengthOfLongestSubstring(string s) {
//         int n = s.length(), ans = 0;
//         int left = 0, right = 0;
//         unordered_set<char> inWindow;
//         while(right < n){

//             while(inWindow.find(s[right]) != inWindow.end()){
//                 inWindow.erase(s[left]);
//                 left++;
//             }

//             inWindow.insert(s[right]);
//             right++;

//             ans = max(ans, (int)inWindow.size());
//         }

//         return max(ans, (int)inWindow.size());
//     }
// };

//using map
class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        int n = s.length(), ans = 0;
        int left = 0, right = 0;
        unordered_map<char, int> inWindow;
        while(right < n){

            if(inWindow[s[right]] > 0){
                left = max(left, inWindow[s[right]]);
            }

            inWindow[s[right]] = right + 1;
            ans = max(ans, right - left + 1);

            right++;
        }

        return ans;
    }
};