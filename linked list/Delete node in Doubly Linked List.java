class Node
{
	int data;
	Node next;
	Node prev;
	Node(int d)
	{
		data = d;
		next = prev = null;
	}
}

class Solution
{
    // function returns the head of the linkedlist
    Node deleteNode(Node head,int x)
    {
	    Node itr = head;
	    while(x != 1 && itr != null){
	        itr = itr.next;
	        x--;
	    }
	    if(itr.prev != null){
	        itr.prev.next = itr.next;
	        if(itr.next != null) {
	            itr.next.prev = itr.prev;
	        }
	    }
	    else{
	        head = itr.next;
	    }
	    itr.next = null;
        itr.prev = null;
	    return head;
	    
    }
}
