package me.bob.test;

import java.util.*;
import java.util.concurrent.locks.ReentrantLock;

public class ByteTest {


    public static void main(String[] args) {
        String s1 = new String("计算机");
        String s2 = s1.intern();
        String s3 = "计算机";
        System.out.println(s2);//计算机
        System.out.println(s1 == s2);//false，因为一个是堆内存中的 String 对象一个
        System.out.println(s3 == s2);//true，因为两个都是常量池中的 String 对象
    }
}
