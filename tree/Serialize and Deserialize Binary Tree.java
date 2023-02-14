// import java.util.*;

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

class Codec {
    private int idx = 0;
    private StringBuffer serial;
    private void inorder(TreeNode node){
        if(node == null){
            serial.append("N,");
            return;
        }

        serial.append(Integer.toString(node.val) + ",");
        inorder(node.left);
        inorder(node.right);
    }

    private TreeNode makeTree(String data){
        if(idx >= data.length()){
            return null;
        }

        TreeNode curr;
        if(data.charAt(idx) != 'N'){
            int value = 0;
            boolean isNeg = false;
            if(data.charAt(idx) == '-'){
                isNeg = true;
                idx++;
            }
            while(data.charAt(idx) != ','){
                value = 10 * value + (data.charAt(idx) - '0');
                idx++;
            }
            idx++;
            if(isNeg){
                value *= -1;
            }
            curr = new TreeNode(value);
        }
        else{
            curr = null;
            idx += 2;
            return curr;
        }

        curr.left = makeTree(data);
        curr.right = makeTree(data);
        return curr;
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        serial = new StringBuffer();
        inorder(root);
        // System.out.println(serial);
        return serial.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        idx = 0;
        return makeTree(data);
    }
}
// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));