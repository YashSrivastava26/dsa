#include<bits/stdc++.h>
using namespace std;

class Solution {
public:
    vector<int> nextGreaterElement(vector<int>& nums1, vector<int>& nums2) {
        stack<int> increasing;
        int n = nums2.size();
        unordered_map<int, int> mp;

        for(int i = n - 1; i >= 0; i--){
            while(!increasing.empty() && nums2[i] > increasing.top()){
                increasing.pop();
            }

            if(increasing.empty()){
                mp[nums2[i]] = -1;
            }
            else{
                mp[nums2[i]] = increasing.top();
            }
            
            increasing.push(nums2[i]);
        }

        int m = nums1.size();
        vector<int> ans;
        for(int i = 0; i < m; i++){
            ans.push_back(mp[nums1[i]]);
        }
        return ans;
    }
};