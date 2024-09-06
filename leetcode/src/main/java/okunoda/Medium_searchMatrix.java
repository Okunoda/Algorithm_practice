package okunoda;

import java.util.Stack;

/**
 * @author Erywim 2024/9/5
 */
public class Medium_searchMatrix {
    /**
     * 参考题解：https://leetcode.cn/problems/search-a-2d-matrix-ii/solutions/2361487/240-sou-suo-er-wei-ju-zhen-iitan-xin-qin-7mtf
     * 将矩阵看作图或树，充分利用从上往下递增，从左往右递增的特性
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int i = 0;
        while(rows > 0 && i < cols){
            int flag = matrix[rows - 1][i];
            if(flag == target) return true;
            if(flag < target){
                i++;
            }
            if(flag > target){
                rows--;
            }
        }
        return false;
    }
}
