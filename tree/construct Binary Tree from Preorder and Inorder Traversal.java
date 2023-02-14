import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

// class Solution {

//     private TreeNode create(int[] preorder, int[] inorder, int preStart, int preEnd, int inStart, int inEnd){
//         if(preStart > preEnd || inStart > inEnd){
//             return null;
//         }
//         int node = preorder[preStart];
        
//         TreeNode curr = new TreeNode(node);
//         System.out.println(node);
//         int i = 0;
//         for(; i + inStart < inEnd; i++){
//             if(inorder[inStart + i] == node){
//                 break;
//             }
//         }

//         // System.out.println(node + " i " + i);
//         // System.out.println((preStart + 1) + " " + (preStart + i) + " " + (preStart + i + 1) +  " " + preEnd);
//         // System.out.println(inStart + " " + (inStart + i - 1) + " " + (inStart + i + 1) +  " " + inEnd);

//         TreeNode leftChild = create(preorder, inorder, preStart + 1,  preStart + i, inStart, inStart + i - 1);
//         TreeNode rightChild = create(preorder, inorder, preStart + i + 1, preEnd, inStart + i + 1, inEnd);

//         curr.left = leftChild;
//         curr.right = rightChild;


//         // System.out.print(curr.right == null ? "null " : curr.right.val + " ");
//         // System.out.print(curr.right == null ? "null\n" : curr.right.val + "\n");

//         return curr;
//     }

//     public TreeNode buildTree(int[] preorder, int[] inorder) {
//         int n = preorder.length;
//         if(n == 0){
//             return null;
//         }
//         return create(preorder, inorder, 0, n - 1, 0, n - 1);
//     }
// }

class Solution {

    private TreeNode create(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, HashMap<Integer, Integer> idxInorder){
        if(preStart > preEnd || inStart > inEnd){
            return null;
        }
        TreeNode curr = new TreeNode(preorder[preStart]);

        int rootIdx = idxInorder.get(curr.val);
        int numsLeft = rootIdx - inStart;

        curr.left = create(preorder, preStart + 1, preStart + numsLeft,
                            inorder, inStart, rootIdx - 1, idxInorder);

        curr.right = create(preorder, preStart + numsLeft + 1, preEnd,
                            inorder, rootIdx + 1, inEnd, idxInorder);

        return curr;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        if(n == 0){
            return null;
        }

        HashMap<Integer, Integer> idxInorder = new HashMap<>();
        for(int i = 0; i < n; i++){
            idxInorder.put(inorder[i], i);
        }
        return create(preorder, 0, n - 1, inorder, 0, n - 1, idxInorder);
    }
}