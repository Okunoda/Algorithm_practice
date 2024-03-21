package okunoda;

import java.util.Arrays;

/**
 * @author Okunoda 2024/3/21
 */
public class Medium_LongestConsecutive {
    public static void main(String[] args) {
        int i = longestConsecutive(new int[]{7,-9,3,-6,3,5,3,6,-2,-5,8,6,-4,-6,-4,-4,5,-9,2,7,0,0});
        System.out.println("i = " + i);
    }
    public static int longestConsecutive(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }
        Arrays.sort(nums);
        int maxLen = 1;
        int length = nums.length;
        int currentLen = 1;
        for (int i = 1; i < length; i++) {
            if (nums[i] == nums[i - 1]) {
                continue;
            }
            if (nums[i] - nums[i - 1] != 1) {
                if (currentLen >= maxLen) {
                    maxLen = currentLen;
                }
                currentLen = 1;
            } else {
                currentLen++;
            }
        }
        return currentLen > maxLen ? currentLen : maxLen;
    }
}
