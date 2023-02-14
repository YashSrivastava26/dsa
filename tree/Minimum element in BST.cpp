#include <bits/stdc++.h>
using namespace std;

struct Node {
    int data;
    struct Node* left;
    struct Node* right;
};

int minValue(Node* root) {
    Node* curr = root;
    int min = -1;
    while(curr != NULL){
        min = curr->data;;
        curr = curr->left;
    }
    return min;
}
