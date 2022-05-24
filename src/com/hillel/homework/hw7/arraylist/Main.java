package com.hillel.homework.hw7.arraylist;

public class Main {
    public static void main(String[] args) {

        MyArrayList arrayList = new MyArrayList();

        arrayList.add("str0");
        arrayList.add("str1");
        arrayList.add("str2");
        arrayList.add("str3");
        arrayList.add("str4");
        arrayList.add("str5");
        arrayList.add("str6");
        arrayList.add("str7");
        arrayList.add("str8");
        arrayList.add("str9");
        arrayList.add("str10");
        arrayList.add("str11");
        arrayList.add(0, "str12");
        arrayList.add(5, "str13");
        arrayList.add(4, "str14");

        System.out.println(arrayList);
        System.out.println(arrayList.size());

        arrayList.remove(12);
        arrayList.remove(20);
        arrayList.remove("str0");
        arrayList.remove("str15");

        System.out.println(arrayList.contains("str0"));

        System.out.println(arrayList);


        System.out.println(arrayList.size());
        System.out.println(arrayList.get(1));
        System.out.println(arrayList.isEmpty());

        System.out.println(arrayList);


        MyArrayList arr = new MyArrayList();

        arr.add("text");

        arr.add(0, "text1");
        arr.add(1, "text2");

        System.out.println(arr);

        arr.remove(0);
        arr.set(0, "test 2");

        System.out.println(arr);

        System.out.println(arr.get(1));
        System.out.println(arr.get(56));


    }
}
