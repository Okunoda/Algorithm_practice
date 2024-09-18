package okunoda;

/**
 * @author Erywim 2024/9/18
 */
public class Easy_diameterOfBinaryTree {
    private int result = Integer.MIN_VALUE;
    public int diameterOfBinaryTree(TreeNode root) {
        recursion(root);
        return result;
    }
    private int recursion(TreeNode node){
        if(node == null)
            return -1;
        int left = recursion(node.left) + 1;
        int right = recursion(node.right) + 1;
        result = Math.max(result, left + right);
        return Math.max(left, right);
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
