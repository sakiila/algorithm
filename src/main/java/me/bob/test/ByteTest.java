package me.bob.test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ByteTest {


    public static void main(String[] args) {
        int[] arr = {0, 5, 3, 8};

        int res = Integer.MIN_VALUE;
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            res = Math.max(res, max - arr[i]);
            max = Math.max(max, arr[i]);
        }
        System.out.println("res = " + res);
    }
}
