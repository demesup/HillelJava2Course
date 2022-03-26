package com.hillel.homework;

public class CommandArgs {

    public static void main(String[] args) {
        for (int i = 0; i < args.length; i++) {
            System.out.println(args[i]);
        }

        if (args[1].charAt(0) == '*' | args[1].charAt(0) == '/' | args[1].charAt(0) == '+' | args[1].charAt(0) == '-') {
            System.out.println(action(Integer.parseInt(args[0]), args[1].charAt(0), Integer.parseInt(args[2])))
            ;
        } else {
            System.out.println("Change operation to one of them: / * - +");
        }
    }


    public static int action(int x, char act, int y) {
        switch (act) {

            case '-':
                return x - y;
            case '+':
                return x + y;
            case '*':
                return x * y;
            default:
                return x / y;
        }

    }

}
