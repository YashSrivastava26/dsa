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
    void recoverTree(TreeNode* root) {
        stack<TreeNode*> inorder;

        TreeNode* firstViolation = NULL, *firstViolatedWith = NULL, *lastviolation = NULL;

        TreeNode* prev = NULL, *curr = root;
        while(1){
            if(curr != NULL){
                inorder.push(curr);
                curr = curr->left;
            }
            else{
                if(inorder.empty()){
                    break;
                }
                curr = inorder.top();
                inorder.pop();

                if(prev != NULL && prev->val > curr->val){
                    if(firstViolation == NULL){
                        firstViolation = prev;
                        firstViolatedWith = curr;
                    }
                    else{
                        lastviolation = curr;
                    }
                }
                prev = curr;
                curr = curr->right;
            }
        }

        if(lastviolation == NULL){
            int temp = firstViolation->val;
            firstViolation->val = firstViolatedWith->val;
            firstViolatedWith->val = temp;
        }
        else{
            int temp = firstViolation->val;
            firstViolation->val = lastviolation->val;
            lastviolation->val = temp;
        }
    }
};