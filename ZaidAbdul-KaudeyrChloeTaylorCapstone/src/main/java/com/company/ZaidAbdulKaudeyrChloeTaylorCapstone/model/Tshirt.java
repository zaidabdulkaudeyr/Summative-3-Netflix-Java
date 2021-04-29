package com.company.ZaidAbdulKaudeyrChloeTaylorCapstone.model;

import java.math.BigDecimal;
import java.util.Objects;

public class Tshirt
{
    //properties
    private int id;
    private String size;
    private String color;
    private String description;
    private BigDecimal price;
    private int quantity;

    //getters and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    //equals and hash code
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tshirt tshirt = (Tshirt) o;
        return id == tshirt.id && quantity == tshirt.quantity && Objects.equals(size, tshirt.size) && Objects.equals(color, tshirt.color) && Objects.equals(description, tshirt.description) && Objects.equals(price, tshirt.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, size, color, description, price, quantity);
    }
}
