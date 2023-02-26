/**
 * @author Okunoda
 * @date 2023年02月26日10:17
 */
public class Day7_mirrorTree {
    public TreeNode mirrorTree(TreeNode root) {
        preOrder(root);
        return root;
    }
    private void preOrder(TreeNode root){
        if(root == null)return;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        preOrder(root.left);
        preOrder(root.right);
        return;
    }
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
