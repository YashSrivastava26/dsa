#include<bits/stdc++.h>
using namespace std;

// class Solution {
// private:
//     long long greatest(vector<int> &nums){
//         stack<long long> monitonic;
//         int n = nums.size();
//         vector<long long> leftInfulence(n), rightInfulence(n); 

//         for(int i = 0; i < n; i++){
//             while(!monitonic.empty() && nums[monitonic.top()] <= nums[i]){
//                 monitonic.pop();
//             }

//             if(monitonic.empty()){
//                 leftInfulence[i] = i + 1;
//             }
//             else{
//                 leftInfulence[i] = i - monitonic.top();
//             }

//             monitonic.push(i);
//         }

//         while(!monitonic.empty()){
//             monitonic.pop();
//         }

//         for(int i = n - 1; i >= 0; i--){
//             while(!monitonic.empty() && nums[monitonic.top()] < nums[i]){
//                 monitonic.pop();
//             }

//             if(monitonic.empty()){
//                 rightInfulence[i] = n - i;
//             }
//             else{
//                 rightInfulence[i] = monitonic.top() - i;
//             }

//             monitonic.push(i);
//         }

//         long long ans = 0;
//         for(int i = 0 ; i < n; i++){
//             ans += leftInfulence[i] * rightInfulence[i] * nums[i];
//         }
//         return ans;
//     }


//     long long smallest(vector<int> &nums){
//         stack<long long> monitonic;
//         int n = nums.size();
//         vector<long long> leftInfulence(n), rightInfulence(n); 

//         for(int i = 0; i < n; i++){
//             while(!monitonic.empty() && nums[monitonic.top()] >= nums[i]){
//                 monitonic.pop();
//             }

//             if(monitonic.empty()){
//                 leftInfulence[i] = i + 1;
//             }
//             else{
//                 leftInfulence[i] = i - monitonic.top();
//             }

//             monitonic.push(i);
//         }

//         while(!monitonic.empty()){
//             monitonic.pop();
//         }
//         for(int i = n - 1; i >= 0; i--){
//             while(!monitonic.empty() && nums[monitonic.top()] > nums[i]){
//                 monitonic.pop();
//             }

//             if(monitonic.empty()){
//                 rightInfulence[i] = n - i;
//             }
//             else{
//                 rightInfulence[i] = monitonic.top() - i;
//             }

//             monitonic.push(i);
//         }

//         long long ans = 0;
//         for(int i = 0 ; i < n; i++){
//             ans += leftInfulence[i] * rightInfulence[i] * nums[i];
//         }
//         return ans;
//     }
// public:
//     long long subArrayRanges(vector<int>& nums) {
//         return greatest(nums) - smallest(nums);
//     }
// };



class Solution {
private:
    long long greatest(vector<int> &nums){
        stack<int> monitonic;
        int n = nums.size();
        long long ans = 0;

        for(int i = 0; i <= n; i++){
            while(!monitonic.empty() && (i == n || nums[monitonic.top()] <= nums[i])){
                int mid = monitonic.top();
                monitonic.pop();

                int left = monitonic.empty() ? -1 : monitonic.top();

                ans += (long long)(i - mid) * (mid - left) * nums[mid];
            }
            monitonic.push(i);
        }
        return ans;
    }


    long long smallest(vector<int> &nums){
        stack<int> monitonic;
        int n = nums.size();
        long long ans = 0;

        for(int i = 0; i <= n; i++){
            while(!monitonic.empty() && (i == n || nums[monitonic.top()] >= nums[i])){
                int mid = monitonic.top();
                monitonic.pop();

                int left = monitonic.empty() ? -1 : monitonic.top();

                ans += (long long)(i - mid) * (mid - left) * nums[mid];
            }
            monitonic.push(i);
        }
        return ans;
    }
public:
    long long subArrayRanges(vector<int>& nums) {
        return greatest(nums) - smallest(nums);
    }
};