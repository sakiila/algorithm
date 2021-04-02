package me.bob.sort;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {2, 5, 43, 51, 1, 3, 6, 20, 18};
        int n = arr.length;

        sort(arr, 0, n - 1);

        System.out.println(Arrays.toString(arr));
    }

    private static void sort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int pivot = partition(arr, left, right);
        sort(arr, left, pivot - 1);
        sort(arr, pivot + 1, right);
    }

    private static int partition(int[] arr, int left, int right) {
        int counter = left;
        for (int i = left; i < right; i++) {
            if (arr[i] < arr[right]) {
                int temp = arr[counter];
                arr[counter] = arr[i];
                arr[i] = temp;
                counter++;
            }
        }

        int temp = arr[right];
        arr[right] = arr[counter];
        arr[counter] = temp;

        return counter;
    }
}
