package okunoda;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author Erywim 2024/9/18
 */
public class Medium_levelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        ArrayList<List<Integer>> result = new ArrayList<>();
        if(root == null){
            return result;
        }

        TreeNode[] queue = new TreeNode[2001];
        queue[0] = root;
        int leftFlag = -1;
        int rightFlag = 0;
        int idx = 0;
        int size = 1;
        ArrayList<Integer> oneRow = new ArrayList<>();

        while(size != 0 && leftFlag < rightFlag){
            TreeNode treeNode = queue[++leftFlag];
            size--;
            oneRow.add(treeNode.val);
            if (treeNode.left !=null) {
                queue[++idx] = treeNode.left;
                size++;
            }
            if(treeNode.right != null){
                queue[++idx] = treeNode.right;
                size++;
            }

            if(leftFlag == rightFlag){
                result.add(oneRow);
                oneRow = new ArrayList<>();
                rightFlag = idx;
            }
        }
        return result;
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
