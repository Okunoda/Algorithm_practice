import java.util.ArrayList;
import java.util.List;

/**
 * @author Okunoda
 * @date 2023年03月09日8:59
 */
public class Day15_pathSum {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    int[] route = new int[300];
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        preOrder(root,target,0,0);
        return result;
    }

    void preOrder(TreeNode root ,int target , int path ,int sum){
        if(root == null)return ;
        route[path] = root.val;
        if(root.left==null&&root.right==null&& root.val+sum == target){
            //此时就是到了一条路径
            List<Integer> temp = new ArrayList<>();

            for(int i = 0 ; i <= path ; i++){
                temp.add(route[i]);
            }
            result.add(temp);
            return;
        }
        if(root.left!=null)
            preOrder(root.left,target,path+1,sum+root.val);
        if(root.right!=null)
            preOrder(root.right,target,path+1,sum+root.val);

    }

}