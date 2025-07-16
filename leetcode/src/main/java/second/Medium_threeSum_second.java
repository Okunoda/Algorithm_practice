package second;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Medium_threeSum_second {
    /**
     * 题解地址：https://leetcode.cn/problems/3sum/solutions/12307/hua-jie-suan-fa-15-san-shu-zhi-he-by-guanpengchn/
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        if(nums.length < 3)
            return null;
        Arrays.sort(nums);
        ArrayList<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] > 0) break; //如果当前值大于0，那么之后的和肯定大于0，直接退出
            if(i > 0 && nums[i-1] == nums[i]) continue; //去重

            int left = i + 1;
            int right = nums.length - 1;
            while(left < right){
                int sum = nums[i] + nums[left] + nums[right];
                if(sum == 0){
                    result.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    while(left < right && nums[left] == nums[left+1]) left++;
                    while(left < right && nums[right] == nums[right-1]) right--;
                    left++;
                    right--;
                }else if (sum < 0){
                    left++;
                }else{
                    right--;
                }
            }
        }
        return result;
    }

}
