package me.bob.test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.LockSupport;

public class ByteTest implements A, B {


    public static void main(String[] args) {

    }
    
    @Override
    public int test() {
        return A.super.test();
    }
}
