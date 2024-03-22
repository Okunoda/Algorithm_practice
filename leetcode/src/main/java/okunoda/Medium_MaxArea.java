package okunoda;

import java.util.Arrays;

/**
 * @author Okunoda 2024/3/22
 */
public class Medium_MaxArea {
    public static void main(String[] args) {
        Medium_MaxArea mm = new Medium_MaxArea();
        System.out.println(mm.maxArea(new int[]{1, 1}));
    }

    /**
     *
     作者：Krahets
     链接：https://leetcode.cn/problems/container-with-most-water/solutions/11491/container-with-most-water-shuang-zhi-zhen-fa-yi-do/
     来源：力扣（LeetCode）
     著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int i = 0, j = height.length - 1, res = 0;
        while(i < j) {
            res = height[i] < height[j] ?
                    Math.max(res, (j - i) * height[i++]):
                    Math.max(res, (j - i) * height[j--]);
        }
        return res;
    }



    //暴力递归，超时无法AC
    public int maxArea1(int[] height) {
        int max= 0;
        for (int i = 0; i < height.length-1 ; i++) {
            int cap = recursion(height, i,  i+1);
            if(cap > max){
                max = cap;
            }
        }
        return max;
    }
    public int recursion(int[] height,int start , int end){
        if(end >= height.length){
            return Integer.MIN_VALUE;
        }
        int len = end - start;
        int cap = Math.min(height[start], height[end]) * len;

        for (int i = end; i < height.length; i++) {
            int capacity = recursion(height, start, end + 1);
            if(capacity > cap){
                cap = capacity;
            }
        }
        return cap;
    }
}
