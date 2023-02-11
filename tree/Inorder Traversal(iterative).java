import java.util.*;
class Node {
    int data;
    Node left, right;
   Node(int item)    {
        data = item;
        left = right = null;
    }
} 
class Solution {
    // Function to return a list containing the inorder traversal of the tree.
    ArrayList<Integer> inOrder(Node root) {
        ArrayList<Integer> ans = new ArrayList<>();
        Deque<Node> stack = new LinkedList<>();
        Node curr = root;
        while(true){
            if(curr != null){
                stack.add(curr);
                curr = curr.left;
            }
            else if(!stack.isEmpty()){
                curr = stack.pollLast();
                ans.add(curr.data);
                curr = curr.right;
            }
            else{
                break;
            }
        }
        return ans;
    }
}