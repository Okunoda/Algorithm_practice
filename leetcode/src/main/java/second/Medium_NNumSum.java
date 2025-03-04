package second;

import java.util.*;

/**
 * @Date 2025/3/3
 */
public class Medium_NNumSum {
    public static void main(String[] args) {
        fourSum(new int[]{1000000000,1000000000,1000000000,1000000000},  -294967296);
    }
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return solution(nums, 0,4, target);
    }

    private static List<List<Integer>> solution(int[] nums, int start , int n, long target) {

        List<List<Integer>> res = new ArrayList<>();
        int left = start, right = nums.length - 1;
        if(n == 2){
            while(left < right){
                int hi = nums[right];
                int lo = nums[left];
                long sum = lo + hi;

                if( sum == target){
                    ArrayList<Integer> integers = new ArrayList<>();
                    integers.add(hi);
                    integers.add(lo);
                    res.add(integers);

                    //跳过重复元素
                    while (left < right && hi == nums[right]) right--;
                    while(left<right && lo == nums[left]) left++;

                }else if(sum > target){
                    while (left < right && hi == nums[right]) right--;
                }else if ( sum < target){
                    while(left<right && lo == nums[left]) left++;
                }
            }
        }else{
            for (int i = start; i < nums.length; i++) {
                int current = nums[i];
                List<List<Integer>> solution = solution(nums, i + 1, n - 1, target - current);
                if(!solution.isEmpty()){
                    for (List<Integer> list : solution) {
                        list.add(current);
                        res.add(list);
                    }
                }
                while(i < nums.length-1 && nums[i] == nums[i+1]) i++;
            }
        }
        return res;
    }

}
