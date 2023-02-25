import java.util.ArrayList;
import java.util.List;

/**
 * @author Okunoda
 * @date 2023年02月25日22:28
 */
public class Day6_levelOrder2 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root==null)return new ArrayList<>();
        //思想是利用层次遍历进行操作
        TreeNode[] queue = new TreeNode[10000];
        int front = -1;
        int rear = 0;
        int level = 0;
        List<List<Integer>> list1 = new ArrayList<>();
        queue[rear] = root;
        TreeNode temp = null;
        List<Integer> list2 = new ArrayList<>();
        while(front!=rear){
            temp = queue[++front];
            list2.add(temp.val);
            if(temp.left!=null)
                queue[++rear] = temp.left;
            if(temp.right!=null)
                queue[++rear] = temp.right;
            if(front == level){
                level = rear;
                list1.add(list2);
                list2 = new ArrayList<>();
            }
        }

        return list1;
    }

    //Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

}
