package br.com.academy.feign_products_api.controller;


import br.com.academy.feign_products_api.dto.ProductRequestDTO;
import br.com.academy.feign_products_api.dto.ProductResponseDTO;
import br.com.academy.feign_products_api.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService service;

    public ProductController(ProductService service) {

        this.service = service;
    }

    @PostMapping
    public ResponseEntity<List<ProductResponseDTO>> getProducts(@Valid @RequestBody ProductRequestDTO req) {
        return ResponseEntity.ok(service.getProduct(req));
    }
}