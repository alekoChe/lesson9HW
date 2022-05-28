package ru.gdAleko.lesson9HW.dto;

import ru.gdAleko.lesson9HW.data.Product;


public class ProductDto {

    private String title;

    private int cost;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public ProductDto() {
    }

    public ProductDto(Product product) {
        this.title = product.getTitle();
        this.cost = product.getCost();
    }
}
