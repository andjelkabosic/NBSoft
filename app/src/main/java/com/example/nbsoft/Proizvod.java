package com.example.nbsoft;

import java.util.Objects;

public class Proizvod {
    private String brand;
    private String name;
    private String price;
    private String image_link;

    public Proizvod(String brand, String name, String price, String image_link) {
        this.brand = brand;
        this.name = name;
        this.price = price;
        this.image_link = image_link;
    }

    public String getBrand() {
        return brand;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public String getImage_link() {
        return image_link;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setImage_link(String image_link) {
        this.image_link = image_link;
    }

    @Override
    public String toString() {
        return "Proizvod{" +
                "brand='" + brand + '\'' +
                ", name='" + name + '\'' +
                ", price='" + price + '\'' +
                ", image_link='" + image_link + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Proizvod proizvod = (Proizvod) o;
        return Objects.equals(brand, proizvod.brand) &&
                Objects.equals(name, proizvod.name) &&
                Objects.equals(price, proizvod.price) &&
                Objects.equals(image_link, proizvod.image_link);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, name, price, image_link);
    }
}
