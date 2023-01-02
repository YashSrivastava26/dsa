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

class GfG
{
    void removeDuplicates(Node head)
	{
		if(head == null || head.next == null) return;
		Node itr = head.next;
		while(itr != null){
		    Node nextNode = itr.next;
		    if(itr.data == itr.prev.data){
		        itr.prev.next = itr.next;
		        if(itr.next != null){
		            itr.next.prev = itr.prev;
		        }
		        itr.next = null;
		        itr.prev = null;
		    }
		    itr = nextNode;
		}
	}
}