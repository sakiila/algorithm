package me.bob.test;

public interface B {
    default int test() {
        return 2;
    }
}
