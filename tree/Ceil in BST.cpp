#include <bits/stdc++.h>
using namespace std;

struct Node {
    int data;
    struct Node* left;
    struct Node* right;
};

int findCeil(Node* root, int input) {
    if (root == NULL) return -1;
    Node* curr = root;
    
    int ceil = -1;
    while(curr != NULL){
        if(curr->data == input){
            return input;
        }
        else if(curr->data > input){
            ceil = curr->data;
            curr = curr->left;
        }
        else{
            curr = curr->right;
        }
    }
    return ceil;
}