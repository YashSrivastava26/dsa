import java.util.*;
class Node {
    int data;
    Node left, right;
   Node(int item)    {
        data = item;
        left = right = null;
    }
} 

class Tree
{
    private void postorder(Node root, ArrayList<Integer> ans){
        if(root == null){
            return;
        }
        postorder(root.left, ans);
        postorder(root.right, ans);
        ans.add(root.data);
    }
    
    //Function to return a list containing the postorder traversal of the tree.
    ArrayList<Integer> postOrder(Node root)
    {
        ArrayList<Integer> ans = new ArrayList<>();
        postorder(root, ans);
        return ans;
    }
}