package com.example.api;

public class Telephones {
        private int id;
        private String Name;
        private int Count;
        private int Price;
        private String category;

    public Telephones(int id, String name, int count, int price, String category) {
        this.id = id;
        Name = name;
        Count = count;
        Price = price;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return Name;
    }

    public int getCount() {
        return Count;
    }

    public int getPrice() {
        return Price;
    }

    public String getCategory() {
        return category;
    }
}
