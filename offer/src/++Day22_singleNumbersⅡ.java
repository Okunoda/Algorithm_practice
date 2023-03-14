/**
 * @author Okunoda
 * @date 2023年03月14日11:45
 */
class Day22_singleNumbersⅡ {

    /*
     * 参考题解https://leetcode.cn/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-ii-lcof/solution/mian-shi-ti-56-ii-shu-zu-zhong-shu-zi-chu-xian-d-4/
     *
     */

    public int singleNumber(int[] nums) {
        //bit表示计算当前bit位
        int bit = 1 ;
        //这个数组用于统计每一个位置上的bit数为1的的量
        int[] count = new int[32];
        //每次计算完bit数后就算一次结果
        int res = 0;
        for (int i = 0; i < 32; i++) {
            int bitSum = 0;
            for (int num : nums) {
                //如果与运算的结果不等于0，那么则说明当前bit位上存在等于1的数
                if ((bit & num) != 0)
                    bitSum++;
            }
            //如果取余3等于0 ，那么则说明是出现3次的数字，反之则是包含出现一次的数字
            count[i] = bitSum % 3;
            res = res + count[i]*bit;
            bit<<=1;
        }
        return res;
    }
}
