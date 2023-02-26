#include<bits/stdc++.h>
using namespace std;


class Solution {
  private:
    bool isOperand(char ch){
        if((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z') || (ch >= '0' && ch <= '9')){
            return true;
        }
        return false;
    }
  public:
    string preToInfix(string s) {
        stack<string> st;
        int n = s.length();
        
        for(int i = n - 1; i >= 0; i--){
            if(isOperand(s[i])){
                string temp;
                temp += s[i];
                st.push(temp);
            }
            else{
                string first = st.top();
                st.pop();
                string second = st.top();
                st.pop();
                
                st.push('(' + first + s[i] + second + ')');
            }
        }
        
        return st.top();
        
    }
};