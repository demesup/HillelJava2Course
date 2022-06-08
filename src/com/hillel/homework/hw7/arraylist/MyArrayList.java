package com.hillel.homework.hw7.arraylist;

public class MyArrayList {
    private int size;
    private String[] strings = new String[size];


    public MyArrayList() {
    }

    public MyArrayList(int size) {
        strings = new String[size];
        this.size = size;
    }

    public String get(int indexGet) {
        try {
            return strings[indexGet];
        } catch (RuntimeException e) {
            System.out.println("Error: " + e.getMessage() + " / Return statement = null");
            return null;
        }
    }

    public void set(int indexSet, String str) {
        if (indexOutBounds(indexSet)) return;
        strings[indexSet] = str;
    }

    public void remove(int indexRemove) {
        try {
            System.arraycopy(strings, indexRemove + 1, strings, indexRemove, size - 1 - indexRemove);
            size--;
            System.out.println("String is removed");
        } catch (RuntimeException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void remove(String str) {
        int indexRemove = indexOf(str);
        remove(indexRemove);
    }

    private int indexOf(String str) {
        for (int i = 0; i < size; i++) {
            if (str.equals(strings[i])) {
                return i;
            }
        }
        return -1;
    }

    public void add(String str) {
        size++;
        if (size >= strings.length) grow();
        strings[size-1] = str;

    }

    private void grow() {
        String[] stringsNew;
        if (strings.length == 0) {
            stringsNew = new String[10];
        } else {
            stringsNew = new String[strings.length * 2];
        }
        System.arraycopy(strings, 0, stringsNew, 0, strings.length);
        strings = stringsNew;

    }

    public boolean add(int indexPaste, String str) {
        if (indexOutBounds(indexPaste)) {
            return false;
        }
        add("0");
        if (size - 1 - indexPaste >= 0)
            System.arraycopy(strings, indexPaste, strings, indexPaste + 1, size - 1 - indexPaste);

        strings[indexPaste] = str;
        return true;
    }

    private boolean indexOutBounds(int index) {
        return index > strings.length - 1 || index < 0;
    }

    @Override
    public String toString() {
        if (strings == null)
            return "null";
        StringBuilder string = new StringBuilder();
        string.append('[');
        for (int i = 0; i < size; i++) {
            string.append(strings[i]);
            if (i == size - 1)
                return string.append(']').toString();
            string.append(", ");
        }
        return null;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean contains(String str) {
        return indexOf(str) >= 0;
    }

}
