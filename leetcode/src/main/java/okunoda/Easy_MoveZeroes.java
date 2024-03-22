package okunoda;

/**
 * @author Okunoda 2024/3/22
 */
public class Easy_MoveZeroes {
    class Solution {
        public void moveZeroes(int[] nums) {
            int next = 0;
            boolean init = true;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != 0) {
                    continue;
                }
                if(init){
                    next = i + 1;
                    init = false;
                }
                //nums[i]此时为0，需要end进行往后找到非零的数进行交换
                while (next < nums.length && nums[next] == 0) {
                    next++;
                }
                //此时要么next越界，要么就是非零的数
                if (next >= nums.length) {
                    return;
                }
                nums[i] = nums[next];
                nums[next] = 0;
            }
        }
    }
}
