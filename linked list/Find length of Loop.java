
class Node
{
    int data;
    Node next;
    Node(int d) {data = d; next = null; }
}
//TC = O(n)
//SC = O(n)
// class Solution
// {
//     //Function to find the length of a loop in the linked list.
//     static int countNodesinLoop(Node head)
//     {
//         if(head == null) return 0;
        
//         HashMap < Node, Integer > idxMap = new HashMap<>();
//         Node itr = head;
//         int idx = 1;
        
//         while(itr != null){
//             if(idxMap.containsKey(itr)){
//                 return idx - idxMap.get(itr);
//             }
//             idxMap.put(itr, idx);
//             idx++;
//             itr = itr.next;
//         }
//         return 0;
//     }
// }

//TC = O(n)
//SC = O(1)
class Solution
{
    //Function to find the length of a loop in the linked list.
    static int countNodesinLoop(Node head)
    {
        if(head == null || head.next == null) return 0;
        
        Node slowPtr = head, fastPtr = head;
        
        while(fastPtr.next != null && fastPtr.next.next != null){
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;
            if(fastPtr == slowPtr) break;
        }
        
        if(fastPtr.next == null || fastPtr.next.next == null) return 0;
        
        int size = 1;
        fastPtr = fastPtr.next;
        while(fastPtr != slowPtr){
            fastPtr = fastPtr.next;
            size ++;
        }
        return size;
    }
}