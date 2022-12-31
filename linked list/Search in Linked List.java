class Node {
   int data;
    Node next;
    Node(int d)  { data = d;  next = null; }
}
class Solution {
    static boolean searchKey(int n, Node head, int key) {
        Node itr = head;
        
        while(itr != null){
            if(itr.data == key){
                return true;
            }
            itr = itr.next;
        }
        return false;
    }
}