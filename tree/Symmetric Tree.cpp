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
    bool traversal(TreeNode* lSubTree, TreeNode* rSubTree){
        if(!lSubTree && !rSubTree){
            return true;
        }
        if(!lSubTree || !rSubTree || lSubTree->val != rSubTree->val){
            return false;
        }


        return traversal(lSubTree->left, rSubTree->right) && traversal(lSubTree->right, rSubTree->left);
    }
public:
    bool isSymmetric(TreeNode* root) {
        return traversal(root->left, root->right);
    }
};