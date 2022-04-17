package com.hillel.homework.hw5;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class PropertyTaxMain {
    public static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println(new Residential(100, 1, "flat", 1000, 1));
        System.out.println(new Residential(100, 1, "flat", 100000, 1));
        System.out.println(new Residential(350, 1, "flat", 1000, 1));
        System.out.println(new Residential(350, 1, "flat", 100000, 1));
        System.out.println(new Residential(50, 1, "flat", 1000, 1));
        System.out.println(new Residential(100, 1, "house", 1000, 1));
        System.out.println(new Residential(350, 1.5f, "house", 1000, 1));
        System.out.println(new Residential(150, 1.3f, "house", 1000, 1));

        System.out.println(new Commercial(100, 1000));
        System.out.println(new Commercial(100, 60));

        System.out.println(new Industrial(100));


        List<PropertyTax> propertyTaxes = new ArrayList<>();

        String actionMessage = "Choose action: 1.create object. 2. press any key to exit";
        System.out.println(actionMessage);
        while (SCANNER.nextLine().toLowerCase(Locale.ROOT).replaceAll(" ", "").equals("create")) {
            PropertyTax propertyTax = create();
            if (propertyTax != null) propertyTaxes.add(propertyTax);
            System.out.println(actionMessage);
        }

        for (PropertyTax propertyTax : propertyTaxes) {
            System.out.println(propertyTax);
        }
    }

    public static PropertyTax create() {
        System.out.println("Input object type: commercial, residential, industrial ");
        String objectType = SCANNER.nextLine();
        System.out.println("Input space");
        int s = Integer.parseInt(SCANNER.nextLine());
        switch (objectType.toLowerCase(Locale.ROOT).replaceAll(" ", "")) {
            case "residential":
                System.out.println("Input type of residential: flat, house ");
                String type = SCANNER.nextLine().toLowerCase(Locale.ROOT).replaceAll(" ", "");
                if (type.equals("flat") || type.equals("house")) {
                    System.out.println("Input tax rate for your region(\n Kharkiv, Zaporozhye, Sumy- 2%. " +
                            "\n Odessa, Kyiv, Lvov, Kherson, Ternopil, Nikolaev, Uzhgorod, Cherkassy, Khmelnitsky, " +
                            "Poltava, Chernivtsi, Chernigov and Lutsk - 1%.\n  Rivne, Lvov , Kropyvnytskyi - 0.5%.)");
                    float taxK = Float.parseFloat(SCANNER.nextLine());
                    System.out.println("Input family income");
                    int familyIncome = Integer.parseInt(SCANNER.nextLine());
                    System.out.println("Input number of residents");
                    int residents = Integer.parseInt(SCANNER.nextLine());
                    return new Residential(s, taxK, type, familyIncome, residents);
                }
                System.out.println("Incorrect type " + type + ". Try again");
                break;
            case "commercial":
                System.out.println("Input earnings");
                int earnings = Integer.parseInt(SCANNER.nextLine());
                return new Commercial(s, earnings);
            case "industrial":
                return new Industrial(s);
        }
        System.out.println("Incorrect input " + objectType + ". Try again");
        return null;
    }
}