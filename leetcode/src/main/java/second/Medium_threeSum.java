package second;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Date 2025/3/4
 */
public class Medium_threeSum {
    public static void main(String[] args) {
        threeSum(new int[]{-1,0,1,2,-1,-4});
    }
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        return solution(nums, 0, 3, 0);
    }

    public static List<List<Integer>> solution(int[] nums, int start, int n, long target) {
        List<List<Integer>> res = new ArrayList<>();
        int left = start, right = nums.length - 1;

        if (n == 2) {
            while (left < right) {
                int leftNum = nums[left];
                int rightNum = nums[right];
                long sum = leftNum + rightNum;
                if (sum == target) {
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(leftNum);
                    list.add(rightNum);
                    res.add(list);

                    while (left < right && leftNum == nums[left]) left++;
                    while (left < right && rightNum == nums[right]) right--;
                } else if (sum < target) {
                    while (left < right && leftNum == nums[left]) left++;
                } else if (sum > target) {
                    while (left < right && rightNum == nums[right]) right--;
                }
            }

        } else {
            for (int i = 0; i < nums.length; i++) {
                int current = nums[i];
                List<List<Integer>> result = solution(nums, i + 1, n - 1, target - current);
                for (int i1 = 0; i1 < result.size(); i1++) {
                    List<Integer> list = result.get(i1);
                    list.add(current);
                    res.add(list);
                }
                while (i < nums.length - 1 && nums[i] == nums[i + 1]) i++;
            }
        }

        return res;
    }
}
