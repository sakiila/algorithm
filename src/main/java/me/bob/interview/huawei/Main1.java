package me.bob.interview.huawei;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();

        Map<Integer, Integer> map = new HashMap<>();
        while (sc.hasNext()) {
            int i = sc.nextInt();
            list.add(i);
            map.put(i, map.getOrDefault(i, 0) + 1);
        }


        for (Integer i : list) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
//        System.out.println("map = " + map);

        int max = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            max = Math.max(max, entry.getValue());
        }
//        System.out.println("max = " + max);

        List<Integer> ans = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == max) {
                ans.add(entry.getKey());
            }
        }
//        System.out.println("ans = " + ans);

        int size = ans.size();
        int result;

        if (size % 2 == 0) {
            result = (ans.get(size / 2) + ans.get(size / 2 - 1)) / 2;
        } else {
            result = ans.get(size / 2);
        }
        System.out.println(result);
    }
}
