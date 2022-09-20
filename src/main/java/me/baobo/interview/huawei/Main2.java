package me.baobo.interview.huawei;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Main2 {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int size = sc.nextInt();
//        int[] arr = new int[size];
//        for (int i = 0; i < size; i++) {
//            arr[i] = sc.nextInt();
//        }

        int[] arr = {123, 124, 125, 121, 119, 122, 126, 123};
        int size = arr.length;
        int[] res = new int[size];

//        List<Integer> res = new ArrayList<>();
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < size; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                res[stack.pop()] = i;
            }
            stack.push(i);
        }
        System.out.println("Arrays.toString(res) = " + Arrays.toString(res));
//        res.add(0);
//        for (Integer re : res) {
//            System.out.print(re + " ");
//        }
    }
}
