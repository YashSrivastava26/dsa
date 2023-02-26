#include <bits/stdc++.h>
using namespace std;

class Solution {
private:
    bool isPair(char ch1, char ch2){
        if((ch1 == '[' && ch2 == ']') || (ch1 == '{' && ch2 == '}') || (ch1 == '(' && ch2 == ')')){
            return true;
        }
        return false;
    }
public:
    bool isValid(string s) {
        stack<char> st;
        int n = s.length();

        for(int i = 0; i < n; i++){
            if(s[i] == '{' || s[i] == '[' || s[i] == '('){
                st.push(s[i]);
            }
            else{
                char stTop = ' ';
                if(st.size() != 0){
                    stTop = st.top();
                }
                st.pop();

                if(!isPair(stTop, s[i])){
                    return false;
                }
            }
        }

        if(st.empty()){
            return true;
        }
        return false;
    }
};