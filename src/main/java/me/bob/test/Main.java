package me.bob.test;

import com.sun.xml.internal.ws.encoding.soap.SerializationException;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        String a = "hello2";
        final String b = "hello";
        String c = "hello";
        System.out.println((b == c)); // true
        String d = b + 2;
        String e = c + 2;
        System.out.println((a == d)); // true
        System.out.println((a == e)); // false
    }
}
