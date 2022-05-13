package com.hillel.homework.hw7;

public class Products {
    private String name;
    private int amount;
    private int weight;
    private int price;

    public Products(String name, int amount, int weight, int price) {
        this.name = name;
        this.amount = amount;
        this.weight = weight;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", amount=" + amount +
                ", weight=" + weight +
                ", price=" + price +
                "}\n";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
