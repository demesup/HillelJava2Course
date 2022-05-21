package com.hillel.homework.hw7.arraylist;

public class MyArrayList {
    private int size = 10;
    private String[] strings = new String[size];


    public MyArrayList() {
        size = 0;
    }

    public MyArrayList(int size) {
        strings = new String[size];
        this.size = size;
    }

    public String get(int indexGet) {
        if (!indexOutBounds(indexGet)) return "Error";
        return strings[indexGet];
    }

    public void set(int indexSet, String str) {
        if (indexOutBounds(indexSet)) return;
        strings[indexSet] = str;
    }

    public boolean remove(int indexRemove) {
        if (indexOutBounds(indexRemove)) return false;
        for (int i = indexRemove; i < size - 1; i++) {
            strings[i] = strings[i + 1];
        }
        size--;
        String[] stringsNew = new String[size];
        System.arraycopy(strings, 0, stringsNew, 0, size);
        strings = stringsNew;
        System.out.println("String is removed");
        return true;
    }

    public void remove(String str) {
        int indexRemove = indexOf(str);
        if (indexRemove == -1) {
            System.out.println("String does not exist");
            return;
        }
        remove(indexRemove);
        System.out.println("String is removed");
        return;
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

        while (size >= strings.length) {
            String[] stringsNew = new String[strings.length * 2];
            System.arraycopy(strings, 0, stringsNew, 0, strings.length);
            strings = stringsNew;
        }

        strings[size] = str;
        size++;
    }

    public boolean add(int indexPaste, String str) {
        if (indexOutBounds(indexPaste)) {
            return false;
        }
        add("0");
        for (int i = size - 1; i > indexPaste; i--) {
            strings[i] = strings[i - 1];
        }

        strings[indexPaste] = str;
        return true;
    }

    private boolean indexOutBounds(int index) {
        if (index > this.size || index < 0) {
            System.out.println("Index is out of bounds");
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        if (strings == null)
            return "null";

        int lastIndex = strings.length - 1;
        while (strings[lastIndex] == null) {
            lastIndex--;
        }

        StringBuilder string = new StringBuilder();
        string.append('[');
        for (int i = 0; ; i++) {
            string.append(strings[i]);
            if (i == lastIndex)
                return string.append(']').toString();
            string.append(", ");
        }
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
