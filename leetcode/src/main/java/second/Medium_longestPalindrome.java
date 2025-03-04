package second;

public class Medium_longestPalindrome {


    int maxLen = Integer.MIN_VALUE;
    String result = "";
    public String longestPalindrome(String s){
        String res = "";

        for (int i = 0; i < s.toCharArray().length; i++) {
//            String s1 = palindrome(s,i,i);
//            String s2 = palindrome(s,i,i+1);

//            res = res.length()>s1.length()?res:s1;
//            res = res.length()>s2.length()?res:s2;

            int s1 = palindrome(s,i,i);
            int s2 = palindrome(s,i,i+1);

            if(s1 == s.length() || s2 == s.length()) return result;
        }
        return result;
    }


    public int palindrome(String s , int low ,int high){
        while(low >= 0 && high < s.length() && s.charAt(low) == s.charAt(high)){
            low--;
            high++;
        }

        if (maxLen < high - low - 1) {
            maxLen = high - low -1;
            result = s.substring(low+1,high);
        }


        return high-low-1;
    }



}
