package com.hillel.homework.hw8.linkedList;

import java.time.LocalDate;
import java.util.*;

public class MapPeople {
    public static Map<String, LocalDate> people = new HashMap<>();
    public static final Scanner SCANNER = new Scanner(System.in);
    protected static Map<String, LocalDate> peopleByUser = new HashMap<>();

    public static void main(String[] args) {

        people.put("Марго", LocalDate.of(1111, 1, 1));
        people.put("Костя", LocalDate.of(1122, 2, 2));
        people.put("Саша", LocalDate.of(1133, 3, 3));
        people.put("Маша", LocalDate.of(1144, 4, 4));
        people.put("Даша", LocalDate.of(1155, 5, 5));
        people.put("Паша", LocalDate.of(1166, 6, 6));
        people.put("Аркаша", LocalDate.of(1177, 7, 7));
        people.put("Лёша", LocalDate.of(1188, 8, 8));
        people.put("Степан", LocalDate.of(1199, 9, 9));
        people.put("Семён", LocalDate.of(1000, 10, 10));

        System.out.println("List before we started hating summer people:");
        System.out.println(people);

        weHateSummerPeople();
        System.out.println("List after we started hating summer people:");
        System.out.println(people);

        System.out.println("Do you want to create your own list of hated people?");
        String actionMessage = "Choose action: 1.add . 2. press any key to exit";
        System.out.println(actionMessage);
        while (SCANNER.nextLine().toLowerCase(Locale.ROOT).replaceAll(" ", "").equals("add")) {
            create();
            System.out.println(actionMessage);
        }

        if (!peopleByUser.isEmpty()) {
            System.out.println(peopleByUser);

            System.out.println("Do yoe want to start hating somebody? Enter yes or press any key to exit");

            while (SCANNER.nextLine().toLowerCase(Locale.ROOT).replaceAll(" ", "").equals("yes") &&
                    !peopleByUser.isEmpty()) {
                hate();
                System.out.println("Continue? Yes/any key");
            }
            System.out.println(peopleByUser);
        } else
            System.out.println("List is empty");

    }

    public static void weHateSummerPeople() {
        people.entrySet().removeIf(entry -> entry.getValue().getMonthValue() > 5 && entry.getValue().getMonthValue() < 9);
    }

    public static void create() {
        System.out.println("Enter name");
        String name = SCANNER.nextLine().replaceAll(" ", "");

        LocalDate localDate;
        System.out.println("Enter date in format 2000-02-02");
        String str = SCANNER.nextLine();
        try {
            localDate = LocalDate.parse(str);
        } catch (Exception e) {
            System.out.println("Wrong date");
            return;
        }
        peopleByUser.put(name, localDate);
    }

    public static void hate() {
        System.out.println("Enter season or month");
        String choose = SCANNER.nextLine().toLowerCase(Locale.ROOT).replaceAll(" ", "");
        if (!(choose.equals("season") || choose.equals("month"))) return;
        if (choose.equals("season")) {
            System.out.println("Enter season  \n\t[winter, spring, summer, autumn");
            String season = SCANNER.nextLine().toLowerCase(Locale.ROOT).replaceAll(" ", "");
            switch (season) {
                case "autumn":
                    peopleByUser.entrySet().removeIf(entry -> entry.getValue().getMonthValue() > 8 &&
                            entry.getValue().getMonthValue() < 12);
                    break;
                case "winter":
                    peopleByUser.entrySet().removeIf(entry -> entry.getValue().getMonthValue() == 12 ||
                            entry.getValue().getMonthValue() == 1 || entry.getValue().getMonthValue() == 2);
                    break;
                case "spring":
                    peopleByUser.entrySet().removeIf(entry -> entry.getValue().getMonthValue() > 2 &&
                            entry.getValue().getMonthValue() < 6);
                    break;
                case "summer":
                    peopleByUser.entrySet().removeIf(entry -> entry.getValue().getMonthValue() > 5 &&
                            entry.getValue().getMonthValue() < 9);
                    break;
                default:
                    System.out.println("Error");
            }
        } else {
            System.out.println("Enter month");
            String monthStr = SCANNER.nextLine().toLowerCase(Locale.ROOT).replaceAll(" ", "");
            if (isInteger(monthStr)) {
                System.out.println("Not int");
                return;
            }
            int month = (Integer.parseInt(monthStr));
            if (month > 0 && month < 13) {
                peopleByUser.entrySet().removeIf(entry -> entry.getValue().getMonthValue() == month);
                System.out.println("Month is deleted");
            } else System.out.println("Not month number");
        }
    }

    private static boolean isInteger(String amount) {
        if (amount == null) return true;
        try {
            Integer.parseInt(amount);
        } catch (Exception e) {
            return true;
        }
        return false;
    }
}
