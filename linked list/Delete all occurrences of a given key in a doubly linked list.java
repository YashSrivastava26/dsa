class Node
{
	int data;
	Node next;
	Node prev;
	Node(int data)
	{
	    this.data = data;
	    next = prev = null;
	}
}
class Solution {
    static Node deleteAllOccurOfX(Node head, int x) {
        Node prevNode = null, itr = head;
        
        while(itr != null){
            Node nextNode = itr.next;
            if(itr.data == x){
                if(prevNode != null){
                    prevNode.next = itr.next;
                }
                else{
                    head = itr.next;
                }
                if(itr.next != null){
                    itr.next.prev = prevNode;
                }
                itr.prev = null;
                itr.next = null;
            }
            else{
                prevNode = itr;
            }
            itr = nextNode;
        }
        return head;
    }
}