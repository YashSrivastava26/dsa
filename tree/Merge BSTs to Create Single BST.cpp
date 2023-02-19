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

    bool isValidBST(TreeNode* root, int low, int high){
        if(root == NULL){
            return true;
        }
        if(root->val <= low || root->val >= high){
            return false;
        }

        return isValidBST(root->left, low, root->val) && isValidBST(root->right, root->val, high);
    }

    TreeNode* buildTree(TreeNode* root, unordered_map<int, TreeNode*> &rootMap, unordered_set<TreeNode*> &isDone){

        if(root == NULL){
            return NULL;
        }
        
        queue<TreeNode*> lvlorder;
        lvlorder.push(root);

        while(!lvlorder.empty()){
            TreeNode* curr = lvlorder.front();
            lvlorder.pop();

            if(curr->left == NULL && curr->right == NULL){
                if(isDone.find(rootMap[curr->val]) != isDone.end()){
                    TreeNode* merge = rootMap[curr->val];

                    curr->left = merge->left;
                    curr->right = merge->right;
                    isDone.erase(merge);
                }
            }
            
            if(curr->left){
                lvlorder.push(curr->left);
            }
            if(curr->right){
                lvlorder.push(curr->right);
            }
        }

        if(isDone.size() > 0){
            return NULL;
        }

        if(isValidBST(root, INT_MIN, INT_MAX)){
            return root;
        }
        return NULL;
    }
public:
    TreeNode* canMerge(vector<TreeNode*>& trees) {
        unordered_set<int> leaves;
        unordered_map<int, TreeNode*> rootMap;
        unordered_set<TreeNode*> isDone;
        int n = trees.size();

        for(int i = 0; i < n; i++){
            rootMap[trees[i] -> val] = trees[i];
            isDone.insert(trees[i]);

            if(trees[i]->left) leaves.insert(trees[i]->left->val);
            if(trees[i]->right) leaves.insert(trees[i]->right->val);
        }
        int cnt = 0;
        TreeNode* root = NULL;
        for(int i = 0; i < n; i++){
           if(leaves.find(trees[i]->val) == leaves.end()){
               root = trees[i];
               cnt++;
               if(cnt > 1){
                   return NULL;
               }
           }
        }
        isDone.erase(root);
        return buildTree(root, rootMap, isDone);
    }
};