package second;

public class Medium_maxSubArray {
    public int maxSubArray(int[] nums) {
        //思路：滑动窗口，因为子数组是连续的，所以直接从第一个正数开始，然后每加一个数值就记录一次最大值。如果为负数，那么直接收缩左边的指针到当前右指针的下一个
        if(nums.length == 0)
            return 0;
        if(nums.length == 1)
            return nums[0];
        int lp = 0;
        int rp = 0;
        int maxSum = Integer.MIN_VALUE;

        while(rp < nums.length){
            int sum = 0;
            while(rp < nums.length && (sum = sum + nums[rp]) > 0){
                maxSum = Math.max(sum , maxSum);
                rp++;
            }
            maxSum = Math.max(sum , maxSum);
            rp++;
        }
        return maxSum;

    }
}
