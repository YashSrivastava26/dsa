#include <bits/stdc++.h>
using namespace std;


// class Trie
// {
// private:
//     Trie *children[26];
//     bool isLeaf;

//     bool containsKey(char ch)
//     {
//         return children[ch - 'a'];
//     }

//     void put(char ch, Trie *child)
//     {
//         children[ch - 'a'] = child;
//     }

//     Trie* getChild(char ch)
//     {
//         return children[ch - 'a'];
//     }

//     void setLeaf(bool setVal){
//         isLeaf = setVal;
//     }

//     bool checkLeaf(){
//         return isLeaf;
//     }
// public:
//     Trie()
//     {
//         isLeaf = false;
//         for (int i = 0; i < 26; i++)
//         {
//             children[i] = NULL;
//         }
//     }

//     void insert(string word)
//     {
//         int n = word.length();
//         Trie *node = this;
//         for (int i = 0; i < n; i++)
//         {
//             if (!node->containsKey(word[i]))
//             {
//                 node->put(word[i], new Trie());
//             }
//             node = node->getChild(word[i]);
//         }

//         node->setLeaf(true);
//     }

//     bool checkAllPrefix(string word)
//     {
//         Trie *node = this;
//         int n = word.length();
//         // cout<<word<<"\n";

//         for (int i = 0; i < n; i++)
//         {
            
//             node = node->getChild(word[i]);
//             if(!node->checkLeaf()){
//                 return false;
//             }
//         }
//         return node->checkLeaf();
//     }
// };


// string getLexograpicSmallest(string s, string p){
//     int n = s.length();
//     for(int i = 0; i < n; i++){
//         if(s[i] == p[i]){
//             continue;
//         }

//         else if(s[i] < p[i]){
//             return s;
//         }
//         else{
//             return p;
//         }
//     }
//     return s;
// }

// string completeString(int n, vector<string> &a){
//     Trie* root = new Trie();
    
//     for(int i = 0; i < n; i++){
//         root->insert(a[i]);
//     }
//     int maxLen = 0;
//     string ans = "None";

//     for(int i = 0; i < n; i++){
//         int m = a[i].length();

//         if(root->checkAllPrefix(a[i])){
//             if(maxLen < m){
//                 maxLen = m;
//                 ans = a[i];
//             }

//             else if(maxLen == m){
//                 ans = getLexograpicSmallest(ans, a[i]);
//             }
//         }
//     }

//     return ans;
// }

// for leographic use compare rather than user define function.

class Trie
{
private:
    Trie *children[26];
    bool isLeaf;

    bool containsKey(char ch)
    {
        return children[ch - 'a'];
    }

    void put(char ch, Trie *child)
    {
        children[ch - 'a'] = child;
    }

    Trie* getChild(char ch)
    {
        return children[ch - 'a'];
    }

    void setLeaf(bool setVal){
        isLeaf = setVal;
    }

    bool checkLeaf(){
        return isLeaf;
    }
public:
    Trie()
    {
        isLeaf = false;
        for (int i = 0; i < 26; i++)
        {
            children[i] = NULL;
        }
    }

    void insert(string word)
    {
        int n = word.length();
        Trie *node = this;
        for (int i = 0; i < n; i++)
        {
            if (!node->containsKey(word[i]))
            {
                node->put(word[i], new Trie());
            }
            node = node->getChild(word[i]);
        }

        node->setLeaf(true);
    }

    bool checkAllPrefix(string word)
    {
        Trie *node = this;
        int n = word.length();
        // cout<<word<<"\n";

        for (int i = 0; i < n; i++)
        {
            
            node = node->getChild(word[i]);
            if(!node->checkLeaf()){
                return false;
            }
        }
        return node->checkLeaf();
    }
};

string completeString(int n, vector<string> &a){
    Trie* root = new Trie();
    
    for(int i = 0; i < n; i++){
        root->insert(a[i]);
    }
    int maxLen = 0;
    string ans = "None";

    for(int i = 0; i < n; i++){
        int m = a[i].length();

        if(root->checkAllPrefix(a[i])){
            if(maxLen < m){
                maxLen = m;
                ans = a[i];
            }

            else if(maxLen == m && a[i] < ans){
                ans = a[i];
            }
        }
    }

    return ans;
}