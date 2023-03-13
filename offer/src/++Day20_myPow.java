/**
 * @author Okunoda
 * @date 2023年03月13日11:25
 */
 class Day20_myPow {
/*    作者：jyd
    链接：https://leetcode.cn/problems/shu-zhi-de-zheng-shu-ci-fang-lcof/solution/mian-shi-ti-16-shu-zhi-de-zheng-shu-ci-fang-kuai-s/
    来源：力扣（LeetCode）
    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/

    class Solution {
        public double myPow(double x, int n) {
            if(x == 0) return 0;
            long b = n;
            double res = 1.0;
            if(b < 0) {
                x = 1 / x;
                b = -b;
            }
            while(b > 0) {
                //b和1按位与，检查最后一位是否是1 ，也就是这个数是否是奇数
                //因为快速幂是二分取余，所以当幂为奇数的时候就会多出一个x，故提前乘一个x
                if((b & 1) == 1) res *= x;
                x *= x;
                b >>= 1;
            }
            return res;
        }
    }




    //超时写法
//    public double myPow(double x, int n) {
//        double multiplier = 0;
//        multiplier = n>0? x: 1/x;
//        int m = n>0?n:-n;
//        double result = 1.0;
//        while(m-->0)
//            result *= multiplier;
//        return result;
//    }

}
