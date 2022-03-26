package com.hillel.classwork.lesson2;

public class CommandArgs {

    public static void main(String[] args) {

        for (int i = 0; i < args.length; i++) {
            System.out.println(args[i]);
        }

       calc(Integer.parseInt(args[0]), Integer.parseInt(args[2]), args[1].charAt(0));
    }

    public static int calc(int x, int y, char operation) {
        switch (operation) {
            case '+':
                return  x + y;
            case '-':
                return  x - y;
            case '*':
                return  x * y;
            case '/':
                return  x / y;
            default:
                System.out.println("Измените знак на одну из этих операций: + - * /");
        }
        return 0;
    }
}
