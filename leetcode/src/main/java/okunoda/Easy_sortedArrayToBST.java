package okunoda;

/**
 * @author Erywim 2024/9/19
 */
public class Easy_sortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        return recursion(nums, 0, nums.length - 1);
    }

    private TreeNode recursion(int[] nums , int low , int high){
        if(low > high){
            return null;
        }
        int minIdx = low + (high - low) / 2;
        TreeNode treeNode = new TreeNode(nums[minIdx]);
        treeNode.left = recursion(nums, low, minIdx - 1);
        treeNode.right = recursion(nums,minIdx+1,high);
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
