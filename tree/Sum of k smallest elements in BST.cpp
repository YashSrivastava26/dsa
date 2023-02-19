#include <bits/stdc++.h>
using namespace std;

struct Node {
    int data;
    Node* right;
    Node* left;
    
    Node(int x){
        data = x;
        right = NULL;
        left = NULL;
    }
};

void inorder(Node* root, int &k, int &sum){
    if(root == NULL){
        return;
    }
    
    inorder(root->left, k, sum);
    if(k > 0){
         k--;
        sum += root->data;
    }
    inorder(root->right, k, sum);
}
    
int sum(Node* root, int k) 
{ 
    int sum = 0;
    inorder(root, k, sum);
    return sum;
} 