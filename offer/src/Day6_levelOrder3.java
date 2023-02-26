import java.util.*;

/**
 * @author Okunoda
 * @date 2023年02月25日22:36
 */
public class Day6_levelOrder3 {
    //层次遍历加上在偶数层用栈的思路即可解决
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root==null)return new ArrayList<>();
        TreeNode[] queue = new TreeNode[10000];
        int front = -1;
        int rear = 0;
        int level = 0;
        List<List<Integer>> list1 = new ArrayList<>();
        queue[rear] = root;
        TreeNode temp = null;
        boolean flag = true;//true 表示为奇数层，false表示为偶数层
        List<Integer> list2 = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        while(front!=rear){
            temp = queue[++front];
            if(flag){
                list2.add(temp.val);
            }else{
                stack.push(temp.val);
            }
            if (temp.left != null)
                queue[++rear] = temp.left;
            if (temp.right != null)
                queue[++rear] = temp.right;
            if(front == level){
                level = rear;
                if(flag){
                    //当前为奇数层
                    list1.add(list2);
                    flag = false;
                }else{
                    //当前为偶数层
                    while(!stack.isEmpty()){
                        list2.add(stack.pop());
                    }
                    flag = true;
                    list1.add(list2);
                }
                list2 = new ArrayList<>();
            }
        }
        return list1;
    }


    /**
     * 作者：jyd
     * 链接：https://leetcode.cn/problems/cong-shang-dao-xia-da-yin-er-cha-shu-iii-lcof/solution/mian-shi-ti-32-iii-cong-shang-dao-xia-da-yin-er--3/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
//    public List<List<Integer>> levelOrder(TreeNode root) {
//        Queue<TreeNode> queue = new LinkedList<>();
//        List<List<Integer>> res = new ArrayList<>();
//        if (root != null) queue.add(root);
//        while (!queue.isEmpty()) {
//            LinkedList<Integer> tmp = new LinkedList<>();
//            for (int i = queue.size(); i > 0; i--) {
//                TreeNode node = queue.poll();
//                if (res.size() % 2 == 0) tmp.addLast(node.val); // 偶数层 -> 队列头部
//                else tmp.addFirst(node.val); // 奇数层 -> 队列尾部
//                if (node.left != null) queue.add(node.left);
//                if (node.right != null) queue.add(node.right);
//            }
//            res.add(tmp);
//        }
//        return res;
//    }


    //Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
