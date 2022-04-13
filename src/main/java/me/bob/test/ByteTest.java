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
        private static final ThreadLocal<Object> threadLocal = new ThreadLocal<Object>(){
            /**
             * ThreadLocal没有被当前线程赋值时或当前线程刚调用remove方法后调用get方法，返回此方法值
             */
            @Override
            protected Object initialValue()
            {
                System.out.println("调用get方法时，当前线程共享变量没有设置，调用initialValue获取默认值！");
                return null;
            }
        };
    }
    
    @Override
    public int test() {
        return A.super.test();
    }
}
