package me.baobo.test;

public class ThreadTest {
    public static void main(String[] args) {
        while (true) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName());
            }).start();
        }
    }
}
