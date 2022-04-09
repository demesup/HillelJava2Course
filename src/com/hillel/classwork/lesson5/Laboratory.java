package com.hillel.classwork.lesson5;

import com.hillel.classwork.lesson5.Plant;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Laboratory {

    public static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {

        List<Plant> plants = new ArrayList<>();

        String actionMessage = "Choose action: 1.create plant. 2. press any key to exit";
        System.out.println(actionMessage);
        String input = SCANNER.nextLine();
        while ("create".equals(input.toLowerCase(Locale.ROOT).replaceAll(" ",""))) {
            Plant plant = createPlant();
            if (plant != null) plants.add(plant);
            System.out.println(actionMessage);
            input = SCANNER.nextLine();
        }

        for (Plant plant : plants) {
            plant.photosynthesis();
        }
    }

    public static Plant createPlant() {
        System.out.println("Input plant type: orange, cactus, dandelion");
        String plantType = SCANNER.nextLine();
        switch (plantType.toLowerCase(Locale.ROOT).replaceAll(" ","")) {
            case "orange":
                System.out.println("Input orange age: ");
                int age = Integer.parseInt(SCANNER.nextLine());
                return new Orange(age);
            case "cactus":
                System.out.println("Input cactus height: ");
                int height = Integer.parseInt(SCANNER.nextLine());
                return new Cactus(height);
            case "dandelion":
                System.out.println("Input dandelion height: ");
                int height1 = Integer.parseInt(SCANNER.nextLine());
                return new Dandelion(height1);
            default:
                System.out.println("Incorrect plant type " + plantType + ". Try again");
                return null;
        }
    }

}
