import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @author Okunoda
 * @date 2023年02月28日10:28
 */
 class Day10_lengthOfLongestSubstring {
//    public int lengthOfLongestSubstring(String s) {
//        char[] chs = s.toCharArray();
//        int[] dp = new int[chs.length];
//        HashSet<Character> set = new HashSet<>();
//        dp[0] = 1;
//        set.add(chs[0]);
//        for(int i = 1 ; i < chs.length ; i++){
//            if(set.contains(chs[i])){
//                dp[i] = dp[i-1];
//
//            }else{
//                set.add(chs[i]);
//                dp[i] = dp[i-1] +1;
//            }
//        }
//        return dp[chs.length-1];
//
//    }


//    作者：jyd
//    链接：https://leetcode.cn/problems/zui-chang-bu-han-zhong-fu-zi-fu-de-zi-zi-fu-chuan-lcof/solution/mian-shi-ti-48-zui-chang-bu-han-zhong-fu-zi-fu-d-9/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    //思路大致是找出一对相同的字符，i和j。
    //然后判断 ij中间夹住的长度 和 到 j-1 为止的最长不重复子串长度 谁大
    //如果 到 j-1 为止的最长不重复子串长度大，则说明ij是完全被包含在j-1位置的最长字串内部的，则可以舍去前面的字符i，从i+1到j ，即 dp[j] = dp[j-1] + 1
    //如果 ij字串大 则说明 j-1位置的最长字串 是不包含前面的i的，所以可以直接 dp[j] = dp[j-1] + 1
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> dic = new HashMap<>();
        int res = 0, tmp = 0;
        for(int j = 0; j < s.length(); j++) {
            int i = dic.getOrDefault(s.charAt(j), -1); // 获取索引 i
            dic.put(s.charAt(j), j); // 更新哈希表
            tmp = tmp < j - i ? tmp + 1 : j - i; // dp[j - 1] -> dp[j]
            res = Math.max(res, tmp); // max(dp[j - 1], dp[j])
        }
        return res;
    }


    public static void main(String[] args) {
        System.out.println(new Day10_lengthOfLongestSubstring().lengthOfLongestSubstring("abcabcbb"));
    }
}
