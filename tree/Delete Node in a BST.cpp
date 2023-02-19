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

    TreeNode* deleteNode(TreeNode* node){
        if(node->left == NULL){
            return node->right;
        }        
        else if(node->right == NULL){
            return node->left;
        }

        TreeNode* leftMax = node->left;
        while(leftMax->right != NULL){
            leftMax = leftMax->right;
        }

        leftMax->right = node->right;
        return node->left;
    }

    TreeNode* find(TreeNode* root, int key){
        TreeNode* curr = root;

        while(curr != NULL){
            if(curr->val > key){
                if(curr->left != NULL && curr->left->val == key){
                    curr->left = deleteNode(curr->left);
                }
                else{
                    curr = curr->left;
                }
            }
            else{
                if(curr->right != NULL && curr->right->val == key){
                    curr->right = deleteNode(curr->right);
                }
                else{
                    curr = curr->right;
                }
            }
        }
        return root;
    }
public:
    TreeNode* deleteNode(TreeNode* root, int key) {
        if(root == NULL){
            return NULL;
        }
        if(root->val == key){
            return deleteNode(root);
        }
        return find(root, key);
    }
};