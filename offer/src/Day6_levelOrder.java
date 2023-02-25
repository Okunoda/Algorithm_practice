import sun.misc.Queue;

import java.util.ArrayList;


/**
 * @author Okunoda
 * @date 2023年02月25日21:19
 */
public class Day6_levelOrder {
    public int[] levelOrder(TreeNode root) {
        if(root==null)return new int[0];
        //思想是利用层次遍历进行操作
        TreeNode[] queue = new TreeNode[10000];
        int front = -1;
        int rear = 0;
        ArrayList<Integer> res = new ArrayList<>();
        queue[rear] = root;
        TreeNode temp = null;
        while(front!=rear){
            temp = queue[++front];
            res.add(temp.val);
            if(temp.left!=null)
                queue[++rear] = temp.left;
            if(temp.right!=null)
                queue[++rear] = temp.right;
        }
        //感觉这里写的好笨啊，但目前没有直接生成int数组的好思路
        int[] result = new int[res.size()];
        for(int i = 0 ; i<res.size();i++){
            result[i] = res.get(i);
        }
        return result;
    }

     //Definition for a binary tree node.
     public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
     }

}


