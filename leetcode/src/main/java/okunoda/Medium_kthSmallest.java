package okunoda;

/**
 * @author Erywim 2024/9/21
 */
public class Medium_kthSmallest {
    int n = 0;
    int result = 0;
    public int kthSmallest(TreeNode root, int k) {
        if(root == null)
            return 0;
        n = k;
        dfs(root);
        return result;
    }
    private void dfs(TreeNode node){
        if(node == null)
            return;

        dfs(node.left);
        if(--n == 0){
            result = node.val;
        } else if (n < 0) {
            return;
        }
        dfs(node.right);
    }

}
