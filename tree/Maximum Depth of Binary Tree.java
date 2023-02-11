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

// class Pair{
//     TreeNode node = null;
//     int lvl;
//     Pair(int lvl, TreeNode node){
//         this.node = node;
//         this.lvl = lvl;
//     }
// }
// class Solution {
//     public int maxDepth(TreeNode root) {
//         if(root == null){
//             return 0;
//         }
//         Deque<Pair> stack = new LinkedList<>();
//         stack.add(new Pair(1, root));
//         int ans = 0;
//         while(!stack.isEmpty()){
//             Pair curr = stack.pollLast();
//             ans = Math.max(ans, curr.lvl);

//             if(curr.node.left != null){
//                 stack.add(new Pair(curr.lvl + 1, curr.node.left));
//             }
//             if(curr.node.right != null){
//                 stack.add(new Pair(curr.lvl + 1, curr.node.right));
//             }
//         }
//         return ans;
//     }
// }

class Solution {
    private int traversal(TreeNode root, int lvl){
        if(root == null){
            return lvl - 1;
        }
        return Math.max(traversal(root.left, lvl + 1), traversal(root.right, lvl + 1));
    }
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        return traversal(root, 1);
    }
}