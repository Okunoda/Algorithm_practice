package okunoda;

/**
 * @author Erywim 2024/7/16
 */
public class Medium_productExceptSelf {
    /**
     * 参考题解
     * 作者：Krahets
     * 链接：https://leetcode.cn/problems/product-of-array-except-self/solutions/11472/product-of-array-except-self-shang-san-jiao-xia-sa/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param nums
     * @return
     */
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        if(length <= 1) return nums;
        int[] result = new int[length];
        result[0] = 1;
        for (int i = 1; i < length; i++) {
            result[i] = result[i-1] * nums[i-1];
        }
        int temp = 1;
        for (int i = length - 2 ; i >= 0; i--) {
            temp *= nums[i+1];
            result[i] *= temp;
        }
        return result;
    }
}
