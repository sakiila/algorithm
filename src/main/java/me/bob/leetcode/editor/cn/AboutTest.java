package me.bob.leetcode.editor.cn;

import java.util.Arrays;

public class AboutTest {
    public static void main(String[] args) {
        int[] tmp = new int[]{1, 3, 5, 2};
        int[] tmp2 = new int[tmp.length + 2];

        System.arraycopy(tmp, 0, tmp2, 1, tmp.length);
        System.out.println(Arrays.toString(tmp2));

        int[] ints = Arrays.copyOf(tmp, 5);
        System.out.println("Arrays.toString(ints) = " + Arrays.toString(ints));

    }
}
