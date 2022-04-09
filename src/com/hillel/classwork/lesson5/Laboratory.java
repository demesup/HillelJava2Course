package com.hillel.classwork.lesson5;

import com.hillel.classwork.Plant;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Laboratory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Plant> plants = new ArrayList<>();

        System.out.println("Dandelion height: ");
        int height1 = scanner.nextInt();
        Plant dandelion = new Dandelion(height1);
        plants.add(dandelion);

        System.out.println("Cactus height: ");
        int height2 = scanner.nextInt();
        Plant cactus = new Cactus(height2);
        plants.add(cactus);

        for (Plant plant: plants) {
            plant.photosynthesis();
        }


    }
}
