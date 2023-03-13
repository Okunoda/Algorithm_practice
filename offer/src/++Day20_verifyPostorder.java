/**
 * @author Okunoda
 * @date 2023年03月13日10:48
 */
class Day20_verifyPostorder {

    //根据后序遍历以及二叉搜索树的特性，
    //首先划分子树，由最后一个节点为基准，找到它前面的最后一个比他小的数，则这个区间就是它的左子树，剩下部分就是又子树
    //第二步就是在划分出的子树中进行判断，如果左子树均小于基点右子树均大于基点，那么遍历完的
    public boolean verifyPostorder(int[] postorder) {
        return recur(postorder,0,postorder.length-1);
    }

    private boolean recur ( int[] postorder , int left , int root){
        if(left >= root){
            return true;
        }
        int cur = left;
        //找到最后一个比 postorder[root]小的数
        while(postorder[root]>postorder[cur])cur++;
        int divide = cur;
        //找到最后一个比postorder[root]大的数。正常情况应当此时cur指向的是root
        while(postorder[root]<postorder[cur])cur++;
        return cur==root && recur(postorder,left,divide-1)&&recur(postorder,divide,root-1);
    }




}
