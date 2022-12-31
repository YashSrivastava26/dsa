//my approach
// class ListNode {
//     int val;
//     ListNode next;
//     ListNode() {}
//     ListNode(int val) { this.val = val; }
//     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
// }
// class Solution {
//    public ListNode reverseList(ListNode head) {
//        ListNode itr = head, temp = null, initialFirst = head;
//        if(head == null || head.next == null) return head;
//        itr = itr.next;
       
//        while(itr != null){
//            temp = itr;
//            itr = itr.next;
//            temp.next = head;
//            initialFirst.next = itr;
//            head = temp;
//        }
//        return head;
//    }
// }

//recursive
// class ListNode {
//     int val;
//     ListNode next;
//     ListNode() {}
//     ListNode(int val) { this.val = val; }
//     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
// }

// class Solution {
//    public ListNode reverseList(ListNode head) {
//        if(head == null || head.next == null) return head;
   
//        ListNode newHead = reverseList(head.next);
   
//        ListNode nextNode = head.next;
//        nextNode.next = head;
//        head.next = null;
//        return newHead;
//    }
// }


//iterative
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode prev = null;
        
        while(head != null){
            ListNode nextNode = head.next;
            head.next = prev;
            prev = head;
            head = nextNode;
        }
        return prev;
    }
}