package okunoda;

/**
 * @author Erywim 2024/9/21
 */
public class Medium_flatten {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.left.left.left = new TreeNode(5);
        Medium_flatten entity = new Medium_flatten();
        entity.flatten(root);
        System.out.println("root = " + root);
    }
    public void flatten(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return;
        }
        TreeNode result = new TreeNode();
        dfs(root,result);
        root = result.right;
    }
    private TreeNode dfs(TreeNode node,TreeNode prev){
        if(node == null)
            return prev;
        TreeNode lastNode;
        prev.right = node;
        lastNode = prev.right;
        TreeNode tempLeft = node.left;
        TreeNode tempRight = node.right;
        node.left = null;
        node.right = null;

        lastNode = dfs(tempLeft, lastNode);
        lastNode = dfs(tempRight, lastNode);

        return lastNode == null?prev.right : lastNode;
    }
}
