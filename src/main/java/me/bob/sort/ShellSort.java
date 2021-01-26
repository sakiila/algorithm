package me.bob.sort;

import java.util.Arrays;

public class ShellSort {

    public static void main(String[] args) {
        int[] arr = {2, 5, 43, 51, 1, 3, 6, 20, 18};
        int n = arr.length;

        for (int step = n / 2; step >= 1; step /= 2) {
            for (int i = step; i < n; i++) {
                int cur = arr[i];
                int preIndex = i - step;
                while (preIndex >= 0 && arr[preIndex] > cur) {
                    arr[preIndex + step] = arr[preIndex];
                    preIndex -= step;
                }
                arr[preIndex + step] = cur;
            }
        }

        System.out.println(Arrays.toString(arr));
    }
}
