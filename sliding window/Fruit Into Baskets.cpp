#include <bits/stdc++.h>
using namespace std;

class Solution {
  public:
    int totalFruits(int N, vector<int> &fruits) {
        unordered_map<int, int> fruitTypeInWindow;
        int left = 0, right = 0;
        int ans = 0;
        
        while(right < N){
            fruitTypeInWindow[fruits[right]]++;
            
            while(fruitTypeInWindow.size() > 2){
                fruitTypeInWindow[fruits[left]]--;
                
                if(fruitTypeInWindow[fruits[left]] == 0){
                    fruitTypeInWindow.erase(fruits[left]);
                }
                left++;
            }
            ans = max(ans, right - left + 1);
            right++;
        }
        
        return ans;
    }
};