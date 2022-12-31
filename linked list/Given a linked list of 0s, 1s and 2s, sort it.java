class Node
{
    int data;
    Node next;
    Node(int data)
    {
        this.data = data;
        next = null;
    }
}

class Solution
{
    //Function to sort a linked list of 0s, 1s and 2s.
    static Node segregate(Node head)
    {
        Node zeroStart = new Node(-1);
        Node oneStart = new Node(-1);
        Node twoStart = new Node(-1);
        Node zeroEnd = zeroStart, oneEnd = oneStart, twoEnd = twoStart, itr = head;
        
        while(itr != null){
            Node next = itr.next;
            if(itr.data == 0){
                itr.next = null;
                zeroEnd.next = itr;
                zeroEnd = zeroEnd.next;
            }
            else if(itr.data == 1){
                itr.next = null;
                oneEnd.next = itr;
                oneEnd = oneEnd.next;
            }
            else{
                itr.next = null;
                twoEnd.next = itr;
                twoEnd = twoEnd.next;
            }
            itr = next;
        }
        
        oneEnd.next = twoStart.next;
        zeroEnd.next = oneStart.next;
        return zeroStart.next;
    }
}