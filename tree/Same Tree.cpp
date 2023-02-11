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
    bool traversal(TreeNode* p, TreeNode* q){
        if(!p && !q){
            return true;
        }
        if(!p || !q || p->val != q->val){
            return false;
        }

        return traversal(p->left, q->left) & traversal(p->right, q->right);
    }
public:
    bool isSameTree(TreeNode* p, TreeNode* q) {
        return traversal(p, q);
    }
};