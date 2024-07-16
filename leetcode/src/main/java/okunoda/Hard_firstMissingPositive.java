package okunoda;

/**
 * @author Erywim 2024/7/16
 */
public class Hard_firstMissingPositive {

    /**
     * 参考题解
     * https://leetcode.cn/problems/first-missing-positive/solutions/304743/que-shi-de-di-yi-ge-zheng-shu-by-leetcode-solution/?envType=study-plan-v2&envId=top-100-liked
     * @param nums
     * @return
     */

    public int firstMissingPositiveForSwap(int[] nums){
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            while(nums[i] > 0 && nums[i] < length && nums[i] != nums[nums[i] - 1]){
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }

        for (int i = 0; i < length; i++) {
            if(nums[i] != i +1){
                return i +1;
            }
        }
        return length +1;
    }

    public int firstMissingPositive(int[] nums) {
        int length = nums.length;
        //key1：最小的正整数取值只可能是在 [1,len+1]
        //key2：使用hash对数组本身进行映射，把值全置为负数，最后取结果的时候关心的的不是数组里面的值，而是第一个不为零的值的下标，因为之前已经映射过一遍了
        //1. 把非正整数都用理论上可能的最大的的结果去取代
        for (int i = 0; i < length; i++) {
            int num = nums[i];
            if(num <= 0){
                nums[i] = length +1;
            }
        }
        //2. 将数组里面的值进行映射到本数组。只有对数组值小于数组长度的才会进行映射，值太大的不用管，其他数的映射可能将他置为负数
        for (int i = 0; i < length; i++) {
            int num = Math.abs(nums[i]);
            if(num <= length){
                nums[num - 1] = -Math.abs(nums[num - 1]);
            }
        }

        //3. 此时第一个非负数的下标就是所找的最小正数
        for (int i = 0; i < length; i++) {
            if (nums[i] > 0) {
                return i +1;
            }
        }
        return length +1;
    }
}
