package com.kang.utils;

/**
 * @Author：zeqi
 * @Date: Created in 21:08 9/1/18.
 * @Description:
 */
public class Assert {

    public static <T> void assertNotNull(T t,String message) {
        if (t == null) {
            throw new IllegalArgumentException(message);
        }
    }

    public static void hasText(String str,String message) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException(message);
        }
    }
}
