package okunoda;

import java.util.Arrays;

/**
 * @author Erywim 2024/11/25
 */
public class Medium_buildTree {
    public static void main(String[] args) {

        int[] preOrder = {3, 9, 20, 15, 7};
        int[] inOrder = {9,3,15,20,7};
        new Medium_buildTree().buildTree(preOrder,inOrder);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return dfs(preorder,inorder,0,preorder.length-1,0,inorder.length-1);
    }

    private TreeNode dfs(int[] preorder, int[] inorder,int preLef,int preRight,int inLeft,int inRight) {
        if(preRight<preLef || inRight < inLeft) return null;
        int val = preorder[preLef];
        TreeNode treeNode = new TreeNode(val);
        int idx = 0;

        for (int i = inLeft; i <= inRight; i++) {
            if(inorder[i] == val) {
                idx = i;
                break;
            }
        }

        int count = idx - inLeft;

        treeNode.left = dfs(preorder, inorder, preLef + 1, preLef + count, inLeft, idx -1);
        treeNode.right = dfs(preorder, inorder, preLef + 1 + count, preRight, idx + 1, inRight);
        return treeNode;
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
