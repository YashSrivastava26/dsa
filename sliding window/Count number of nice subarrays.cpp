#include <bits/stdc++.h>
using namespace std;

class Solution {
    private:
        int atMost(vector<int> &nums, int k){
            if(k < 0){
                return 0;
            }
    
            int left = 0, right = 0;
            int n = nums.size(), ans = 0;
    
            while(right < n){
                if(nums[right] % 2 == 1){
                    k--;
                }
    
                while(k < 0){
                    if(nums[left] % 2 == 1){
                        k++;
                    }
                    left++;
                }
    
                ans += right - left + 1;
                right++;
            }
    
            return ans;
        }
    public:
        int numberOfSubarrays(vector<int>& nums, int k) {
            return atMost(nums, k) - atMost(nums, k - 1);
        }
    };