package okunoda;

import java.util.Stack;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * 接雨水
 * @author Okunoda 2024/3/29
 */
public class Hard_Trap {
    public static void main(String[] args) {
        Hard_Trap h = new Hard_Trap();
        h.trap(new int[]{1,0,1,3,2,0,1,0,2,1,0,3});
    }

    /**
     *     作者：代码随想录
     *     链接：https://leetcode.cn/problems/trapping-rain-water/solutions/2429133/dai-ma-sui-xiang-lu-jie-yu-shui-by-carls-lk08/
     *     来源：力扣（LeetCode）
     *     著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param height
     * @return
     */

    public int trap(int[] height){
        int size = height.length;

        if (size <= 2) return 0;

        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        int sum = 0;
        for (int index = 1; index < size; index++){
            int stackTop = stack.peek();
            if (height[index] < height[stackTop]){
                stack.push(index);
            }else if (height[index] == height[stackTop]){
                // 因为相等的相邻墙，左边一个是不可能存放雨水的，所以pop左边的index, push当前的index
                stack.pop();
                stack.push(index);
            }else{
                //pop up all lower value
                int heightAtIdx = height[index];
                while (!stack.isEmpty() && (heightAtIdx > height[stackTop])){
                    int mid = stack.pop();

                    if (!stack.isEmpty()){
                        int left = stack.peek();

                        int h = Math.min(height[left], height[index]) - height[mid];
                        int w = index - left - 1;
                        int hold = h * w;
                        if (hold > 0) sum += hold;
                        stackTop = stack.peek();
                    }
                }
                stack.push(index);
            }
        }
        return sum;
    }
}
