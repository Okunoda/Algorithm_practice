/**
 * @author Okunoda
 * @date 2023年03月10日10:50
 */
public class Day18_maxDepth {
    public int maxDepth(TreeNode root) {
        if(root == null)
            return 0;
        preOrder(root,1);
        return maxDepth;

    }

    int maxDepth = 1;
    public void preOrder(TreeNode root,int depth){
        if(root==null){
            return;
        }else
            maxDepth = Math.max(depth,maxDepth);

        if(root.left != null)
            preOrder(root.left,depth+1);
        if(root.right != null)
            preOrder(root.right ,depth+1);
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
