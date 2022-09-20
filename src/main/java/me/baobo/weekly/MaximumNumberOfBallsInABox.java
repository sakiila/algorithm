package me.baobo.weekly;

import java.util.HashMap;

public class MaximumNumberOfBallsInABox {
    public static void main(String[] args) {
        int i = countBalls(1, 10);
        System.out.println("i = " + i);
    }

    public static int countBalls(int lowLimit, int highLimit) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = lowLimit; i <= highLimit; i++) {
            int temp = i;
            int res = 0;
            while (temp != 0) {
                res += temp % 10;
                temp /= 10;
            }
            map.put(res, map.getOrDefault(res, 0) + 1);
        }

        int max = Integer.MIN_VALUE;
        for (Integer value : map.values()) {
            max = Math.max(max, value);
        }

        return max;
    }
}
