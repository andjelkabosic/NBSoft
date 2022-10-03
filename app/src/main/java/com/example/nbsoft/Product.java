package com.example.nbsoft;

import java.util.Objects;

public class Product {
    private String brand;
    private String name;
    private String price;
    private String image_link;

    public Product(String brand, String name, String price, String image_link) {
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
        Product product = (Product) o;
        return Objects.equals(brand, product.brand) &&
                Objects.equals(name, product.name) &&
                Objects.equals(price, product.price) &&
                Objects.equals(image_link, product.image_link);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, name, price, image_link);
    }
}
