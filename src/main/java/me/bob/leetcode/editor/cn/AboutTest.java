package me.bob.leetcode.editor.cn;

public class AboutTest {

    public static void main(String[] args) {
        int i = 1;
        int j = ~i;
        System.out.println("i = " + i);
        System.out.println("j = " + j);
    }

    public static boolean check(int[] nums) {
        int window = nums.length;
        int[] arr = new int[window * 2];
        System.arraycopy(nums, 0, arr, 0, window);
        System.arraycopy(nums, 0, arr, window, window);

        for (int i = 0; i < window; i++) {
            if (isSorted(arr, i, i + window)) {
                return true;
            }
        }

        return false;
    }

    private static boolean isSorted(int[] arr, int a, int b) {
        for (int j = a; j < b - 1; j++) {
            if (arr[j] > arr[j + 1]) {
                return false;
            }
        }
        return true;
    }


}
