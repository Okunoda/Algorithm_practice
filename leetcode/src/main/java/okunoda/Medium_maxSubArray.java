package okunoda;

/**
 * @author Erywim 2024/7/9
 */
public class Medium_maxSubArray {
    public static void main(String[] args) {
        int i = new Medium_maxSubArray().maxSubArray(new int[]{0});
        System.out.println("i = " + i);
    }
    public int maxSubArray(int[] nums) {
        int start = 0;
        int ansStart = 0;
        int ansEnd = 0;
        int currentSum = 0;
        int maxSum = Integer.MIN_VALUE;
        int currentMax = Integer.MIN_VALUE;
        int maxNegative = Integer.MIN_VALUE;

        int positiveIdx = 0;
        while(positiveIdx < nums.length && nums[positiveIdx] < 0) {
            if(nums[positiveIdx] > maxNegative){
                maxNegative = nums[positiveIdx];
            }
            positiveIdx++;
        }

        if(positiveIdx == nums.length) {
            return maxNegative;
        }

        for (int i = positiveIdx; i < nums.length; i++) {
            if(currentSum == 0){
                start = i;
            }
            currentSum += nums[i];
            if(currentSum < 0){
                if(currentSum - nums[i] > maxSum){
                    ansStart = start;
                    ansEnd = i - 1;

                    maxSum = currentSum - nums[i];
                }
                currentSum = 0;
                currentMax = Integer.MIN_VALUE;
            }else if (currentSum > currentMax){
                currentMax = currentSum;
                if(currentMax > maxSum){
                    ansStart = start;
                    ansEnd = i ;
                    maxSum = currentSum;
                }

            }
        }
        return maxSum;
    }
}
