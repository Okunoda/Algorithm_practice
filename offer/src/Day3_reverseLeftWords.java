import java.util.Arrays;

/**
 * @author Okunoda
 * @date 2023年02月24日16:31
 */
public class Day3_reverseLeftWords {
    public String reverseLeftWords(String s, int n) {
        char[] chars = s.toCharArray();
        int length = chars.length;
        reverse(chars,0,n-1);
        reverse(chars,n, length -1);
        reverse(chars,0, length -1);
        return Arrays.toString(chars);
    }
    private void reverse(char[] chs,int left,int right){
        while(left<right){
            char temp = chs[left];
            chs[left++] = chs[right];
            chs[right--] = temp;
        }
    }
}
