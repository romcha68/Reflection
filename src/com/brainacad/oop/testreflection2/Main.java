package com.brainacad.oop.testreflection2;

import java.lang.reflect.Field;


public class Main {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        String myStr = new String("abcd");

        System.out.println("Before: " + myStr);

        Field stringValue = myStr.getClass().getDeclaredField("value");
        stringValue.setAccessible(true);
        stringValue.set(myStr, new char[]{'z', 'x', 'c', 'v'});

        System.out.println("After: " + myStr);

        System.out.println("abcd");
    }
}
