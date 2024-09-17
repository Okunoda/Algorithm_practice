package okunoda;

/**
 * @author Erywim 2024/9/17
 */
public class Easy_isSymmetric {
    public boolean isSymmetric(TreeNode root) {
        if(root == null)
            return true;
        return recursion(root.left, root.right);
    }

    private boolean recursion(TreeNode node1 , TreeNode node2){
        if((node1 == null && node2 != null) ||
                (node1 != null && node2 == null)){
            return false;
        }
        if (node1 == null && node2 == null) {
            return true;
        }
        if(node1.val != node2.val){
            return false;
        }

        boolean left = recursion(node1.left, node2.right);
        boolean right = recursion(node1.right, node2.left);
        return left && right;

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
