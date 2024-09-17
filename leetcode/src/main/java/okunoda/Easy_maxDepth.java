package okunoda;

/**
 * @author Erywim 2024/9/17
 */
public class Easy_maxDepth {
    public int maxDepth(TreeNode root) {
        if(root == null)
            return 0;
        return recursionDepth(root);
    }

    private int recursionDepth(TreeNode node) {
        if(node == null){
            return 0;
        }
        int leftDepth = 0;
        int rightDepth = 0;
        if(node.left != null){
            leftDepth = recursionDepth(node.left);
        }
        if(node.right != null){
            rightDepth = recursionDepth(node.right);
        }
        return Math.max(leftDepth, rightDepth) + 1;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}