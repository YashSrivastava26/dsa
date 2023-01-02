import java.util.*;
class Node 
{
    int data;
    Node next;
    
    Node(int a)
        {
            data = a;
            next = null;
        }
}


class Solution
{
    public static Node findIntersection(Node headA, Node headB)
    {
        Set < Integer > nodeVal = new HashSet<>();
        Node itr = headB;
        
        while(itr != null){
            nodeVal.add(itr.data);
            itr = itr.next;
        }
        itr = headA;
        headA = null;
        Node endAns = headA;
        while(itr != null){
            Node next = itr.next;
            if(nodeVal.contains(itr.data) && headA == null){
                headA = itr;
                endAns = headA;
                itr.next = null;
            }
            else if(nodeVal.contains(itr.data) && headA != null){
                endAns.next = itr;
                itr.next = null;
                endAns = endAns.next;
            }
            itr = next;
        }
         return headA;
    }
}