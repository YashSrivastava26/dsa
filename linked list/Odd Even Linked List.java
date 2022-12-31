class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
//manuplating links
class Solution {

    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode oddEnd = head, evenStart = head.next, evenEnd = head.next;
        while(evenEnd != null && evenEnd.next != null){
            ListNode nextOdd = evenEnd.next;
            oddEnd.next = nextOdd;
            oddEnd = oddEnd.next;

            evenEnd.next = nextOdd.next;
            oddEnd.next = evenStart;
            evenEnd = evenEnd.next;
        }
        return head;
    }
}

//can be done by moving ptr to tail ans move even node at last 