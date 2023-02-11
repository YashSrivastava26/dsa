#include <bits/stdc++.h>
using namespace std;

struct Node {
    int data;
    Node *left;
    Node *right;

    Node(int val) {
        data = val;
        left = right = NULL;
    }
};

class Solution {
    int traversalWithSum(Node* node, int &maxi){
        if(!node){
            return 0;
        }    
        int ls = max(0, traversalWithSum(node->left, maxi));
        int rs = max(0, traversalWithSum(node->right, maxi));
        
        maxi = max(maxi, ls + rs + node->data);
        return max(ls, rs) + node->data;
    }
    
  public:
    //Function to return maximum path sum from any node in a tree.
    int findMaxSum(Node* root)
    {
        int maxi = INT_MIN;
        traversalWithSum(root, maxi);
        return maxi;
    }
};
