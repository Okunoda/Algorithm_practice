package second;

public class Medium_longestPalindrome_sec {

    int ansStart = 0;
    int maxLen = Integer.MIN_VALUE;
    public String longestPalindrome(String s) {
        char[] chs = s.toCharArray();

        for (int i = 0; i < chs.length; i++) {
            palindrome(chs,i,i);
            palindrome(chs,i,i+1);
            if(maxLen == chs.length)
                break;
        }
        return s.substring(ansStart,ansStart + maxLen);
    }

    private void palindrome(char[] chs , int start , int end){
        while (start >= 0 && end < chs.length && chs[start] == chs[end]) {
            start--;
            end++;
        }

        int curLen = end - start - 1;
        if(curLen > maxLen){
            ansStart = start + 1;
            maxLen = curLen;
        }
    }
}
