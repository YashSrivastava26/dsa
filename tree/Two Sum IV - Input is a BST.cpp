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
    bool reverse = true;
public:
    BSTIterator(TreeNode* root, bool isreverse) {
        reverse = isreverse;
        pushAll(root);
    }
    
    void pushAll(TreeNode* node){
        while(node != NULL){
            inorder.push(node);
            if(reverse){
                node = node->right;
            }
            else{
                node = node->left;
            }
        }
    }

    int next() {
        TreeNode* ret = inorder.top();
        inorder.pop();
        if(reverse){
            pushAll(ret->left);
        }
        else{
            pushAll(ret->right);
        }
        return ret->val;
    }
};
class Solution {
public:
    bool findTarget(TreeNode* root, int k) {
        BSTIterator low(root, false);
        BSTIterator high(root, true);
        int lowVal = low.next(), highVal = high.next();

        while(lowVal < highVal){
            if(lowVal + highVal == k){
                return true;
            }
            if(lowVal + highVal > k){
                highVal = high.next();
            }
            else{
                lowVal = low.next();
            }
        }
        return false;
    }
};