package me.bob.test;

import java.util.*;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

public class ByteTest {


    public static void main(String[] args) {
        // 初始化许可数为1，A线程可以先执行
        Semaphore semaphoreA = new Semaphore(1);
        // 初始化许可数为0，B线程阻塞
        Semaphore semaphoreB = new Semaphore(1);

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    // A线程获得许可，同时semaphoreA的许可数减为0，进入下一次循环时
                    // A线程会阻塞，直到其他线程执行semaphoreA.release();
                    semaphoreA.acquire();
                    // 打印当前线程名称
                    System.out.println(Thread.currentThread().getName());
                    Thread.sleep(1000);
                    // semaphoreB许可数加1
                    semaphoreB.acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    semaphoreB.acquire();
                    System.out.println(Thread.currentThread().getName());
                    Thread.sleep(1000);
                    semaphoreA.acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
