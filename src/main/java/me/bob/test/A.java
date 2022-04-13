package me.bob.test;

public interface A {
    default int test() {
        return 1;
    }
}
