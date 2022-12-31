import java.util.HashSet;
import java.util.Set;

class Node
{
    int data;
    Node next;
    
    Node(int x)
    {
        data = x;
        next = null;
    }
}

class Solution {
    //Function to find first node if the linked list has a loop.
    public static int findFirstNode(Node head){
        if(head == null || head.next == null) return -1;
        Set < Node > st = new HashSet<>();
        
        Node itr = head;
        
        while(itr != null){
            if(st.contains(itr)) {
                return itr.data;
            }
            st.add(itr);
            itr = itr.next;
            
        }
        return -1;
    }
}