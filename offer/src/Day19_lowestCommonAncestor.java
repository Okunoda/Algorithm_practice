import java.util.ArrayList;

/**
 * @author Okunoda
 * @date 2023年03月11日9:19
 */
public class Day19_lowestCommonAncestor {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //初步思路是先找到目标节点，然后记录此时路径中压入的点
        //第二步是两个路径相比较，最后一个相同的点即为最小公共祖先
        ArrayList<TreeNode> pathP = findPath(root, p);
        ArrayList<TreeNode> pathQ = findPath(root, q);
        int i = 0;
        while(i<pathP.size()&&i<pathQ.size()&&pathP.get(i)==pathQ.get(i)){
            i++;
        }
        return pathP.get(i-1);
    }

    private ArrayList<TreeNode> findPath(TreeNode root , TreeNode target){
        TreeNode temp = root;
        ArrayList<TreeNode> path = new ArrayList<>();
        while(temp!=null){
            path.add(temp);
            if(target.val < temp.val){
                temp = temp.left;
            }else if(temp.val < target.val){
                temp = temp.right;
            }else{
                return path;
            }
        }
        return null;
    }

}
