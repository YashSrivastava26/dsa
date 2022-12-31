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
    //Function to insert a new node at given position in doubly linked list.
    void addNode(Node head, int pos, int data)
	{
		Node itr = head;
		Node insertNode = new Node(data);
		
		while(itr != null){
		    if(pos == 0){
		        insertNode.next = itr.next;
		        itr.next = insertNode;
		        insertNode.prev = itr;
		        break;
		    }
		    pos--;
		    itr = itr.next;
		}
		
	}
}