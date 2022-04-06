package com.hillel.homework.hw4.helpers;

import java.util.Scanner;

public class StaticHelpers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Helpers helpers = new Helpers();
        Helpers.DistanceHelper distanceHelper = helpers.new DistanceHelper();
        Helpers.MathHelper mathHelper = helpers.new MathHelper();

        System.out.println("Введите координаты (x,y) точки А (в формате int): ");
        int x1 = scanner.nextInt(), y1 = scanner.nextInt();

        System.out.println("Введите координаты (x,y) точки В (в формате int):");
        int x2 = scanner.nextInt(), y2 = scanner.nextInt();

        System.out.printf("Расстояние между точками А(%d, %d) и В(%d, %d) приблизительно равно %.3f \n",
                x1, y1, x2, y2, distanceHelper.calculateDistance(x1, y1, x2, y2));


        System.out.println("Введите два числа, сумму которых вы хотите получить (в формате int):");
        int a = scanner.nextInt(), b = scanner.nextInt();
        System.out.println("Сумма чисел равна " + mathHelper.sum(a, b));


        System.out.println("\n Bonus");
        boolean loop = true;
        while (loop) {
            System.out.println("Введите два числа: ");
            int n = scanner.nextInt(), m = scanner.nextInt();
            System.out.println("Выберите операцию(eng/rus): \n s/с-сумма \n d/р-разница \n m/у-умножение \n q/д-деление");
            char operation = scanner.next().charAt(0);
            System.out.println(mathHelper.operation(operation, n, m));
            System.out.println("Введите с/s, чтобы закончить");
            char decision = scanner.next().charAt(0);
            if (decision == 'с' | decision == 'і' | decision == 'ы' | decision == 'c' | decision == 's') loop = false;
        }
        System.out.println("Спасибо за внимание!");
    }
}
