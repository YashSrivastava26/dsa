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

// class Solution {
// private:
//     TreeNode* build(vector<int> &preorder, int start, int end){
//         if(start > end){
//             return NULL;
//         }

//         TreeNode* curr = new TreeNode(preorder[start]);
//         int i;
//         for(i = start + 1; i <= end; i++){
//             if(preorder[i] > preorder[start]){
//                 break;
//             }
//         }

//         curr->left = build(preorder, start + 1, i - 1);
//         curr->right = build(preorder, i, end);
//         return curr;
//     }
// public:
//     TreeNode* bstFromPreorder(vector<int>& preorder) {
//         return build(preorder, 0, preorder.size() - 1);
//     }
// };


class Solution {
private:
    TreeNode* build(vector<int> &preorder, int upperBond, int &i){
        if(i >= preorder.size() || upperBond < preorder[i]){
            return NULL;
        }

        TreeNode* curr = new TreeNode(preorder[i]);
        i++;
        curr->left = build(preorder, curr->val, i);
        curr->right = build(preorder, upperBond, i);

        return curr;
    }
public:
    TreeNode* bstFromPreorder(vector<int>& preorder) {
        int i = 0;
        return build(preorder, INT_MAX, i);
    }
};