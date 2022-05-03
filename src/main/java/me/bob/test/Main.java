package me.bob.test;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine().toLowerCase();
        char target = sc.nextLine().toLowerCase().toCharArray()[0];
        int index = 0;
        for (char c : str.toCharArray()) {
            if (c == target) {
                index++;
            }
        }
        System.out.println(index);
    }
}
