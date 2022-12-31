class Node {
    int data;
    Node next;
    Node prev;

    Node(int x) {
        data = x;
        next = null;
        prev= null;
    }

}

class Solution {
    Node constructDLL(int arr[]) {
        Node head = null, prevNode = null;
        int n = arr.length;
        
        for(int i = 0; i < n; i++){
            Node currNode = new Node(arr[i]);
            if(i == 0){
                head = currNode;
            }
            else{
                currNode.prev = prevNode;
                prevNode.next = currNode;
            }
            prevNode = currNode;
        }
        return head;
    }
}