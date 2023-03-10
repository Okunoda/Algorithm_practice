/**
 * @author Okunoda
 * @date 2023年03月10日11:07
 */
public class Day18_isBalanced {
    public boolean isBalanced(TreeNode root) {
        depth(root);
        return flag;
    }

    boolean flag = true;

    int depth(TreeNode node) {
        if (node == null)
            return 0;
        int leftDep = depth(node.left);
        int rightDep = depth(node.right);
        if (Math.abs(leftDep - rightDep) > 1)
            flag = false;
        return Math.max(rightDep, leftDep) + 1;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
