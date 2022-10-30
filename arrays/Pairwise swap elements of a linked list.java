// node class of the linked list

class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}



//recursive solution
// class Solution {
//     // Function to pairwise swap elements of a linked list.
//     // It should returns head of the modified list
//     public Node pairwiseSwap(Node head)
//     {
//         if(head == null || head.next == null) return head;
//         Node nextFirst =  pairwiseSwap(head.next.next);
//         head.next.next = head;
//         Node currFirst =  head.next;
//         head.next = nextFirst;
//         return currFirst;
        
//     }
// }


//iterative solution
class Solution {
    // Function to pairwise swap elements of a linked list.
    // It should returns head of the modified list
    public Node pairwiseSwap(Node head)
    {
        Node prev = null, a = head, b, c;

        while(a != null && a.next != null){
            b = a.next;
            c = b.next;

            if(a == head)
                head = b;
            else
                prev.next = b;
             
            a.next = c;
            b.next = a;
            prev = a;
            a = c;
        }
        return head;
    }
}