class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null){
            return list2;
        }
        
        if(list2 == null){
            return list1;
        }


        ListNode itr1 = list1, itr2 = list2;
        ListNode headNode = null, prevNode = null;

        if(itr1.val <= itr2.val){
            headNode = itr1;
            prevNode = itr1;
            itr1 = itr1.next; 
        }
        else{
            headNode = itr2;
            prevNode = itr2;
            itr2 = itr2.next; 
        }


        while(itr1 != null && itr2 != null){
            if(itr1.val <= itr2.val){
                prevNode.next = itr1;
                prevNode = itr1;
                itr1 = itr1.next;
            }
            else{
                prevNode.next = itr2;
                prevNode = itr2;
                itr2 = itr2.next;
            }
        }


        while(itr1 != null){
            prevNode.next = itr1;
            prevNode = itr1;
            itr1 = itr1.next;
        }
        while(itr2 != null){
            prevNode.next = itr2;
            prevNode = itr2;
            itr2 = itr2.next;
        }

        return headNode;
    }
}