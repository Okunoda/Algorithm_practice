/**
 * @author Okunoda
 * @date 2023年03月09日10:52
 */
public class Day15_kthLargest {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public int kthLargest(TreeNode root, int k) {
        inOrder(root,k);
        return result;
    }
    int count = 0;
    boolean end = false;
    int result;
    private void inOrder(TreeNode root,int k){
        if(end || root==null)
            return ;
        if(root.right !=null)
            inOrder(root.right,k);
        if(++count==k){
            result = root.val;
            end = true;
            return;
        }
        if(root.left !=null)
            inOrder(root.left,k);
    }
}
