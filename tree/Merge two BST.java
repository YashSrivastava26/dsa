import java.util.*;

class Node  
{ 
    int data; 
    Node left, right; 
   
    public Node(int d)  
    { 
        data = d; 
        left = right = null; 
    } 
}


// class Solution
// {
//     private void findInorder(Node root, ArrayList<Integer> inorder){
//         if(root == null){
//             return;
//         }
//         findInorder(root.left, inorder);
//         inorder.add(root.data);
//         findInorder(root.right, inorder);
//     }
    
//     private List<Integer> merge2SortedList(ArrayList<Integer>inorder1, ArrayList<Integer> inorder2){
//         int i = 0, j = 0;
//         int n = inorder1.size(), m = inorder2.size();
//         List<Integer> ans = new ArrayList<>();
//         while(i < n && j < m){
//             if(inorder1.get(i) <= inorder2.get(j)){
//                 ans.add(inorder1.get(i++));
//             }
//             else{
//                 ans.add(inorder2.get(j++));
//             }
//         }
        
//         while(i < n){
//             ans.add(inorder1.get(i++));
//         }
//         while(j < n){
//             ans.add(inorder2.get(j++));
//         }
//         return ans;
//     }
//     //Function to return a list of integers denoting the node 
//     //values of both the BST in a sorted order.
//     public List<Integer> merge(Node root1,Node root2)
//     {
//         ArrayList<Integer> inorder1 = new ArrayList<>();
//         ArrayList<Integer> inorder2 = new ArrayList<>();
        
//         findInorder(root1, inorder1);
//         findInorder(root2, inorder2);
        
//         return merge2SortedList(inorder1, inorder2);
//     }
// }


class BSTIterator {
    Stack<Node> inorder;
    
    BSTIterator(Node root) {
        inorder = new Stack<Node>();
        Node curr = root;

        while(curr != null){
            inorder.push(curr);
            curr = curr.left;
        }
    }
    
    int next() {
        Node ret = inorder.pop();
        Node rightNodes = ret.right;

        while(rightNodes != null){
            inorder.push(rightNodes);
            rightNodes = rightNodes.left;
        }
        return ret.data;
    }
    
    Integer hasNext() {
        if(inorder.size() == 0){
            return null;
        }
        return inorder.peek().data;
    }
};


class Solution
{
    public List<Integer> merge(Node root1,Node root2)
    {
        List<Integer> ans = new ArrayList<>();
        BSTIterator it1 = new BSTIterator(root1);
        BSTIterator it2 = new BSTIterator(root2);
        
        while(it1.hasNext() != null && it2.hasNext() != null){
            if(it1.hasNext() <= it2.hasNext()){
                ans.add(it1.next());
            }
            else{
                ans.add(it2.next());
            }
        }
        
        while(it1.hasNext() != null){
            ans.add(it1.next());
        }
        while(it2.hasNext() != null){
            ans.add(it2.next());
        }
        return ans;
    }
}