package okunoda;

import java.util.HashMap;

/**
 * @author Erywim 2024/6/22
 */
public class Medium_SubarraySum {
    /**
     * 前缀和+哈希表
     * 时间O(N) 空间O(N)
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        Integer preSum = 0;
        Integer count = 0;
        for (int num : nums) {
            preSum += num;
            count += map.getOrDefault(preSum - k, 0);

            map.put(preSum,map.getOrDefault(preSum,0) + 1);
        }
        return count;
    }


    /**
     * 暴力解法，O(N²)
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum1(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int tempSum = nums[i];
            if(tempSum == k){
                count++;
            }
            int i1;
            for (i1 = i+1; i1 < nums.length; i1++) {
                tempSum += nums[i1];
                if(tempSum == k){
                    count++;

                }
            }

        }
        return count;
    }
}
