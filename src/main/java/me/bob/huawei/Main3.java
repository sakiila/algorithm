package me.bob.huawei;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> list = new ArrayList<>();
        while (sc.hasNext()) {
            list.add(sc.next());
        }
        String patterString = list.get(list.size() - 1);

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < list.size() - 1; i++) {
            String temp = list.get(i);
            if (temp.matches(patterString)) {
                res.add(i);
            }
        }

        StringBuilder ans = new StringBuilder();
        for (Integer re : res) {
            ans.append(re).append(",");
        }
        if (ans.length() > 0) {
            ans.deleteCharAt(ans.length() - 1);
        }
        System.out.println(ans);
    }
}
