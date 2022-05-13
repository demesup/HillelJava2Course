package com.hillel.classwork.lesson7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CollectionMain {
    public static void main(String[] args) {

        int[] numbersArray = new int[4];
        List<Integer> numbersCell = new ArrayList<>();

        //fill
        for (int i = 0; i < numbersArray.length; i++) {
            numbersArray[i] = i;
        }
        numbersCell.add(0);
        numbersCell.add(1);
        numbersCell.add(2);
        numbersCell.add(3);


        System.out.println("Array: " + Arrays.toString(numbersArray));
        System.out.println("List: " + numbersCell);

        //size
        System.out.println("Array length: " + numbersArray.length);
        System.out.println("List size: " + numbersCell.size());

        //get element
        System.out.println("Array element index 3: " + numbersArray[3]);
        System.out.println("List element index 3: " + numbersCell.get(3));

        numbersArray[3] = 6;
        numbersCell.set(3,100);

        //changing
        System.out.println("Array element index 3 after changing: " + numbersArray[3]);
        System.out.println("LIst element index 3 after changing: " + numbersCell.get(3));

        numbersCell.add(1, 56);
        System.out.println("New list length " + numbersCell.size() + numbersCell);


        //remove element
        numbersArray[3] = 0;
        numbersCell.remove(4);

        System.out.println("Array after changing: " + Arrays.toString(numbersArray));
        System.out.println("List after changing: " + numbersCell);

    }
}
