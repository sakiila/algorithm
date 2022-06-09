package me.bob.interview.huawei;

import java.util.Scanner;

public class Template {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int i = 0;
        for (int j = s.length() - 1; j >= 0; j--) {
            if (s.charAt(j) == ' ') {
                break;
            }
            i++;
        }
        System.out.println(i);
    }
}
