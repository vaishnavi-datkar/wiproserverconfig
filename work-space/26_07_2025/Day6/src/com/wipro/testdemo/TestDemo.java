package com.wipro.testdemo;

public class TestDemo {

    public static boolean isUpperCase(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        return str.equals(str.toUpperCase());
    }
}
