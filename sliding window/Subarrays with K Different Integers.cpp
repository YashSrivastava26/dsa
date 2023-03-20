#include <bits/stdc++.h>
using namespace std;

class Solution {
    long long atMost(vector<int> &arr, int k){
        if(k <= 0){
            return 0;
        }
        
        int left = 0, right = 0, n = arr.size();
        unordered_map<int, int> freqMap;
        long long ans = 0;
        
        while(right < n){
            if(freqMap[arr[right]] == 0){
                k--;
            }
            freqMap[arr[right]] ++;
            
            while(k < 0){
                freqMap[arr[left]] --;
                if(freqMap[arr[left]] == 0){
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
    int subarraysWithKDistinct(vector<int>& arr, int k) {
        return (int)(atMost(arr, k) - atMost(arr, k - 1));
    }
};