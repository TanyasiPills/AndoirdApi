package com.example.api;

public class Telephones {
        private String Name;
        private int Count;
        private int Price;
        private String category;

    public Telephones(String name, int count, int price, String category) {
        Name = name;
        Count = count;
        Price = price;
        this.category = category;
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
