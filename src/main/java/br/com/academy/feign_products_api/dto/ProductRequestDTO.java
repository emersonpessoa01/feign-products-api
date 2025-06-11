package br.com.academy.feign_products_api.dto;

import jakarta.validation.constraints.*;

public class ProductRequestDTO {
    @NotBlank(message = "Categoria é necessária")
    private String category;

    @Min(value = 1, message = "O estoque deve ser maior que 0")
    private int stock;

    @DecimalMin(value = "0.01", inclusive = true, message = "O preço deve ser maior que 0")
    @DecimalMax(value = "1999.99", inclusive = true, message = "O preço deve ser menor que 2000")
    private double price;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}