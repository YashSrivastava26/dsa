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

class Tuple{
    int mini, maxi, size;
    Tuple(int mini, int maxi, int size){
        this.mini = mini;
        this.maxi = maxi;
        this.size = size;
    }
}
class Solution{
    
    private static Tuple postOrder(Node root){
        if(root == null){
            return new Tuple(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        }
        
        Tuple leftTuple = postOrder(root.left);
        Tuple rightTuple = postOrder(root.right);
        
        if(root.data > leftTuple.maxi && root.data < rightTuple.mini){
            return new Tuple(Math.min(leftTuple.mini, root.data), Math.max(rightTuple.maxi, root.data), 1 + rightTuple.size + leftTuple.size);
        }
        
        return new Tuple(Integer.MIN_VALUE, Integer.MAX_VALUE, Math.max(rightTuple.size, leftTuple.size));
    }
    
    static int largestBst(Node root)
    {
        return postOrder(root).size;
    }
    
}