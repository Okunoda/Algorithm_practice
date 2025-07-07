package second;

public class Medium_findTargetIn2DPlants {
    /**
     * @param plants
     * @param target
     * @return
     */
    public boolean findTargetIn2DPlants(int[][] plants, int target) {
        //回溯超时间了，差三个案例没通过
//        return reverse(plants,0,0,target);

        return solution(plants,target);
    }


    /**
     * 一种复杂度为O(M+N)的解法，充分利用了同行右边比左边大、同列下面比上面大的原则
     * 从左下角开始，如果当前元素大于目标元素，那么这一行就可以略过，如果小于就可以直接锁定这一行
     *
     * @param plants
     * @param target
     * @return
     */
    private boolean solution(int[][] plants, int target) {
        if(plants.length ==0 || plants[0].length == 0)
            return false;

        int i = plants.length -1;
        int j = 0;

        while( i >= 0 && j < plants[0].length){
            int current = plants[i][j];
            if (current == target)
                return true;
            else if (current > target) {
                i--;
            } else {
                j++;
            }
        }


        return false;
    }


    /**
     * 找到园林中是否存在目标高度的植物，矩阵，同行右边比左边大，同列下面比上面大
     * * 应当是一个回溯算法，从左上角开始找，如果右边和下面都大于目标值（或为边界），但是本身小于目标值，那么就说明没找到
     *
     * @param plants
     * @param i
     * @param j
     * @param target
     * @return
     */
    private boolean reverse(int[][] plants, int i, int j, int target) {
        //分别判断向下和向右
        if (i >= plants.length || j >= plants[0].length)
            return false;

        if (plants[i][j] == target)
            return true;
        else if (plants[i][j] > target) {
            return false;
        }
        //分别向右和向下递归查找

        boolean next = reverse(plants, i + 1, j, target);
        boolean right = reverse(plants, i, j + 1, target);
        return next || right;
    }

}
