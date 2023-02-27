/**
 * @author Okunoda
 * @date 2023年02月27日19:22
 */
public class Day8_maxProfit {
    //暴力解法，可以ac，但是不推荐，想不出dp解法
    public int maxProfit(int[] prices) {

        int max = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i; j < prices.length; j++) {
                if (prices[j] - prices[i] > max) {
                    max = prices[j] - prices[i];
                }
            }
        }
        return max;
    }

    //dp解法耗时明显提升
    //作者：jyd
    //链接：https://leetcode.cn/problems/gu-piao-de-zui-da-li-run-lcof/solution/mian-shi-ti-63-gu-piao-de-zui-da-li-run-dong-tai-2/
    //来源：力扣（LeetCode）
    //著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    public int maxProfit_dpSolution(int[] prices) {
        int cost = Integer.MAX_VALUE, profit = 0;
        for (int price : prices) {
            cost = Math.min(cost, price);//记录第i日之前的最低价格
            profit = Math.max(profit, price - cost);//比较第i日卖出去和前i日的最大利润，可以用闫式dp理解成状态计算的步骤
        }
        return profit;
    }
}
