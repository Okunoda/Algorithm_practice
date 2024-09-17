package okunoda;

/**
 * @author Erywim 2024/9/17
 */
public class Easy_invertTree {
    public TreeNode invertTree(TreeNode root) {
        recursion(root);
        return root;
    }

    private void recursion(TreeNode node){
        if(node == null)
            return;
        TreeNode tmp = node.left;
        node.left = node.right;
        node.right = tmp;
        recursion(node.left);
        recursion(node.right);
    }



    public class TreeNode {
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
}
