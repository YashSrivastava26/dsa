#include<bits/stdc++.h>
using namespace std;

struct ListNode {
    int val;
    ListNode *next;
    ListNode() : val(0), next(nullptr) {}
    ListNode(int x) : val(x), next(nullptr) {}
    ListNode(int x, ListNode *next) : val(x), next(next) {}
};

class Solution {
public:
    ListNode* swapPairs(ListNode* head) {
        if(head == NULL || head->next == NULL){
            return head;
        }
        ListNode *itr = head, *prev = NULL;
        while(itr != NULL && itr->next != NULL){
            ListNode *nextPair = itr->next->next;
            ListNode *firstNode = itr, *secondNode = itr->next; 

            secondNode->next = firstNode;
            firstNode->next = nextPair;
            if(prev == NULL){
                head = secondNode;
            }
            else{
                prev->next = secondNode;
            }

            prev = firstNode;
            itr = nextPair;
        }
        return head;
    }
};