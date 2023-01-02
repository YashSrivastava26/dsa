class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode ansHead = null, ansEnd = ansHead;
        ListNode itr1 = l1, itr2 = l2;
        while(itr1 != null || itr2 != null || carry != 0){
            int digit1 = itr1 == null ? 0 : itr1.val;
            int digit2 = itr2 == null ? 0 : itr2.val;
            int digit = (digit1 + digit2 + carry) % 10;
            carry = (digit1 + digit2 + carry) / 10;
            
            if(ansHead == null){
                ListNode newNode = new ListNode(digit);
                ansHead = newNode;
                ansEnd = ansHead;
            }
            else{
                ListNode newNode = new ListNode(digit);
                ansEnd.next = newNode;
                ansEnd = newNode;
            }
            if(itr1 != null){
                itr1 = itr1.next;
            }
            if(itr2 != null){
                itr2 = itr2.next;
            }
        }
        // if(carry != 0){
        //     ListNode newNode = new ListNode(carry);
        //     ansEnd.next = newNode;
        //     ansEnd = newNode;
        // }
        return ansHead;
    }
}