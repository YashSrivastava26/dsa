class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode grpEnd = head, curr = head, prevGrpEnd = null, newHead = null;

        while(grpEnd != null){
            boolean grpComplete = false;
            int i = 0;
            for(; i < k; i++){
                if(grpEnd == null){
                    break;
                }
                else{
                    grpEnd = grpEnd.next;
                }
            }
            if(i == k){
                grpComplete = true;
            }

            if(grpComplete){
                ListNode prev = null, start = curr;
                while(curr != grpEnd){
                    ListNode nextNode = curr.next;
                    curr.next = prev;
                    prev = curr;
                    curr = nextNode;
                }
                if(prevGrpEnd != null){
                    prevGrpEnd.next = prev;
                }
                else{
                    newHead = prev;
                }
                prevGrpEnd = start;
            }
            else{
                prevGrpEnd.next = curr;
            }
        }
        return newHead;
    }
}