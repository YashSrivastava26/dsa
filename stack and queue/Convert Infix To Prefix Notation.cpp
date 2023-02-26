#include<bits/stdc++.h>
using namespace std;

class Solution {
  private:
    int pre(char ch){
        if(ch == '^'){
            return 3;
        }
        else if(ch == '*' || ch == '/'){
            return 2;
        }
        else if(ch == '+' || ch == '-'){
            return 1;
        }
        else{
            return 0;
        }
    }
  public:
    string infixToPrefix(string s) {
        stack<char> st;
        int n = s.length();
        string preFix;
        
        for(int i = n - 1; i >= 0; i--){
            char ch = s[i];
            
            if( (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z') || (ch >= '0' && ch <= '9') ){
                preFix += ch;
            }
            else if(ch == ')'){
                st.push(ch);
            }
            else if(ch == '('){
                while(st.top() != ')'){
                    preFix += st.top();
                    st.pop();
                }
                st.pop();
            }
            else{
                while(!st.empty() && (pre(ch) < (pre(st.top())) || (ch == '^' && pre(ch) <= pre(st.top()))) ){
                    preFix += st.top();
                    st.pop();
                }
                st.push(ch);
            }
        }
        
        while(!st.empty()){
            preFix += st.top();
            st.pop();
        }

        reverse(preFix.begin(), preFix.end());
        return preFix;
    }
};