class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

//using floydd cycle detection
// class Solution {
//     public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//         ListNode itr = headA;

//         while(itr.next != null){
//             itr = itr.next;
//         }
        
//         itr.next = headA;

//         ListNode slow = headB, fast = headB;

//         while(fast != null && fast.next != null){
//             fast = fast.next.next;
//             slow = slow.next;
            
//             if(slow == fast) {
//                 break;
//             }
//         }
//         if(fast == null || fast.next == null) {
//             itr.next = null;
//             return null;
//         }

//         ListNode entry = headB;
//         while(entry != slow){
//             entry = entry.next;
//             slow = slow.next;
//         }
//         itr.next = null;
//         return entry;
//     }
// }

//using diff in length
class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode itr1 = headA, itr2 = headB;

        while(itr1 != itr2){
            if(itr1 == null) {
                itr1 = headB;
            }
            else{
                itr1 = itr1.next;
            }
            if(itr2 == null) {
                itr2 = headA;
            }
            else{
                itr2 = itr2.next;
            }
        }
        return itr1;
    }
}