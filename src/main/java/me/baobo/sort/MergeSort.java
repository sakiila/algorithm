package me.baobo.sort;

import java.util.Arrays;

public class MergeSort {

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
        int mid = left + (right - left) / 2;
        sort(arr, left, mid);
        sort(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = 0;
        int a = left;
        int b = mid + 1;

        while (a <= mid && b <= right) {
            temp[i++] = arr[a] < arr[b] ? arr[a++] : arr[b++];
        }
        while (a <= mid) {
            temp[i++] = arr[a++];
        }
        while (b <= right) {
            temp[i++] = arr[b++];
        }

        for (int j = 0; j < temp.length; j++) {
            arr[left + j] = temp[j];
        }
    }
}
