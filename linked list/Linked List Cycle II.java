class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

// class Solution {
//    public ListNode detectCycle(ListNode head) {
//        if(head == null) return null;
//        if(head.val == 1e8) return head;

//        int temp = head.val;
//        head.val = (int) 1e8;
//        ListNode cycleStart = detectCycle(head.next);

//        head.val = temp;
//        return cycleStart;
//    }
// }


//TC = O(n) --> using fast and slow ptr and then entry ptr
class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head == null) return null;

        ListNode slow = head, fast = head;
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) break;
        }

        if(fast.next == null || fast.next.next == null) return null;
        ListNode entry = head;

        while(entry != slow){
            slow = slow.next;
            entry = entry.next;
        }
        return slow;
    }
}