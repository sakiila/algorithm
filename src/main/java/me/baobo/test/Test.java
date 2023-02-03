package me.baobo.test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Bob
 */
public class Test {
    
    public static void main(String[] args) {
        String temp = "23";
        
        List<String> list = new ArrayList<>();
        boolean b = list.stream()
            // .map(String::length)
            // .anyMatch(len -> len == 2);
            .allMatch(str -> str.equals(temp));
        System.out.println("b = " + b);
    }
}
