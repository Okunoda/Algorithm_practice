import java.util.ArrayList;

/**
 * @author Okunoda
 * @date 2023年03月11日10:12
 */
public class Day19_lowestCommonAncestor二 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    //内存消耗 99.9%
    //时间消耗20.6%
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode[] pathQ = new TreeNode[50000];
        int depQ = 0;
        findPath(root, q, pathQ, 0);
        depQ = finalLen;
        flag = false;
        finalLen = 0;
        TreeNode[] pathP = new TreeNode[50000];
        int depP = 0;
        findPath(root, p, pathP, 0);
        depP = finalLen;
        int i = 0;
        while (i <= depQ && i <= depP && pathQ[i] == pathP[i]) {
            i++;
        }
        return pathQ[i - 1];
    }

    boolean flag = false;
    int finalLen = 0;

    private void findPath(TreeNode root, TreeNode target, TreeNode[] path, int depth) {
        if (flag)
            return;
        if (root == null)
            return;
        path[depth] = root;
        if (root == target) {
            flag = true;
            finalLen = depth;
            return;
        } else {
            findPath(root.left, target, path, depth + 1);
            findPath(root.right, target, path, depth + 1);
        }

    }

}
