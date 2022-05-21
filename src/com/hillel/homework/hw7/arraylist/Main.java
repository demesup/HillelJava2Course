package com.hillel.homework.hw7.arraylist;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> array= new ArrayList();
        array.add(5);
        array.add(6);
        String arrStr = array.toString();


        MyArrayList myArrayList = new MyArrayList();

        myArrayList.add("str0");
        myArrayList.add("str1");
        myArrayList.add("str2");
        myArrayList.add("str3");

        System.out.println(myArrayList);

        myArrayList.remove(0);
        myArrayList.remove("str0");
        myArrayList.remove("str1");

        System.out.println(myArrayList);

        myArrayList.add(0,"str4");
        myArrayList.add(5,"str5");
        myArrayList.add(4,"str6");

        System.out.println(myArrayList);

        myArrayList.remove(4);

        MyArrayList arr = new MyArrayList();

        arr.add(0, "text");

        arr.add(1, "text");

        arr.remove(0);

        arr.set(0, "test 2");

        arr.get(1);

        System.out.println(arr);



    }
}
