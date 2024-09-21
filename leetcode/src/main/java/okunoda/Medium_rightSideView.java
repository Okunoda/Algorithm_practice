package okunoda;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Erywim 2024/9/21
 */
public class Medium_rightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        if(root == null){
            return result;
        }

        TreeNode[] queue = new TreeNode[2001];
        queue[0] = root;
        int leftFlag = -1;
        int rightFlag = 0;
        int idx = 0;
        int size = 1;

        while(size != 0 && leftFlag < rightFlag){
            TreeNode treeNode = queue[++leftFlag];
            size--;
            if (treeNode.left !=null) {
                queue[++idx] = treeNode.left;
                size++;
            }
            if(treeNode.right != null){
                queue[++idx] = treeNode.right;
                size++;
            }

            if(leftFlag == rightFlag){
                result.add(treeNode.val);
                rightFlag = idx;
            }
        }
        return result;
    }
}
