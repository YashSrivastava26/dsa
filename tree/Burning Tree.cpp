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
  public:
    int minTime(Node* root, int target) 
    {
        unordered_map<Node*, Node*> parent;
        queue<Node*> q;
        q.push(root);
        parent[root] = NULL;
        Node* targ = NULL;

        while(!q.empty()){
            Node* curr = q.front();
            q.pop();
            
            if(curr->data == target){
                targ = curr;
            }
            if(curr->left){
                parent[curr->left] = curr;
                q.push(curr->left);
            }

            if(curr->right){
                parent[curr->right] = curr;
                q.push(curr->right);
            }
        }
        
        //finding k dist node
        int k = 0;
        unordered_set<Node*> vis;
        q.push(targ);
        vis.insert(targ);
        
        while(!q.empty()){
            int n = q.size();

            for(int i = 0; i < n; i++){
                Node* curr = q.front();
                q.pop();

                if(curr->left != NULL && vis.find(curr->left) == vis.end()){
                    vis.insert(curr->left);
                    q.push(curr->left);
                }
                if(curr->right != NULL && vis.find(curr->right) == vis.end()){
                    vis.insert(curr->right);
                    q.push(curr->right);
                }
                if(parent[curr] != NULL && vis.find(parent[curr]) == vis.end()){
                    vis.insert(parent[curr]);
                    q.push(parent[curr]);
                }
            }
            k++;
        }
        return k - 1;
    }
};