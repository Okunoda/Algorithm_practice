package second;

import java.util.HashMap;
import java.util.Map;

/**
 * @Date 2025/2/24
 */
public class Hard_MinWindow {
    /**
     * 毛毛虫滑动窗口
     * @param args
     */
    public static void main(String[] args) {
        String s = "a";
        String t = "aa";
        String s1 = minWindow(s, t);
        System.out.println(s1);
    }
    public static String minWindow(String s, String t) {
        char[] sourceChars = s.toCharArray();
        Map<Character,Integer> needChars = new HashMap<>();
        Map<Character,Integer> currentChars = new HashMap<>();

        for (char c : t.toCharArray()) {
            needChars.put(c, needChars.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0;
        int len = 0;
        int start = 0;
        int minLen = Integer.MAX_VALUE;
        while(right < s.length()){
            //持续扩大窗口，直到包含所有t元素
            char sourceChar = sourceChars[right];

            if(needChars.containsKey(sourceChar)){
                Integer i = currentChars.getOrDefault(sourceChar,0);

                if(i < needChars.get(sourceChar)){
                    len++;
                }
                currentChars.put(sourceChar,i+1);
            }

            while(len == t.length()){
                if(right - left < minLen){
                    start = left;
                    minLen = right - left;
                }

                char leftChar = sourceChars[left];
                if(needChars.containsKey(leftChar)){
                    currentChars.put(leftChar, currentChars.get(leftChar) - 1);
                    if(currentChars.get(leftChar) < needChars.get(leftChar)){
                        len--;
                    }
                }
                left++;
            }

            right++;
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen+1);
    }
}
