#include <bits/stdc++.h>
using namespace std;

class Solution {
  private:
    int noOfUnique(vector<int> &mp){
        int unique = 0;
        
        for(int i = 0; i < 26; i++){
            if(mp[i] != 0){
                unique++;
            }
        }
        return unique;
    }
  public:
    int longestKSubstr(string s, int k) {
        vector<int> mp(26, 0);
        int right = 0, left = 0;
        int ans = 0, n = s.length();
        
        while(right < n){
            mp[s[right] - 'a']++;
            
            if(noOfUnique(mp) > k){
                mp[s[left] - 'a']--;
                left++;
            }
            
            if(noOfUnique(mp) == k){
                ans = max(ans, right - left + 1);
            }
            
            right++;
        }
        
        if(noOfUnique(mp) < k){
            return -1;
        }
        return ans;
    }
};