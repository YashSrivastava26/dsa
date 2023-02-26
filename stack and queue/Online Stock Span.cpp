#include<bits/stdc++.h>
using namespace std;

class StockSpanner {
private:
    stack<pair<int, int>> increasing;
    int idx;
public:
    StockSpanner() {
        idx = 0;
    }
    
    int next(int price) {
        int spanStart;

        while(!increasing.empty() && increasing.top().first <= price){
            increasing.pop();
        }

        if(increasing.empty()){
            spanStart = 0;
        }
        else{
            spanStart = increasing.top().second + 1;
        }

        increasing.push({price, idx});
        int ans = idx - spanStart + 1;
        idx++;

        return ans;
    }
};