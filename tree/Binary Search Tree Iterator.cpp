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


class BSTIterator {
private:
    stack<TreeNode*> inorder;
public:
    BSTIterator(TreeNode* root) {
        TreeNode* curr = root;

        while(curr != NULL){
            inorder.push(curr);
            curr = curr->left;
        }
    }
    
    int next() {
        TreeNode* ret = inorder.top();
        inorder.pop();
        TreeNode* rightNodes = ret->right;

        while(rightNodes != NULL){
            inorder.push(rightNodes);
            rightNodes = rightNodes->left;
        }
        return ret->val;
    }
    
    bool hasNext() {
        if(inorder.empty()){
            return false;
        }
        return true;
    }
};


