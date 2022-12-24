
class Node{
    int data;
    Node next;
    
    Node(int x){
        data = x;
        next = null;
    }
}
class Solution
{
    //Function to insert a node at the beginning of the linked list.
    Node insertAtBeginning(Node head, int x)
    {
        Node firstNode = new Node(x);
        firstNode.next = head;
        head = firstNode;
        return head;
    }
    
    //Function to insert a node at the end of the linked list.
    Node insertAtEnd(Node head, int x)
    {
        Node itr = head;
        Node lastNode = new Node(x);
        lastNode.next =null;
        
        if(head == null) {
            return head = lastNode;
        }
        while(itr.next != null){
            itr = itr.next;
        }
        
        
        itr.next = lastNode;
        return head;
    }
}