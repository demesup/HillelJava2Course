package com.hillel.homework.hw7;

import com.hillel.Item;
import com.hillel.classwork.lesson7.cat.Cat;

import java.util.*;

public class Warehouse {

    public static final Scanner SCANNER = new Scanner(System.in);
    public static List<Products> productsList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String actionMessage = "Choose action: add product, remove, change or exit";
        System.out.println(actionMessage);
        String choose = SCANNER.nextLine().toLowerCase(Locale.ROOT).replaceAll(" ", "");
        while (!choose.equals("exit")) {
            switch (choose) {
                case "add":
                    addProduct(productsList);
                    break;
                case "remove":
                    removeProduct(productsList);
                    break;
                case "change":
                    changeProduct(productsList);
                    break;
                default:
                    System.out.println("Your input does not equal add, remove, change or stop. Please, try again. ");
            }
            System.out.println(actionMessage);
            choose = SCANNER.nextLine().toLowerCase(Locale.ROOT).replaceAll(" ", "");
        }

        if (productsList.size() != 0) {
            System.out.println(productsList);
        } else System.out.println("List is empty");
    }

    private static void changeProduct(List<Products> productsList) {
        if (productsList.size() != 0) {
            System.out.println("Enter product name");
            String productName = SCANNER.nextLine().toLowerCase(Locale.ROOT).replaceAll(" ", "");

            int elementIndex = -1;
            for (Products product : productsList) {
                if (product.getName().equals(productName)) {
                    elementIndex = productsList.indexOf(product);
                    break;
                }
            }

            if (isFound(productName)) {
                System.out.println("Enter parameter you want to change(name, amount, weight, price) or press any key to exit");
                String choose = SCANNER.nextLine().toLowerCase(Locale.ROOT).replaceAll(" ", "");
                switch (choose) {
                    case "name":
                        System.out.println("Enter new name: ");
                        String name = SCANNER.nextLine().toLowerCase(Locale.ROOT).replaceAll(" ", "");
                        productsList.get(elementIndex).setName(name);
                        break;
                    case "amount":
                        System.out.println("Enter new amount");
                        String strAmount = SCANNER.nextLine();
                        if (isInteger(strAmount)) {
                            int amount = Integer.parseInt(strAmount);
                            productsList.get(elementIndex).setAmount(amount);
                        } else {
                            System.out.println("Wrong amount format");
                            break;
                        }
                    case "weight":
                        System.out.println("Enter new weight");
                        String strWeight = SCANNER.nextLine();
                        if (isInteger(strWeight)) {
                            int weight = Integer.parseInt(strWeight);
                            productsList.get(elementIndex).setWeight(weight);
                        } else {
                            System.out.println("Wrong weight format");
                            break;
                        }
                    case "price":
                        System.out.println("Enter new price");
                        String strPrice = SCANNER.nextLine();
                        if (isInteger(strPrice)) {
                            int price = Integer.parseInt(strPrice);
                            productsList.get(elementIndex).setPrice(price);
                        } else {
                            System.out.println("Wrong price format");
                            break;
                        }
                    default:
                        System.out.println("Returning to main menu...");
                }
            } else System.out.println("List is empty");
        }
    }

    public static void removeProduct(List<Products> productsList) {
        if ((productsList.size() != 0)) {
            Iterator<Products> productsIterator = productsList.iterator();

            System.out.println("Enter product name");
            String name = SCANNER.nextLine().toLowerCase(Locale.ROOT).replaceAll(" ", "");

            if (isFound(name)) {
                while (productsIterator.hasNext()) {
                    Products product = productsIterator.next();
                    if (product.getName().equals(name)) {
                        productsIterator.remove();
                        System.out.println("Product is removed");
                    }
                }
            } else {
                System.out.println("there is no product with this name");
            }
        } else {
            System.out.println("List is empty");
        }
    }

    public static void addProduct(List<Products> productsList) {
        System.out.println("Enter product name: ");
        String name = SCANNER.nextLine().replaceAll(" ", "").toLowerCase(Locale.ROOT);
        if (!isFound(name)) {
            System.out.println("Enter product amount: ");
            String strAmount = SCANNER.nextLine();
            if (isInteger(strAmount)) {
                int amount = Integer.parseInt(strAmount);
                System.out.println("Enter product weight: ");
                String strWeight = SCANNER.nextLine();
                if (isInteger(strWeight)) {
                    int weight = Integer.parseInt(strWeight);
                    System.out.println("Enter product price: ");
                    String strPrice = SCANNER.nextLine();
                    if (isInteger(strPrice)) {
                        int price = Integer.parseInt(strPrice);
                        productsList.add(new Products(name, amount, weight, price));
                    } else System.out.println("Price format is nor int");
                } else System.out.println("Weight format is nor int");
            } else System.out.println("Amount format is nor int");
        } else System.out.println("Product already exist");
    }

    private static boolean isFound(String name) {
        for (Products product : productsList) {
            if (product.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isInteger(String amount) {
        if (amount == null) return false;
        try {
            int a = Integer.parseInt(amount);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}