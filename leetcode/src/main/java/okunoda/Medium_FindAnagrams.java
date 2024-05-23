package okunoda;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Erywim 2024/5/23
 */
public class Medium_FindAnagrams {
    public static void main(String[] args) {
        List<Integer> anagrams = findAnagrams("baa", "aa");
        List<Integer> anagrams1 = findAnagrams("cbaebabacd", "abc");
        System.out.println(anagrams);
        System.out.println(anagrams1);
    }

    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        //1. 首先建立一个24大小的数组作为滑动窗口
        int[] wordTemplate = new int[26];
        int[] current;
        char[] charArray = s.toCharArray();
        char[] subCharArr = p.toCharArray();
        for (int i = 0; i < subCharArr.length; i++) {
            wordTemplate[subCharArr[i]-'a']++;
        }

        for (int i = 0; i < charArray.length; i++) {
            int idx = charArray[i] - 'a';
            if(wordTemplate[idx] > 0){
                boolean anagrams = true;
                current = new int[26];
                for (int i1 = 0, k = i; i1 < subCharArr.length && k < charArray.length; i1++,k++) {
                    int kdx = charArray[k] - 'a';
                    if(wordTemplate[kdx] == 0 || current[kdx] >= wordTemplate[kdx]){
                        anagrams = false;
                        break;
                    }else if(current[kdx] < wordTemplate[kdx]){
                        current[kdx]++;
                    }
                }
                for (int i1 = 0; i1 < wordTemplate.length; i1++) {
                    if(wordTemplate[i1] != current[i1]){
                        anagrams = false;
                        break;
                    }
                }
                if(anagrams){
                    res.add(i);
                }
            }
        }
        return res;
    }
}
