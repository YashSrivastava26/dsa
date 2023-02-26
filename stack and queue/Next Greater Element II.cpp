#include<bits/stdc++.h>
using namespace std;

class Solution {
public:
    vector<int> nextGreaterElements(vector<int>& nums) {
        stack<int> increasing;
        int n = nums.size();

        for(int i = n - 1; i >= 0; i--){
            while(!increasing.empty() && nums[i] >= increasing.top()){
                increasing.pop();
            }
            increasing.push(nums[i]);
        }

        vector<int> ans(n);
        for(int i = n - 1; i >= 0; i--){
            // System.out.println(increasing);
            while(!increasing.empty() && nums[i] >= increasing.top()){
                increasing.pop();
            }

            if(increasing.empty()){
                ans[i] = -1;
            }
            else{
                ans[i] = increasing.top();
            }
            increasing.push(nums[i]);
        }

        return ans;
    }
};