package second;

/**
 * 前缀和应用
 * @Date 2025/3/5
 */
public class Easy_NumArray {
    int[] prefixNum;
    public void NumArray(int[] nums) {
        prefixNum = new int[nums.length + 1];
        for (int i = 1; i <= nums.length; i++) {
            prefixNum[i] = nums[i-1] + prefixNum[i - 1];
        }
    }

    public int sumRange(int left, int right) {
        return prefixNum[right+1] - prefixNum[left];
    }
}
