#include <bits/stdc++.h>
using namespace std;

// O(2n) space 
// class MinStack {
// private:
//     vector<pair<int, int>> stack;
//     int topPtr;
// public:
//     MinStack() {
//         topPtr = -1;
//     }
    
//     void push(int val) {
//         int prev = INT_MAX;
//         if(topPtr != -1){
//             prev = stack[topPtr].second;
//         }
//         stack.push_back({val, min(val, prev)});
//         topPtr++;
//     }
    
//     void pop() {
//         topPtr--;
//         stack.pop_back();
//     }
    
//     int top() {
//         return stack[topPtr].first;
//     }
    
//     int getMin() {
//         // cout<<stack[topPtr].first<<" "<<stack[topPtr].second<<"\n";
//         return stack[topPtr].second;
//     }
// };

// O(n) space 
#define ll long long
class MinStack {
private:
    stack<ll> stack;
    ll mini;
public:
    MinStack() {
        mini = INT_MAX;
    }
    
    void push(int val) {
        ll value = val;

        if(stack.empty()){
            stack.push(value);
            mini = value;
        }
        else{
            if(value < mini){
                ll modVal = (2 * value) - mini;
                mini = value;
                stack.push(modVal);
            }
            else{
                stack.push(value);
            }
        }
    }
    
    void pop() {
        ll val = stack.top();
        stack.pop();

        if(val < mini){
            mini = 2 * mini - val;
        }
    }
    
    int top() {
        ll val = stack.top();
        if(val < mini){
            return mini;
        }
        return val;
    }
    
    int getMin() {
        return mini;
    }
};
