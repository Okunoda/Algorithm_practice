package okunoda;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Erywim 2024/6/22
 */
public class Hard_maxSlidingWindow {
    public static void main(String[] args) {
        int[] arr = {1,3,-1,-3,5,3,6,7};
        new Hard_maxSlidingWindow().maxSlidingWindow(arr,3);
    }

    /**
     * 单调队列 方式
     * 作者：Krahets
     *     链接：https://leetcode.cn/problems/sliding-window-maximum/solutions/2361228/239-hua-dong-chuang-kou-zui-da-zhi-dan-d-u6h0/
     *     来源：力扣（LeetCode）
     *     著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param nums
     * @param k
     * @return
     */
    public int[] method2(int[] nums, int k) {
        if(nums.length == 0 || k == 0) return new int[0];
        Deque<Integer> deque = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];
        for(int j = 0, i = 1 - k; j < nums.length; i++, j++) {
            // 滑动窗口最左边已经不包含队列中最大值了，则删除
            if(i > 0 && deque.peekFirst() == nums[i - 1]){
                deque.removeFirst();//
            }
            // 保持 deque 递减
            while(!deque.isEmpty() && deque.peekLast() < nums[j]){
                deque.removeLast();
            }
            deque.addLast(nums[j]);
            // 记录窗口最大值
            if(i >= 0) {
                res[i] = deque.peekFirst();
            }
        }
        return res;
    }

    /**
     * 暴力方式
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        int maxIdx = findMax(nums,0,k);
        result[0] = nums[maxIdx];
        for (int i = k; i < nums.length; i++) {
            if(maxIdx < i - k + 1 ){
                maxIdx = findMax(nums,i - k + 1,i+1);
            }

            int maxValue = nums[maxIdx];
            if (nums[i] > maxValue) {
                maxIdx = i;
            }
            result[i-k+1] = nums[maxIdx];
        }

        return result;

    }

    private int findMax(int[] nums, int i, int k) {
        int max = nums[i];
        int maxIdx = i;
        for (int j = i+1; j < k; j++) {
            if (nums[j] > max) {
                max = nums[j];
                maxIdx = j;
            }
        }
        return maxIdx;
    }
}
