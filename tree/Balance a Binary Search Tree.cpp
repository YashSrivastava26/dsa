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
    void traverseInorder(TreeNode* node, vector<TreeNode*> &inorder){
        if(node == NULL){
            return;
        }

        traverseInorder(node->left, inorder);
        inorder.push_back(node);
        traverseInorder(node->right, inorder);
    }

    TreeNode* buildTree(vector<TreeNode*> &inorder, int low, int high){
        if(low > high){
            return NULL;
        }

        int mid = low + (high - low) / 2;

        TreeNode* curr = inorder[mid];

        curr->left = buildTree(inorder, low, mid - 1);
        curr->right = buildTree(inorder, mid + 1, high);
        return curr;
    }
public:
    TreeNode* balanceBST(TreeNode* root) {
        vector<TreeNode*> inorder;

        traverseInorder(root, inorder); 

        return buildTree(inorder, 0, inorder.size() - 1);
    }
};