#include<bits/stdc++.h>
using namespace std;

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode() : val(0), left(nullptr), right(nullptr) {}
    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
    TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
};


class Solution {
public:
    int widthOfBinaryTree(TreeNode* root) {
        queue<pair<long long, TreeNode*>> q;
        q.push({1, root});
        long long maxi = INT_MIN;
        while(!q.empty()){
            long long n = q.size();
            long long first = q.front().first, last = -1;;
            for(long long i = 0; i < n; i++){
                auto curr = q.front();
                q.pop();
                
                long long idx = curr.first - first;
                last = idx;

                if(curr.second->left){
                    q.push({2 * idx, curr.second->left});
                }

                if(curr.second->right){
                    q.push({2 * idx + 1, curr.second->right});
                }
            }

            maxi = max(maxi, last + 1);
        }

        return maxi;
    }
};