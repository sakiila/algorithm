package me.baobo.test;

public class Test {

    public static void main(String[] args) {
        String a = "abcde";

        StringBuilder res = new StringBuilder();

        while (a.length() != 0) {
            res.append(a.charAt(0));
            a = a.substring(1);
            if (a.length() == 1) {
                continue;
            }
            if (a.length() == 0) {
                break;
            }
            String substring = a.substring(0, 1);
            
            a = a.substring(1).concat(substring);
        }

        System.out.println("res = " + res);
    }
}
