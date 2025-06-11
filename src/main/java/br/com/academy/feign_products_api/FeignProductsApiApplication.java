package br.com.academy.feign_products_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "br.com.academy.feign_products_api.feign")
public class FeignProductsApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(FeignProductsApiApplication.class, args);
	}

}
