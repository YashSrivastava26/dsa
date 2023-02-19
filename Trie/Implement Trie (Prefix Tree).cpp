#include <bits/stdc++.h>
using namespace std;

// struct Node{
//     Node* links[26];
//     bool flag = false;
// };

// class Trie {
// private: Node* root;
// public:
//     Trie() {
//         root = new Node();
//     }

//     void insert(string word) {
//         int n = word.length();
//         Node* node = root;
//         for(int i = 0; i < n; i++){
//             if(node->links[word[i] - 'a'] == NULL){
//                 node->links[word[i] - 'a'] = new Node();
//             }
//             node = node->links[word[i] - 'a'];
//         }

//         node->flag = true;
//     }

//     bool search(string word) {
//         Node* node = root;
//         int n = word.length();

//         for(int i = 0; i < n; i++){
//             if(node->links[word[i] - 'a'] != NULL){
//                 node = node->links[word[i] - 'a'];
//             }
//             else{
//                 return false;
//             }
//         }

//         return node->flag;
//     }

//     bool startsWith(string prefix) {
//         Node* node = root;
//         int n = prefix.length();

//         for(int i = 0; i < n; i++){
//             if(node->links[prefix[i] - 'a'] != NULL){
//                 node = node->links[prefix[i] - 'a'];
//             }
//             else{
//                 return false;
//             }
//         }
//         return true;
//     }
// };

// class Trie {
// private: Trie* children[26];
//          bool isLeaf;
// public:
//     Trie() {
//         isLeaf = false;
//         for(int i = 0; i < 26; i++){
//             children[i] = NULL;
//         }
//     }

//     void insert(string word) {
//         int n = word.length();
//         Trie* node = this;
//         for(int i = 0; i < n; i++){
//             if(node->children[word[i] - 'a'] == NULL){
//                 node->children[word[i] - 'a'] = new Trie();
//             }
//             node = node->children[word[i] - 'a'];
//         }

//         node->isLeaf = true;
//     }

//     bool search(string word) {
//         Trie* node = this;
//         int n = word.length();

//         for(int i = 0; i < n; i++){
//             if(node->children[word[i] - 'a'] != NULL){
//                 node = node->children[word[i] - 'a'];
//             }
//             else{
//                 return false;
//             }
//         }

//         return node->isLeaf;
//     }

//     bool startsWith(string prefix) {
//         Trie* node = this;
//         int n = prefix.length();

//         for(int i = 0; i < n; i++){
//             if(node->children[prefix[i] - 'a'] != NULL){
//                 node = node->children[prefix[i] - 'a'];
//             }
//             else{
//                 return false;
//             }
//         }
//         return true;
//     }
// };

// inerviewStandard
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

    bool search(string word)
    {
        Trie *node = this;
        int n = word.length();

        for (int i = 0; i < n; i++)
        {
            if (node->containsKey(word[i]))
            {
                node = node->children[word[i] - 'a'];
            }
            else
            {
                return false;
            }
        }

        return node->checkLeaf();
    }

    bool startsWith(string prefix)
    {
        Trie *node = this;
        int n = prefix.length();

        for (int i = 0; i < n; i++)
        {
            if (node->containsKey(prefix[i]))
            {
                node = node->getChild(prefix[i]);
            }
            else
            {
                return false;
            }
        }
        return true;
    }
};
