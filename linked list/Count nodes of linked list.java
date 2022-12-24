
class Node{
    int data;
    Node next;
    Node(int a){  data = a; next = null; }
}

class Solution
{
    //Function to count nodes of a linked list.
    public static int getCount(Node head)
    {
        
        Node itr = head;
        int numNode = 0;
        
        while(itr != null){
            numNode++;
            itr = itr.next;
        }
        return numNode;
    }
}