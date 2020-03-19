package com.Products;

import javax.persistence.*;
import javax.validation.constraints.*;


@Entity
@Table (name = "products", schema = "fruitshop")
public class Products {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name", nullable = false)
    @Size(min=3, max=25)
    private String name;

    @Column(name = "price", nullable = false)
    @Min(0)
    private int price;
    public Products() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
