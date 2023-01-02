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
    public static Node addOne(Node head) 
    {
        Node dummy = new Node(0);
        Node itr = head, last_not_9 = dummy;
        dummy.next = head;
        while(itr != null){
            if(itr.data != 9){
                last_not_9 = itr;
            }
            itr = itr.next;
        }
        while(last_not_9 != null){
            last_not_9.data = (last_not_9.data + 1) % 10;
            last_not_9 = last_not_9.next;
        }
        if(dummy.data != 0){
            return dummy;
        }
        return dummy.next;
    }
}