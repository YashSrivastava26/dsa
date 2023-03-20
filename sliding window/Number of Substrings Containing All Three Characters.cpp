#include <bits/stdc++.h>
using namespace std;

class Solution {
private:
    bool all_3_present(vector<int> &mp){
        if(mp[0] > 0 && mp[1] > 0 && mp[2] > 0){
            return true;
        }
        return false;
    }
public:
    int numberOfSubstrings(string s) {
        int n = s.length();
        vector<int> mp(3, 0);
        int ans = 0, right = 0, left = 0;

        while(right < n){
            mp[s[right] - 'a']++;
            while(all_3_present(mp)){
                ans += n - right;

                mp[s[left] - 'a']--;
                left++;
            }
            right++;
        }

        return ans;
    }
};