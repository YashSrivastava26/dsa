import java.util.*;
class Node{
    int data;
    Node left,right;
    Node(int d){
        data=d;
        left=right=null;
    }
}

class BinaryTree
{
    //Function to return a list containing the preorder traversal of the tree.
    static ArrayList<Integer> preorder(Node root)
    {
        ArrayList<Integer> ans = new ArrayList<>();
        if(root == null){
            return ans;
        }
        Deque<Node> stack = new LinkedList<>();
        stack.add(root);
        while(!stack.isEmpty()){
            Node curr = stack.pollLast();
            ans.add(curr.data);
            if(curr.right != null){
                stack.add(curr.right);
            }
            
            if(curr.left != null){
                stack.add(curr.left);
            }
        }
        return ans;
    }

}