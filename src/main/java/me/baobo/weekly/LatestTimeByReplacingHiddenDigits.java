package me.baobo.weekly;

public class LatestTimeByReplacingHiddenDigits {
    public static void main(String[] args) {
        String s = maximumTime("??:3?");
        System.out.println("s = " + s);
    }

    public static String maximumTime(String time) {
        char[] chars = time.toCharArray();
        if (chars[0] == '?' && chars[1] == '?') {
            chars[0] = '2';
        } else if (chars[0] == '?' && chars[1] != '?' && chars[1] < '4') {
            chars[0] = '2';
        } else if (chars[0] == '?' && chars[1] != '?' && chars[1] >= '4') {
            chars[0] = '1';
        }
        if (chars[0] == '0' || chars[0] == '1') {
            chars[1] = chars[1] == '?' ? '9' : chars[1];
        } else if (chars[0] == '2') {
            chars[1] = chars[1] == '?' ? '3' : chars[1];
        }

        if (chars[3] == '?') {
            chars[3] = '5';
        }
        if (chars[4] == '?') {
            chars[4] = '9';
        }
        String res = new String();
        for (char c : chars) {
            res += c;
        }

        return res;
    }
}
