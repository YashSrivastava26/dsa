#include<bits/stdc++.h>
using namespace std;


class Solution {
  public:
    string postToInfix(string s) {
        int n = s.length();
        stack<string> st;
        for(int i = 0; i < n; i++){
            if((s[i] >= 'a' && s[i] <= 'z') || (s[i] >= 'A' && s[i] <= 'Z') || (s[i] >= '0' && s[i] <= '9')){
                string temp;
                temp += s[i];
                st.push(temp);
            }
            else{
                string second = st.top();
                st.pop();
                string first = st.top();
                st.pop();
                
                st.push('(' + first + s[i] + second + ')');
            }
        }
        return st.top();
    }
};