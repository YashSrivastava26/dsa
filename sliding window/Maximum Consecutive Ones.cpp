#include <bits/stdc++.h>
using namespace std;

class Solution {
  public:
    int longestOnes(int n, vector<int>& nums, int k) {
        int zeroInWindow = 0;
        int left = 0, right = 0;
        int ans = 0;
        
        while(right < n){
            if(nums[right] == 0){
                zeroInWindow++;
            }
            while(zeroInWindow > k){
                if(nums[left] == 0){
                    zeroInWindow--;
                }
                left++;
            }
            ans = max(ans, right - left + 1);
            right++;
        }
        return ans;
    }
};
