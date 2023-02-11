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
    void inOrder(TreeNode* node, string &curr, vector<string> &ans){
        if(node->left == NULL && node->right == NULL){
            ans.push_back(curr);
        }

        int len = curr.size();
        if(node->left != NULL){
            curr += "->" + to_string(node->left->val);
            inOrder(node->left, curr, ans);
            curr = curr.substr(0, len);
        }

        if(node->right != NULL){
            curr += "->" + to_string(node->right->val);
            inOrder(node->right, curr, ans);
            curr = curr.substr(0, len);
        }
    }
public:
    vector<string> binaryTreePaths(TreeNode* root) {
        vector<string> ans;
        string curr;
        curr += to_string(root->val);
        inOrder(root, curr, ans);

        return ans;
    }
};