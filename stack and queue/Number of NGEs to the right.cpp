#include<bits/stdc++.h>
using namespace std;

class Solution{
    int solve(int i, vector<int> &arr){
        int n = arr.size();
        int comp = arr[i];
        int ans = 0;
        for(i = i + 1; i < n; i++){
            if(arr[i] > comp){
                ans++;
            }
        }
        return ans;
    }
public:

    vector<int> count_NGE(int n, vector<int> &arr, int q, vector<int> &indices){
        vector<int> ans;
        for(int i = 0; i < q; i++){
            ans.push_back(solve(indices[i], arr));
        }
        return ans;
    }

};