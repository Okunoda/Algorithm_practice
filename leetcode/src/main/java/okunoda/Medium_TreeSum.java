package okunoda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Okunoda 2024/3/23
 */
public class Medium_TreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        ArrayList<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        if (nums.length < 3 || nums[0] > 0) {
            return result;
        }
        int k = 0;
        while (k < nums.length - 2) {
            if (k > 0 && nums[k] == nums[k - 1]) {
                k++;
                continue;
            }
            int i = k + 1;
            int j = nums.length - 1;
            while (i < j) {
                int sum = nums[k] + nums[i] + nums[j];
                if(sum == 0) {
                    result.add(new ArrayList<Integer>(Arrays.asList(nums[k], nums[i], nums[j])));
                    while(i < j && nums[i] == nums[++i]);
                    while( j > i &&nums[j] == nums[--j]);
                }else if(sum < 0) {
                    while(i < j && nums[i] == nums[++i]);
                }else {
                    while( j > i &&nums[j] == nums[--j]);
                }
            }
            k++;
        }
        return result;
    }
}
