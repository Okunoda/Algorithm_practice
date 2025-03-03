package second;

import java.util.HashMap;
import java.util.Map;

/**
 * @Date 2025/2/24
 */
public class Medium_lengthOfLongestSubstring {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("tmmzuxt"));
    }
    public static int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> charMap = new HashMap<>();

        int left = 0 , right = 0;
        int maxLen = Integer.MIN_VALUE;

        while(right < s.length()){
            char charAt = s.charAt(right++);
            Integer count = charMap.getOrDefault(charAt, 0);
            if(count == 0){
                charMap.put(charAt,1);
            }else{
                maxLen = Math.max(maxLen, right - left - 1);
                //左边界收缩到重复字符的位置
                while(left <= right){
                    char c = s.charAt(left++);
                    if(c == charAt){
                        break;
                    }else{
                        charMap.put(c,0);
                    }
                }
            }
        }
        return Math.max(right-left,maxLen);
    }
}
