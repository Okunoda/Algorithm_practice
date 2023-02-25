import java.util.HashMap;
import java.util.Map;

/**
 * @author Okunoda
 * @date 2023年02月25日16:42
 */
public class Day5_firstUniqChar {
    public char firstUniqChar(String s) {
        if(s==null)return ' ';
        int[] count = new int[26];
        char[] chs = s.toCharArray();
        for (char ch : chs) {
            count[ch - 'a']++;
        }
        for(char ch :chs){
            if(count[ch-'a']==1)
                return ch;
        }
        return ' ';
    }
}
