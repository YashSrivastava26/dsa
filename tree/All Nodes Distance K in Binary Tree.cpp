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
public:
    vector<int> distanceK(TreeNode* root, TreeNode* target, int k) {
        unordered_map<TreeNode*, TreeNode*> parent;
        queue<TreeNode*> q;
        q.push(root);
        parent[root] = NULL;


        while(!q.empty()){
            TreeNode* curr = q.front();
            q.pop();

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
        vector<int> ans;
        unordered_set<TreeNode*> vis;
        q.push(target);
        vis.insert(target);
        
        while(k >= 0){
            int n = q.size();

            for(int i = 0; i < n; i++){
                TreeNode* curr = q.front();
                q.pop();

                if(k == 0){
                    ans.push_back(curr->val);
                }
                else{           
                    if(parent[curr] != NULL && vis.find(parent[curr]) == vis.end()){
                        vis.insert(parent[curr]);
                        q.push(parent[curr]);
                    }
                    if(curr->left != NULL && vis.find(curr->left) == vis.end()){
                        vis.insert(curr->left);
                        q.push(curr->left);
                    }
                    if(curr->right != NULL && vis.find(curr->right) == vis.end()){
                        vis.insert(curr->right);
                        q.push(curr->right);
                    }
                }
            }
            k--;
        }

        return ans;
    }
};