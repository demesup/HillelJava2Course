package com.hillel.homework.hw7;

import com.hillel.Item;
import com.hillel.classwork.lesson7.cat.Cat;

import java.util.*;

public class Warehouse {

    public static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Products> productsList = new ArrayList<>();

        String actionMessage = "Choose action: add product, remove, change or exit";
        System.out.println(actionMessage);
        String choose = SCANNER.nextLine().toLowerCase(Locale.ROOT).replaceAll(" ", "");
        while (!choose.equals("exit")) {
            if (choose.equals("add")) {
                addProduct(productsList);
            } else if (choose.equals("remove")) {
                removeProduct(productsList);
            } else if (choose.equals("change")) {
                changeProduct(productsList);
            } else {
                System.out.println("Your input does not equal add, remove, change or stop. Please, try again. ");
            }
            System.out.println(actionMessage);
            choose = SCANNER.nextLine().toLowerCase(Locale.ROOT).replaceAll(" ", "");
        }

        System.out.println(productsList);
    }

    private static void changeProduct(List<Products> productsList) {

        System.out.println("Enter product name");
        String productName = SCANNER.nextLine().toLowerCase(Locale.ROOT).replaceAll(" ", "");

        boolean isFound = false;
        int elementIndex = -1;
        for (Products product : productsList) {
            if (product.getName().equals(productName)) {
                isFound = true;
                elementIndex = productsList.indexOf(product);
                break;
            }
        }

        if (isFound) {
            System.out.println("Enter parameter you want to change or press any key to exit");
            String choose = SCANNER.nextLine().toLowerCase(Locale.ROOT).replaceAll(" ", "");
            switch (choose) {
                case "name":
                    System.out.println("Enter new name: ");
                    String name = SCANNER.nextLine().toLowerCase(Locale.ROOT).replaceAll(" ","");
                    productsList.get(elementIndex).setName(name);
                case "amount":
                    System.out.println("Enter new amount");
                    int amount = SCANNER.nextInt();
                    productsList.get(elementIndex).setAmount(amount);
                case "weight":
                    System.out.println("Enter new weight");
                    int weight = SCANNER.nextInt();
                    productsList.get(elementIndex).setWeight(weight);
                case "price":
                    System.out.println("Enter new price");
                    int price = SCANNER.nextInt();
                    productsList.get(elementIndex).setPrice(price);
                default:
                    System.out.println("Returning to main menu...");
            }
            SCANNER.nextLine();
        }
    }

    public static void removeProduct(List<Products> productsList) {
        Iterator<Products> productsIterator = productsList.iterator();

        System.out.println("Enter product name");
        String name = SCANNER.nextLine().toLowerCase(Locale.ROOT).replaceAll(" ", "");
        while (productsIterator.hasNext()) {
            Products product = productsIterator.next();
            if (product.getName().equals(name)) {
                productsIterator.remove();
            }
        }
    }

    public static void addProduct(List<Products> productsList) {
        System.out.println("Enter product name: ");
        String name = SCANNER.nextLine().replaceAll(" ", "").toLowerCase(Locale.ROOT);
        System.out.println("Enter product amount: ");
        int amount = SCANNER.nextInt();
        System.out.println("Enter product weight: ");
        int weight = SCANNER.nextInt();
        System.out.println("Enter product price: ");
        int price = SCANNER.nextInt();
        SCANNER.nextLine();

        boolean isFound = false;
        for (Products product : productsList) {
            if (product.getName().equals(name)) {
                isFound = true;
                break;
            }
        }

        if (!isFound) {
            productsList.add(new Products(name, amount, weight, price));
        } else System.out.println("Product already exist");

    }


    //    private static Products addProduct() {
//        System.out.println("Enter product name: ");
//        String name = SCANNER.nextLine().replaceAll(" ", "").toLowerCase(Locale.ROOT);
//        System.out.println("Enter product amount: ");
//        int amount = SCANNER.nextInt();
//        System.out.println("Enter product weight: ");
//        int weight = SCANNER.nextInt();
//        System.out.println("Enter product price: ");
//        int price = SCANNER.nextInt();
//        SCANNER.nextLine();
//        Products product = new Products(name, amount, weight, price);
//        return product;
//    }
}
