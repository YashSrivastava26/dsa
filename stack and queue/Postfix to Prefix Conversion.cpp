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
    string postToPre(string s) {
        stack<string> st;
        int n = s.length();
        
        for(int i = 0; i < n; i++){
            if(isOperand(s[i])){
                string temp;
                temp += s[i];
                st.push(temp);
            }
            else{
                string second = st.top();
                st.pop();
                string first = st.top();
                st.pop();
                
                st.push(s[i] + first + second);
            }
        }
        
        return st.top();
    }
};