/**
 * @author Okunoda
 * @date 2023年03月10日11:32
 */
 class Day19_sumNums {

    //这题限制的太死了，判断，循环都不能用
    //这种逻辑符短路居然还能这样用，大开眼界
    class Solution {
        int res = 0;
        public int sumNums(int n) {
            boolean x = n > 1 && sumNums(n - 1) > 0;
            res += n;
            return res;
        }
    }

    /*作者：jyd
    链接：https://leetcode.cn/problems/qiu-12n-lcof/solution/mian-shi-ti-64-qiu-1-2-nluo-ji-fu-duan-lu-qing-xi-/
    来源：力扣（LeetCode）
    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
}
