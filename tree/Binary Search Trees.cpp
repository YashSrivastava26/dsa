#include<bits/stdc++.h>
using namespace std;


class Solution {
  public:
    bool isBSTTraversal(vector<int>& nums) {
        
        int n = nums.size();
        
        for(int i = 1; i < n; i++){
            if(nums[i] <= nums[i - 1]){
                return false;
            }
        }
        return true;
    }
};