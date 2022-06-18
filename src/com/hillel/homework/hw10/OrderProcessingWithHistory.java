package com.hillel.homework.hw10;

import java.io.*;
import java.time.LocalDateTime;
import java.util.*;

public class OrderProcessingWithHistory {
    public static BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
    public static String FILE_NAME = "C:\\Users\\User\\Downloads\\readMe.txt";
    public static List<Order> ORDER_LIST = new ArrayList<>();


    public static void main(String[] args) throws IOException {
        readFile();
        if (ORDER_LIST.size() > 0) System.out.println(ORDER_LIST);

        try {
            while (true) {
                System.out.println("Enter order number/press any key to exit");
                int number = Integer.parseInt(READER.readLine());
                checkOrder(number);
            }
        } catch (NumberFormatException e) {
            System.out.println("Finished");
        }
    }

    private static void checkOrder(int number) {
        if (ORDER_LIST.size() == 0) {
            orderCreate(number);
            return;
        }
        boolean found = false;
        for (Order order : ORDER_LIST) {
            if (number == order.getOrderNumber()) {
                orderChange(order);
                found = true;
            }
        }
        if (!found) orderCreate(number);
    }

    private static void orderCreate(int number) {
        System.out.println("New order number is " + number);
        Order order = new Order(OrderStatus.NEW, number, LocalDateTime.now());
        ORDER_LIST.add(order);
        writeToFile(order.toString());
    }

    private static void
    orderChange(Order order) {

        try {
            if (order.getOrderStatus().ordinal() == OrderStatus.FAILED.ordinal())
                throw new InvalidStatusException("You can't change status FAILED");
            System.out.println("Order status:" + order.getOrderStatus() + ". Enter new status " +
                    "\n [NEW, IN_PROGRESS, FINISHED, FAILED");
            OrderStatus newStatus = OrderStatus.valueOf(READER.readLine().toUpperCase(Locale.ROOT).replaceAll(" ", ""));
            if ((order.getOrderStatus().ordinal() == newStatus.ordinal()))
                throw new InvalidStatusException("Old status is the same as the new one");
            if ((order.getOrderStatus().ordinal() > newStatus.ordinal()))
                throw new InvalidStatusException("Old status is upper than new one");
            order.setOrderStatus(newStatus);
            order.setOrderChanged(LocalDateTime.now());
            writeToFile(order.toString());
        } catch (InvalidStatusException e) {
            System.out.println(e.getMessage());
        } catch (IOException | IllegalArgumentException e) {
            System.out.println("Wrong order type, try again");
            orderChange(order);
        }
    }

    private static void writeToFile(String str) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            writer.write(str);
        } catch (IOException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    private static void readFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line = reader.readLine();
            while (line != null) {
                toOrder(line);
                line = reader.readLine();
            }
        } catch (IOException e) {
            System.out.println("ERROR: " + e.getMessage() + ". Creating the new one...");
        }
    }

    private static void toOrder(String readLine) {
        if (readLine == null) return;
        readLine = readLine.replaceAll("Order:status=", " ").replaceAll(", number=", " ")
                .replaceAll(", accepted=", " ").replaceAll(", changed=", " ");
        String[] str = readLine.split(" ");

        for (Order order : ORDER_LIST) {
            if (Integer.parseInt(str[2]) == order.getOrderNumber()) {
                order.setOrderStatus(OrderStatus.valueOf(str[1].toUpperCase()));
                order.setOrderChanged(LocalDateTime.parse(str[4]));
                return;
            }
        }
        ORDER_LIST.add(new Order(OrderStatus.valueOf(str[1].toUpperCase()), Integer.parseInt(str[2]),
                LocalDateTime.parse(str[3])));
    }
}
