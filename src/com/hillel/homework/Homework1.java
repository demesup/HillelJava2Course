package com.hillel.homework;

import java.util.Scanner;

public class Homework1 {

    public static void main(String[] args) {

        long sum = 0;
        boolean condition=true;

        Scanner scanner = new Scanner(System.in);

         do{
            System.out.println("Enter number");
            sum += scanner.nextLong();
            System.out.println("Enter stop or стоп to end the program. If you want to continue enter anything else");

            String s= scanner.next();
            if (s.equalsIgnoreCase("stop") | s.equalsIgnoreCase("стоп")){
                condition=false;
            }
        }while (condition==true);
            System.out.println(sum);
    }
}
