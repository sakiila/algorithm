package me.bob.leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;

public class AboutTest {
    public static void main(String[] args) {

        Deque<Integer> deque = new ArrayDeque<>();
        deque.addFirst(1);
        deque.addLast(2);
        deque.addLast(3);
        System.out.println("deque = " + deque);

        deque.removeLast();
        System.out.println("deque = " + deque);

        Integer integer = deque.peekFirst();
        System.out.println("integer = " + integer);

        while (deque.peek() != null) {
            System.out.println("deque.pop() = " + deque.pop());
        }
        System.out.println(System.lineSeparator());
        System.out.println("deque = " + deque);
    }
}
