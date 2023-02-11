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

class Solution
{
	ArrayList <Integer> boundary(Node node)
	{
	    ArrayList<Integer> ans = new ArrayList<>();
	    ans.add(node.data);
	    Node leftItr = node.left;
	    while(leftItr != null){
	        if(!(leftItr.right == null && leftItr.left == null)){
    	        ans.add(leftItr.data);
	        }
	        if(leftItr.left != null){
	            leftItr = leftItr.left;
	        }
	        else if(leftItr.right != null){
	            leftItr = leftItr.right;
	        }
	        else{
	            leftItr = null;
	        }
	    }
	    
	    Deque<Node> stack = new LinkedList<>();
	    stack.add(node);
	    while(!stack.isEmpty()){
	        Node curr = stack.pollLast();
	        if(curr.right != null){
	            stack.add(curr.right);
	        }
	        if(curr.left != null){
	            stack.add(curr.left);
	        }
	        if(curr.left == null && curr.right == null && curr != node){
	            ans.add(curr.data);
	        }
	    }
	    
	    Node rightItr = node.right;
	    while(rightItr != null){
	        if(!(rightItr.right == null && rightItr.left == null)){
	            stack.add(rightItr);
	        }
	        
	        if(rightItr.right != null){
	            rightItr = rightItr.right;
	        }
	        else if(rightItr.left != null){
	            rightItr = rightItr.left;
	        }
	        else{
	            rightItr = null;
	        }
	    }
	    while(!stack.isEmpty()){
	        int a = stack.pollLast().data;
	        ans.add(a);
	    }
	    
	    return ans;
	}
}