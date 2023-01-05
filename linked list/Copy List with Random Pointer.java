class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) return null;
        Node itr = head;

        while(itr != null){
            Node nextNode = itr.next;
            itr.next = new Node(itr.val);
            itr.next.next = nextNode;
            itr = nextNode;
        }

        itr = head;
        while(itr != null){
            itr.next.random = itr.random == null ? null : itr.random.next;
            itr = itr.next.next;
            
        }

        Node newHead = null, tailNew = null;
        itr = head;
        while(itr != null){
            Node nextCopy = itr.next, nextOriginal = itr.next.next;
            //removing deep copy from LL
            if(newHead == null){
                newHead = nextCopy;
            }
            else {
                tailNew.next = nextCopy;
            }
            tailNew = nextCopy;

            //Making Original back as it was
            itr.next = nextOriginal;
            itr = nextOriginal;
        }
        return newHead;
    }
}