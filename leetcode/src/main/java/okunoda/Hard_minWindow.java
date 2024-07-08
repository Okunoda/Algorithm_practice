package okunoda;

/**
 * @author Erywim 2024/6/26
 */
public class Hard_minWindow {
    public static void main(String[] args) {

    }

    /**
     * 参考题解
     *   作者：灵茶山艾府
     *     链接：https://leetcode.cn/problems/minimum-window-substring/solutions/2713911/liang-chong-fang-fa-cong-o52mn-dao-omnfu-3ezz/
     *
     * @param s
     * @param t
     * @return
     */
    public String minWindow(String s, String t) {
        if(s.length() < t.length()) {
            return "";
        }
        int left = 0;
        int ansLeft = -1;
        int ansRight = s.length();
        int[] cntTarget = new int[128];
        int[] cntSource = new int[128];
        int wordType = 0;
        char[] sourceChar = s.toCharArray();

        char[] target = t.toCharArray();
        for (char c : target) {
            if(cntTarget[c]++ == 0){
                wordType++;
            }

        }
        for (int right = 0; right < sourceChar.length; right++) {
            cntSource[sourceChar[right]]++;
            if(cntSource[sourceChar[right]] == cntTarget[sourceChar[right]]){
                wordType--;
            }
            while(wordType == 0){
//                if (isCover(cntTarget, cntSource)) {
                    if (right - left < ansRight - ansLeft) {
                        ansLeft = left;
                        ansRight = right;
                    }
//                }

                if (--cntSource[sourceChar[left]] < cntTarget[sourceChar[left]]) {
                    wordType++;
                }
                left++;
            }
        }
        return ansLeft < 0 ? "" : s.substring(ansLeft, ansRight + 1);
    }

    private boolean isCover(int[] cntTarget, int[] cntSource) {
        for (int i = 'A'; i <= 'Z'; i++) {
            if(cntSource[i] < cntTarget[i]){
                return false;
            }
        }
        for (int i = 'a'; i <= 'z'; i++) {
            if(cntSource[i] < cntTarget[i]){
                return false;
            }
        }
        return true;
    }
}
