/**
 * @author Okunoda
 * @date 2023年03月14日10:47
 */
class Day22_singleNumbers {


    /*作者：jyd
    链接：https://leetcode.cn/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-lcof/solution/jian-zhi-offer-56-i-shu-zu-zhong-shu-zi-tykom/
    来源：力扣（LeetCode）
    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
    class Solution {
        public int[] singleNumbers(int[] nums) {
            int x = 0, y = 0, n = 0, m = 1;
            //异或就像连连看，相同的就会消失为0，所以异或遍历一次剩下的就是其中两个不一样的数异或出来的结果，其结果必定有某个位置是不一样的，也就是为1
            for(int num : nums)               // 1. 遍历异或
                n ^= num;
            //而后m的任务就是找出这个1的位置，用这个位置将整个数组分成两部分，每一个部分包含一个出现一次的数字
            while((n & m) == 0)               // 2. 循环左移，计算 m
                m <<= 1;
            for(int num: nums) {              // 3. 遍历 nums 分组
                if((num & m) != 0) x ^= num;  // 4. 当 num & m != 0
                else y ^= num;                // 4. 当 num & m == 0
            }

            return new int[] {x, y};          // 5. 返回出现一次的数字
        }
    }


}
