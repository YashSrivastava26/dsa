#include <bits/stdc++.h>
using namespace std;

class Trie{
    private:

    Trie* children[26];
    int countLeaf;
    int countPrefix;

    bool containsKey(char ch){
        return children[ch -'a'];
    }

    void put(char ch, Trie* child){
        children[ch - 'a'] = child;
    }

    void increasePrefix(){
        countPrefix++;
    }

    void increaseLeaf(){
        countLeaf++;
    }

    void decreasePrefix(){
        countPrefix--;
    }

    void decreaseLeaf(){
        countLeaf--;
    }

    Trie* getChild(char ch){
        return children[ch - 'a'];
    }

    int getLeaf(){
        return countLeaf;
    }

    int getPrefix(){
        return countPrefix;
    }
    public:

    Trie(){
        countLeaf = 0;
        countPrefix = 0;
        for(int i = 0; i < 26; i++){
            children[i] = NULL;
        }
    }

    void insert(string &word){
        int n = word.length();
        Trie* curr = this;

        for(int i = 0; i < n; i++){
            if(!curr->containsKey(word[i])){
                curr->put(word[i], new Trie());
            }
            curr = curr->getChild(word[i]);
            curr->increasePrefix();
        }

        curr->increaseLeaf();
    }

    int countWordsEqualTo(string &word){
        int n = word.length();
        Trie* curr = this;

        for(int i = 0; i < n; i++){
            if(!curr->containsKey(word[i])){
                return 0;
            }
            curr = curr->getChild(word[i]);
        }

        return curr->getLeaf();
    }

    int countWordsStartingWith(string &word){
        int n = word.length();
        Trie* curr = this;

        for(int i = 0; i < n; i++){
            if(!curr->containsKey(word[i])){
                return 0;
            }
            curr = curr->getChild(word[i]);
        }

        return curr->getPrefix();
    }

    void erase(string &word){
        int n = word.length();
        Trie* curr = this;

        for(int i = 0; i < n; i++){
            curr = curr->getChild(word[i]);
            curr->decreasePrefix();
        }

        curr->decreaseLeaf();
    }
};