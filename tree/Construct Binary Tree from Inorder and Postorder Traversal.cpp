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
    TreeNode* create(vector<int> &inorder, int inStart, int inEnd, vector<int> &postorder, int postStart, int postEnd, unordered_map<int, int> &idxInorder){
        if(inStart > inEnd || postStart > postEnd){
            return NULL;
        }

        TreeNode* root = new TreeNode(postorder[postEnd]);
        int rootIdx = idxInorder.find(root->val)->second;
        int numsLeft = rootIdx - inStart - 1;

        root->left = create(inorder, inStart, rootIdx - 1,
                            postorder, postStart, postStart + numsLeft, idxInorder);
                            
        root->right = create(inorder, rootIdx + 1, inEnd,
                            postorder, postStart + numsLeft + 1, postEnd - 1, idxInorder);
        
        return root;
    }
public:
    TreeNode* buildTree(vector<int>& inorder, vector<int>& postorder) {
        int n = inorder.size();
        unordered_map<int, int> idxInorder;

        for(int i = 0; i < n; i++){
            idxInorder[inorder[i]] = i;
        }

        return create(inorder, 0, n - 1,
                postorder, 0, n - 1, idxInorder);
    }
};