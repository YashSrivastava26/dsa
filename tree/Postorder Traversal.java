import java.util.*;

class Tree
{
    
    //Function to return a list containing the postorder traversal of the tree.
    ArrayList<Integer> postOrder(Node root)
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
            if(curr.left != null){
                stack.add(curr.left);
            }
            if(curr.right != null){
                stack.add(curr.right);
            }
        }
        Collections.reverse(ans);
        return ans;
    }
}