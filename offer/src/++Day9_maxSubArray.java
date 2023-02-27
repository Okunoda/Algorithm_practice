/**
 * @author Okunoda
 * @date 2023年02月27日20:10
 */


class Day9_maxSubArray {
    //不降空间复杂度写法
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            dp[i] = Math.max(nums[i] + dp[i - 1], nums[i]);
            if (dp[i] > max)
                max = dp[i];
        }
        return max;
    }
    //降空间复杂度写法

//    作者：jyd
//    链接：https://leetcode.cn/problems/lian-xu-zi-shu-zu-de-zui-da-he-lcof/solution/mian-shi-ti-42-lian-xu-zi-shu-zu-de-zui-da-he-do-2/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处

    public int maxSubArray2(int[] nums) {
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            nums[i] += Math.max(0, nums[i - 1]);
            max = Math.max(max, nums[i]);
        }
        return max;
    }
}
