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
        vector<vector<int>> verticalTraversal(TreeNode* root) {
            map<int, map<int, multiset<int>>> corrd;
            queue<pair<TreeNode*, pair<int, int>>> q;
            q.push({root, {0, 0}});
    
            while(!q.empty()){
                auto curr = q.front();
                q.pop();
    
                TreeNode* currNode = curr.first;
                int x = curr.second.first, y = curr.second.second;
                corrd[x][y].insert(currNode->val);
    
                if(currNode->left){
                    q.push({currNode->left, {x - 1, y + 1}});
                }
                if(currNode->right){
                    q.push({currNode->right, {x + 1, y + 1}});
                }
            }
            vector<vector<int>> ans;
    
            for(auto it : corrd){
                vector<int> col;
    
                for(auto itr : it.second){
                    col.insert(col.end(), itr.second.begin(), itr.second.end());
                }
                ans.push_back(col);
            }
            return ans;
        }
    };