package second;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @Date 2025/2/24
 */
public class Medium_checkInclusion {
    public static void main(String[] args) {
        String s1 = "abcdxabcde";
        String s2 = "abcdeabcdx";
        System.out.println(checkInclusion(s1, s2));
    }
    public static boolean checkInclusion(String s1, String s2) {
        Map<Character,Integer> need = new HashMap<>();
        Map<Character,Integer> window = new HashMap<>();

        for (char c : s1.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        boolean result =false;
        int len = 0;
        int right = 0,left = 0;
        while(right < s2.length()){

            char rightChar = s2.charAt(right);
            if(need.containsKey(rightChar)){
                window.put(rightChar, window.getOrDefault(rightChar, 0) + 1);
                if (window.get(rightChar) <= need.get(rightChar)) {
                    len++;
                }
            }
            right++;

            if(len == s1.length()){
                while(right - left > s1.length()){
                    char leftChar = s2.charAt(left);
                    if(need.containsKey(leftChar)){
                        window.put(leftChar, window.get(leftChar) - 1);
                        if(need.get(leftChar) > window.get(leftChar)){
                            len--;
                            left++;
                            break;
                        }
                    }
                    left++;
                }
                if(len == s1.length()){
                    return true;
                }
            }
        }
        return false;
    }
}
