package com.hillel.homework.hw8.linkedList.stackQueue;

import java.util.Arrays;

public class MyQueueArray {
    private int size;
    private String[] strings = new String[size];

    public MyQueueArray() {
    }

    public boolean add(String str) {
        String[] newStrings = new String[size + 1];
        System.arraycopy(strings, 0, newStrings, 0, strings.length);
        strings = newStrings;

        strings[size] = str;
        size++;
        return true;
    }

    public String poll() {
        if (size < 1) return null;
        String str= strings[0];
        String[] newStrings = new String[size - 1];
        System.arraycopy(strings,1,newStrings,0,newStrings.length);
        strings = newStrings;
        size--;
        return str;
    }

    public String peek(){
        if (size < 1) return null;
        return strings[0];
    }

    @Override
    public String toString() {
        return Arrays.toString(strings);
    }
}
