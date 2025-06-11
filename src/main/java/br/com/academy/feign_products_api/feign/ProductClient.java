package br.com.academy.feign_products_api.feign;

import br.com.academy.feign_products_api.dto.ProductResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "productClient", url = "https://dummyjson.com")
public interface ProductClient {
    @GetMapping("/products/category/{category}")
    ApiResponse getByCategory(@PathVariable String category);

    class ApiResponse {
        public List<ProductResponseDTO> products;
    }
}