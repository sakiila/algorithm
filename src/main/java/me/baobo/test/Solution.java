package me.baobo.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Solution {
    public String rankTeams(String[] votes) {
        int length = votes[0].length();
        Map<Character, int[]> allMap = new HashMap();

        for (String str : votes) {
            char[] cs = str.toCharArray();
            for (int i = 0; i < cs.length; i++) {
                int[] value = allMap.getOrDefault(cs[i], new int[length]);
                value[i]++;
                allMap.put(cs[i], value);
            }
        }

        ArrayList<Map.Entry<Character, int[]>> list = new ArrayList<>(allMap.entrySet());
        Collections.sort(list, (a, b) -> {
            int[] a1 = a.getValue();
            int[] b1 = b.getValue();
            for (int i = 0; i < a1.length; i++) {
                if (a1[i] != b1[i]) {
                    return b1[i] - a1[i];
                }
            }
            return a.getKey() - b.getKey();
        });

        return list.stream()
                .map(entry -> entry.getKey().toString())
                .collect(Collectors.joining());

    }
}