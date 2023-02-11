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
    static void travel(Node root, ArrayList<Integer> ans){
        if(root == null){
            return;
        }
        travel(root.left, ans);
        ans.add(root.data);
        travel(root.right, ans);
    }
    // Function to return a list containing the inorder traversal of the tree.
    ArrayList<Integer> inOrder(Node root) {
        ArrayList<Integer> ans = new ArrayList<>();
        travel(root, ans);
        return ans;
    }
}