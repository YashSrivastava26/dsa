#include <bits/stdc++.h>
using namespace std;

struct Node {
    int data;
    struct Node* left;
    struct Node* right;
};

class Solution
{
    private:
    int inorder(Node* root, int &k){
        if(root == NULL){
            return -1;
        }
        int retLeft = inorder(root->right, k);
        if(retLeft != -1){
            return retLeft;
        }
        k--;
        if(k == 0){
            return root->data;
        }
        return inorder(root->left, k);
    }
    
    public:
    int kthLargest(Node *root, int k)
    {
        return inorder(root, k);
    }
};