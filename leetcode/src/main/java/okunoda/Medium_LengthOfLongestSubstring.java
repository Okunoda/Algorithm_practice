package okunoda;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * @author Erywim 2024/5/15
 */
public class Medium_LengthOfLongestSubstring {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
        System.out.println(lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring(" 1"));
    }


    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        int maxLength = -1;
        int windowStart = 0;
        int[] wordCount = new int[1000];
        Arrays.fill(wordCount, -1);
        //滑动窗口思路，如果当前正在操作的项在窗口中已经存在了，那么窗口往后滑动到相同元素的第一个的后面一位
        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            int index = charArray[i];
            if (wordCount[index] != -1) {
                if (i - windowStart > maxLength) {
                    maxLength = i - windowStart;
                }
                int oldIndex = windowStart;
                windowStart = wordCount[index] + 1;
                for (int j = oldIndex; j <= wordCount[index]; j++) {
                    wordCount[charArray[j]] = -1;
                }
            }
            wordCount[index] = i;
        }
        //对结果进行运算，所有不为-1的项就是无重复长度
        int t = 0;
        for (int i : wordCount) {
            if(i != -1){
                if(++t >maxLength){
                    maxLength = t;
                }
            }
        }

        return maxLength;
    }
}
