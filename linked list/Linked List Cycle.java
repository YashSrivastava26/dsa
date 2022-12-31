class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}
//using recursion to change value first and when returning reassigning it
// class Solution {
//     public boolean hasCycle(ListNode head) {
//         if(head == null) return false;
        
//         if(head.val == 1e8) return true;
//         int temp = head.val;
//         head.val = (int)1e8;
//         boolean isCycle = hasCycle(head.next);
//         head.val = temp;
//         return isCycle;
//     }
// }

//using fast and slow ptr
class Solution {
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null) return false;
        ListNode slowPtr = head, fastPtr = head;

        while(fastPtr.next != null && fastPtr.next.next != null){
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;
            if(slowPtr == fastPtr) return true;
        }
        return false;
    }
}