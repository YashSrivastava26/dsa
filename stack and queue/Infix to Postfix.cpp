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
    // Function to convert an infix expression to a postfix expression.
    string infixToPostfix(string s) {
        stack<char> st;
        int n = s.length();
        string postFix;
        
        for(int i = 0; i < n; i++){
            char ch = s[i];
            
            if( (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z') || (ch >= '0' && ch <= '9') ){
                postFix += ch;
            }
            else if(ch == '('){
                st.push(ch);
            }
            else if(ch == ')'){
                while(st.top() != '('){
                    postFix += st.top();
                    st.pop();
                }
                st.pop();
            }
            else{
                while(!st.empty() && pre(ch) <= pre(st.top()) ){
                    postFix += st.top();
                    st.pop();
                }
                st.push(ch);
            }
        }
        
        while(!st.empty()){
            postFix += st.top();
            st.pop();
        }
        return postFix;
    }
};