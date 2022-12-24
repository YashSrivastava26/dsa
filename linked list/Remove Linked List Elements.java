
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
class Solution {
    public ListNode removeElements(ListNode head, int value) {
        ListNode itr = head;
        ListNode prevNode = null;
        if(head == null) return null;

        while(itr != null){
            if(itr.val == value && prevNode == null){
                head = itr.next;
                itr.next = null;
                itr = head;
            }
            else if(itr.val == value){
                prevNode.next = itr.next;
                itr.next = null;
                itr = prevNode.next;
            }
            else {
                prevNode = itr;
                itr = itr.next;
            }
        }

        return head;
    }
}