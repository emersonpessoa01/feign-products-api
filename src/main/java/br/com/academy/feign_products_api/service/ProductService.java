package br.com.academy.feign_products_api.service;


import br.com.academy.feign_products_api.dto.ProductRequestDTO;
import br.com.academy.feign_products_api.dto.ProductResponseDTO;
import br.com.academy.feign_products_api.exception.ResourceNotFoundException;
import br.com.academy.feign_products_api.feign.ProductClient;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {
    private final ProductClient client;

    public ProductService(ProductClient client) {

        this.client = client;
    }

    public List<ProductResponseDTO> getProduct(ProductRequestDTO req) {
        long start = System.nanoTime();

        var resp = client.getByCategory(req.getCategory()).products;
        var result = resp.stream()
                .filter(p -> p.getPrice() < req.getPrice())
                .filter(p -> p.getStock() >= req.getStock())
                .collect(Collectors.toList());

        long durationMs = (System.nanoTime() - start) / 1_000_000;
        System.out.println("A pesquisa de produtos levou " + durationMs + " ms");

        if (result.isEmpty()) {
            throw new ResourceNotFoundException(
                    String.format("Produtos da %s com estoque ≥ %d e valor < %.2f",
                            req.getCategory(), req.getStock(), req.getPrice()));
        }
        return result;
    }
}