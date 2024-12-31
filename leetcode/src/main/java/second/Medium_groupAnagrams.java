package second;

import java.util.*;

/**
 * @author Erywim 2024/12/31
 */
public class Medium_groupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String,List<String>> map = new HashMap<>();
        ArrayList<List<String>> result = new ArrayList<>();
        for (String str : strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String sorted = new String(charArray);
            if (!map.containsKey(sorted)) {
                ArrayList<String> value = new ArrayList<>();
                value.add(str);
                map.put(sorted, value);
            }else{
                map.get(sorted).add(str);
            }
        }
        for (Map.Entry<String, List<String>> stringListEntry : map.entrySet()) {
            result.add(stringListEntry.getValue());
        }
        return result;
    }
}
