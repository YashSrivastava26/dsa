
class Node { 
    int data; 
    Node next; 

    Node() { data = 0; }
    Node(int d) { data = d; }  //constructor to create a new node
} 
class Solution {
    static Node constructLL(int arr[]) {
        int n = arr.length;
        Node head = null;
        Node prevNode = new Node();
        
        for(int i = 0; i < n; i++){
            Node currNode = new Node(arr[i]);
            if(i == 0){
                head = currNode;
            }
            else{
                prevNode.next = currNode;
            }
            prevNode = currNode;
        }
        return head;
    }
}
