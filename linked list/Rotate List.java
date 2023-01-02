class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
class Solution {
    private int lengthOfList(ListNode head){
        ListNode itr = head;
        int n = 0;
        while(itr != null){
            itr = itr.next;
            n++;
        }
        return n;
    }

    private ListNode joinAtStart(ListNode slow, ListNode tail, ListNode head){
        ListNode newHead = slow.next;
        slow.next = null;
        tail.next = head;
        return newHead;
    }

    public ListNode rotateRight(ListNode head, int k) {
        if(head == null) return head;
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode fast = dummy, slow = dummy, tail = null;
        int n = lengthOfList(head);
        k = k % n; 
        if(k == 0) return head;

        for(int i = 0; i <= k; i++){
            fast = fast.next;
        }

        while(fast != null){
            if(fast.next == null){
                tail = fast;
            }
            fast = fast.next;
            slow = slow.next;
        }
        return joinAtStart(slow, tail, head);
    }
}