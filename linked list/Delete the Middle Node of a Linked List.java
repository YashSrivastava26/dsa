class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
class Solution {
    public ListNode deleteMiddle(ListNode head) {
        ListNode fast = head, slow = head, prev = null;

        while(fast != null && fast.next != null){
            fast = fast.next.next;
            prev = slow;
            slow = slow.next;
        }

        if(prev == null){
            head = head.next;
        }
        else{
            prev.next = slow.next;
        }
        return head;
    }
}