
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

class Solution {

    private int isFullBT(TreeNode node){
        TreeNode leftTree = node, rightTree = node;
        int leftH = 0, rightH = 0;
        while(leftTree != null){
            leftH++;
            leftTree = leftTree.left;
        }

        while(rightTree != null){
            rightH++;
            rightTree = rightTree.right;
        }

        if(leftH == rightH){
            return (1<<leftH) - 1;
        }
        return -1;
    }

    private int cntNodes(TreeNode node){
        if(node == null){
            return 0;
        }

        int currStatusOfFullBT = isFullBT(node);
        if(currStatusOfFullBT != -1){
            return currStatusOfFullBT;
        }

        return 1 + cntNodes(node.left) + cntNodes(node.right);
    }

    public int countNodes(TreeNode root) {        
        return cntNodes(root);
    }
}