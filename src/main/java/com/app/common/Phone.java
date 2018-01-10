package com.app.common;

public class Phone {
    private String title;

    private String manufactor;
    private int price;

    public String getManufactor() {
        return manufactor;
    }

    public void setManufactor(String manufactor) {
        this.manufactor = manufactor;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPrice() {return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "title='" + title + '\'' +
                ", manufactor='" + manufactor + '\'' +
                ", price=" + price +
                '}';
    }
}
