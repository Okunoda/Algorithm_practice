import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Okunoda
 * @date 2023年02月25日22:36
 */
public class Day6_levelOrder3 {
    //这种简单的思路不行，因为这样在偶数层访问的时候是从后往前进行访问，会影响到第三层孩子的入队顺序
//    public List<List<Integer>> levelOrder(TreeNode root) {
//        if(root==null)return new ArrayList<>();
//        TreeNode[] queue = new TreeNode[10000];
//        int front = -1;
//        int rear = 0;
//        int level = 0;
//        List<List<Integer>> list1 = new ArrayList<>();
//        queue[rear] = root;
//        TreeNode temp = null;
//        boolean flag = true;//true 表示为奇数层，false表示为偶数层
//        List<Integer> list2 = new ArrayList<>();
//        while(front!=rear){
//            if(flag){
//                //奇数层的操作
//                temp = queue[++front];
//            }else{
//                temp = queue[--front];
//            }
//            list2.add(temp.val);
//            if (temp.left != null)
//                queue[++rear] = temp.left;
//            if (temp.right != null)
//                queue[++rear] = temp.right;
//            if(front == level){
//                if(flag){
//                    //当前为奇数层，那么即将为偶数层
//                    level = front+1;
//                    front = rear+1;
//                    list1.add(list2);
//                    list2 = new ArrayList<>();
//                    flag = false;
//                }else{
//                    //下一层即将是奇数层
//                    level = rear;
//                    list1.add(list2);
//                    list2 = new ArrayList<>();
//                    flag = true;
//                }
//            }
//        }
//        return list1;
//    }


    /**
     * 作者：jyd
     * 链接：https://leetcode.cn/problems/cong-shang-dao-xia-da-yin-er-cha-shu-iii-lcof/solution/mian-shi-ti-32-iii-cong-shang-dao-xia-da-yin-er--3/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if (root != null) queue.add(root);
        while (!queue.isEmpty()) {
            LinkedList<Integer> tmp = new LinkedList<>();
            for (int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.poll();
                if (res.size() % 2 == 0) tmp.addLast(node.val); // 偶数层 -> 队列头部
                else tmp.addFirst(node.val); // 奇数层 -> 队列尾部
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            res.add(tmp);
        }
        return res;
    }


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
