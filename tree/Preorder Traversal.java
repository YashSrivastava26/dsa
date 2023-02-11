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
    static void inorder(Node root, ArrayList<Integer> ans){
        if(root == null){
            return;
        }
        ans.add(root.data);
        inorder(root.left, ans);
        inorder(root.right, ans);
    }
    //Function to return a list containing the preorder traversal of the tree.
    static ArrayList<Integer> preorder(Node root)
    {
        ArrayList<Integer> ans = new ArrayList<>();
        inorder(root, ans);
        return ans;
    }

}