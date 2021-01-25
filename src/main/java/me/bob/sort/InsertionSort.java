package me.bob.sort;

import java.util.Arrays;

public class InsertionSort {

    public static void main(String[] args) {
        int[] arr = {2, 5, 43, 51, 1, 3, 6, 20, 18};
        int n = arr.length;

        for (int i = 1; i < n; i++) {
            int cur = arr[i];
            int preIndex = i - 1;
            while (preIndex >= 0 && arr[preIndex] > cur) {
                arr[preIndex + 1] = arr[preIndex];
                preIndex--;
            }
            arr[preIndex + 1] = cur;
        }

        System.out.println(Arrays.toString(arr));
    }
}
