#include<bits/stdc++.h>
using namespace std;

class Solution {
public:
    vector<int> asteroidCollision(vector<int>& asteroids) {
        stack<int> monotonic;
        int n = asteroids.size();
        
        for(int i = 0; i < n; i++){
            if(asteroids[i] > 0){
                monotonic.push(asteroids[i]);
            }
            else{
                while(!monotonic.empty() && monotonic.top() < abs(asteroids[i]) && monotonic.top() > 0){
                    monotonic.pop();
                }

                bool isDestroyed = false;
                // if(monotonic.empty() || monotonic.top() < 0){
                //     isDestroyed = false;
                // }
                if(!monotonic.empty() && monotonic.top() >= abs(asteroids[i]) && monotonic.top() > 0){
                    isDestroyed = true;
                    if(monotonic.top() == abs(asteroids[i])){
                        monotonic.pop();
                    }
                }

                if(isDestroyed == false){
                    monotonic.push(asteroids[i]);
                }
            }
        }

        int m = monotonic.size();
        vector<int> ans(m);
        for(int i = m - 1; i >= 0; i--){
            ans[i] = monotonic.top();
            monotonic.pop();
        }
        return ans;
    }
};