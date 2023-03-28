package de.ithoc.training.exercise.warehouse;

public class Item {

    private final String number;
    private final String name;
    private final float price;


    public Item(String number, String name, float price) {
        this.number = number;
        this.name = name;
        this.price = price;
    }


    public String getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

}
