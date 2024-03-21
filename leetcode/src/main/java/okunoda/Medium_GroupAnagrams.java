package okunoda;

import java.util.*;

/**
 * @author Okunoda 2024/3/21
 */
public class Medium_GroupAnagrams {
    class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            // 哈希表用来存储 对应排序后的字符串 && 与该字符串变位词的List集合;
            Map<String , List<String>> hashmap = new HashMap<>();
            List<List<String>> result = new ArrayList<>();
            for (String str : strs) {
                // 对于字符串str进行排序，得到字符串str排序后的字符串s;
                char[] array = str.toCharArray();
                Arrays.sort(array);
                String s = new String(array);
                // 哈希表中存在该排序后的字符串;
                if(hashmap.containsKey(s)){
                    hashmap.get(s).add(str);
                }
                // 哈希表中不存在该排序后的字符串;
                else {
                    List<String> list = new ArrayList<>();
                    list.add(str);
                    result.add(list);
                    hashmap.put(s , list);
                }
            }
            return result;
        }
    }

}
