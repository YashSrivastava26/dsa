import java.util.*;
class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

class Pair{
    Node node = null;
    int idx;
    Pair(Node node, int idx){
        this.node = node;
        this.idx = idx;
    }
}
class Tree {
    ArrayList<Integer> postOrder(Node root) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for(int i = 0; i < 3; i++){
            ans.add(new ArrayList<Integer>());
        }
        Deque<Pair> stack = new LinkedList<>();
        stack.add(new Pair(root, 0));
        //0 is inorder 1 is preorder 2 is postorder
        
        while(!stack.isEmpty()){
            Pair curr = stack.pollLast();
            ans.get(curr.idx).add(curr.node.data);
            if(curr.idx < 2){
                curr.idx = curr.idx + 1;
                stack.add(curr);
            }
            
            if(curr.idx == 1){
                if(curr.node.right != null){
                    stack.add(new Pair(curr.node.right, 0));
                }
                if(curr.node.left != null){
                    stack.add(new Pair(curr.node.left, 0));
                }
            }
            
        }


        // for(int i = 0; i < ans.size(); i++){
        //     for(int j = 0; j < ans.get(i).size(); j++){
        //         System.out.print(ans.get(i).get(j) + " ");
        //     }
        //     System.out.println();
        // }
        return ans.get(2);
    }
}