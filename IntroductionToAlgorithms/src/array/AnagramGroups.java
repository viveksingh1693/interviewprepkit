package array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnagramGroups {

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Map<String, Integer> hm = new HashMap<>();
        for (String str : strs) {
            String key = getHash(str);
            if (!hm.containsKey(key)) {
                hm.put(key, result.size());
                result.add(new ArrayList<>());
            }
            result.get(hm.get(key)).add(str);
        }
        return result;
    }

    public static String getHash(String str) {
        int[] freq = new int[26];
        StringBuilder hash = new StringBuilder();
        for (int j = 0; j < str.length(); j++) {
            freq[str.charAt(j) - 97]++;
        }

        for (int j : freq) {
            hash.append(j);
            hash.append("$");
        }
        return hash.toString();
    }

    public static void main(String[] args) {
        System.out.println(Integer.valueOf('a'));
    }
}
