#include<bits/stdc++.h>
using namespace std;


struct Node
{
    int data;
    Node* left;
    Node* right;
};

class Solution {
  public:
    vector <int> bottomView(Node *root) {
        map<int, int> nodeAtX;
        queue<pair<int, Node*>> q;
        q.push({0, root});
        
        while(!q.empty()){
            auto curr = q.front();
            q.pop();
            int VerticalCord = curr.first;
            
            nodeAtX[VerticalCord] = curr.second->data;
            
            if(curr.second->left){
                q.push({VerticalCord - 1, curr.second->left});
            }
            if(curr.second->right){
                q.push({VerticalCord + 1, curr.second->right});
            }
        }
        
        vector<int> ans;
        for(auto it : nodeAtX){
            ans.push_back(it.second);
        }
        return ans;
    }
};