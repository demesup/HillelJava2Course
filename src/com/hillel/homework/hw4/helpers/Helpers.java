package com.hillel.homework.hw4.helpers;

public class Helpers {

    public static class DistanceHelper {
        public double calculateDistance(int x1, int y1, int x2, int y2) {
            if (x1 == x2 && y1 == y2) return 0;
            return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        }
    }

    public static class MathHelper {
        public static float operation(char o, int a, int b) {
            switch (o) {
                case ('с'):
                case ('s'):
                case ('c'):
                case ('ы'):
                case ('і'):
                    return sum(a, b);
                case ('р'):
                case ('d'):
                case ('в'):
                case ('h'):
                    return difference(a, b);
                case ('у'):
                case ('m'):
                case ('e'):
                case ('ь'):
                    return multiplication(a, b);
                case ('д'):
                case ('q'):
                case ('l'):
                case ('й'):
                    return division(a, b);
                default:
                    System.out.println("Неопознаное действие");
                    return 0;
            }
        }

        public static int sum(int a, int b) {
            return a + b;
        }

        private static int difference(int a, int b) {
            return a - b;
        }

        private static int multiplication(int a, int b) {
            return a * b;
        }

        private static float division(int a, int b) {

            return (float) a / b;
        }
    }
}
