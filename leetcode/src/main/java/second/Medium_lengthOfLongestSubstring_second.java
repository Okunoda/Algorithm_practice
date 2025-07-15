package second;

import java.util.HashSet;

public class Medium_lengthOfLongestSubstring_second {
    public int lengthOfLongestSubstring(String s) {
        //1. 首先有个滑动窗口，找到这个滑动窗口找到第一个出现重复元素的子串
        //2. 记录当前的长度，然后收缩尾巴，直到把重复元素踢出去，再开始延伸头部
        if(s.isEmpty())
            return 0;
        char[] charArr = s.toCharArray();

        HashSet<Character> set = new HashSet<>();
        int left = 0,right = 0;
        int maxLen = Integer.MIN_VALUE;

        while(right < charArr.length){
            char currentChar = charArr[right];

            if(set.contains(currentChar)){
                int curLen = right - left;
                if(curLen > maxLen){
                    maxLen = curLen;
                }

                while(left <= right){
                    char c = charArr[left++];
                    set.remove(c);
                    if(c == currentChar)
                        break;
                }
            }
            set.add(currentChar);
            right++;
        }
        return Math.max(right - left, maxLen);
    }
}
