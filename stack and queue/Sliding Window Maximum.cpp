#include<bits/stdc++.h>
using namespace std;

class Solution {
    public:
    vector<int> maxSlidingWindow(vector<int>& nums, int k) {
        int n = nums.size();
        if(k > n){
            return {};
        }

        deque<int> decreasing;
        
        for(int i = 0; i < k; i++){
            while(!decreasing.empty() && nums[decreasing.back()] <= nums[i]){
                decreasing.pop_back();
            }
            decreasing.push_back(i);
        }

        vector<int> ans;
        ans.push_back(nums[decreasing.front()]);
        for(int i = k; i < n; i++){
            if(decreasing.front() < i - k + 1){
                decreasing.pop_front();
            }
            
            while(!decreasing.empty() && nums[decreasing.back()] <= nums[i]){
                decreasing.pop_back();
            }
            decreasing.push_back(i);

            ans.push_back(nums[decreasing.front()]);
        }

        return ans;
    }
};