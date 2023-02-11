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

    TreeNode* inOrder(TreeNode* root, TreeNode* p, TreeNode* q){
        if(root == NULL || root == p || root == q){
            return root;
        }

        TreeNode* left = inOrder(root->left, p, q);
        TreeNode* right = inOrder(root->right, p, q);

        if(left == NULL){
            return right;
        }
        else if(right == NULL){
            return left;
        }
        else{
            return root;
        }
    }

public:
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
        return inOrder(root, p, q);
    }
};