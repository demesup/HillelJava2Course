package com.hillel.homework.hw6.bodyGuard;

import com.hillel.Item;
import com.hillel.classwork.lesson6.item.*;
import com.hillel.classwork.lesson6.item.Runnable;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {

        List<BodyGuard> bodyGuards = new ArrayList<>();
        String actionMessage = "Choose action: 1.create bodyguard. 2. press any key to exit";
        System.out.println(actionMessage);
        while (SCANNER.nextLine().toLowerCase(Locale.ROOT).replaceAll(" ", "").equals("create")) {
            BodyGuard bodyGuard = create();
            if (bodyGuard != null) bodyGuards.add(bodyGuard);
            System.out.println(actionMessage);
        }

        for (BodyGuard bodyGuard : bodyGuards) {
            System.out.println(bodyGuard);
            bodyGuard.protect();
            if (bodyGuard instanceof Punchable) ((Punchable) bodyGuard).punch();
            if (bodyGuard instanceof Capturable) ((Capturable) bodyGuard).capture();
            if (bodyGuard instanceof Kickable) ((Kickable) bodyGuard).kick();
            if (bodyGuard instanceof Throwable) ((Throwable) bodyGuard).throwMen();
            if (bodyGuard instanceof PainHoldable) ((PainHoldable) bodyGuard).painHold();
            bodyGuard.success();
            System.out.println();
        }
    }

    public static BodyGuard create() {
        boolean gun = false;
        System.out.println("Has attack man a gun? Enter yes or press any key to start protection");

        if (SCANNER.nextLine().toLowerCase(Locale.ROOT).replaceAll(" ", "").equals("yes")) {
            gun = true;
        }
        System.out.println("Input number of bodyGuard type: \n 1-boxer \n 2-jiu-gist \n 3-karate-guy");
        String objectType = SCANNER.nextLine();
        switch (objectType) {
            case "1":
                return new Boxer(gun);
            case "2":
                return new JiuGist(gun);
            case "3":
                return new KarateGuy(gun);
            default:
                System.out.println("Incorrect bodyGuard type " + objectType + ". Try again");
                return null;
        }
    }
}
