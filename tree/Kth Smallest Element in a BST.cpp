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
private:
    int inorder(TreeNode* root, int &k){
        if(root == NULL){
            return -1;
        }
        int retLeft = inorder(root->left, k);
        if(retLeft != -1){
            return retLeft;
        }
        k--;
        if(k == 0){
            return root->val;
        }
        return inorder(root->right, k);
    }
public:
    int kthSmallest(TreeNode* root, int k) {
        return inorder(root, k);
    }
};