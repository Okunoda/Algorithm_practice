import java.util.Arrays;

/**
 * @author Okunoda
 * @date 2023年03月09日21:13
 */
class Day16_minNumber {
    /*
        作者：jyd
        链接：https://leetcode.cn/problems/ba-shu-zu-pai-cheng-zui-xiao-de-shu-lcof/solution/mian-shi-ti-45-ba-shu-zu-pai-cheng-zui-xiao-de-s-4/
        来源：力扣（LeetCode）
        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/

    //主要是找出一个比较规则
    //这里用的是 如果x+y > y+x 则 x “大于” y，即x排在y的后面，反之相反
    class Solution {
        public String minNumber(int[] nums) {
            String[] strs = new String[nums.length];
            for (int i = 0; i < nums.length; i++)
                strs[i] = String.valueOf(nums[i]);

            Arrays.sort(strs, (x, y) -> (x + y).compareTo(y + x));
            StringBuilder res = new StringBuilder();
            for (String s : strs)
                res.append(s);
            return res.toString();
        }
    }


}
