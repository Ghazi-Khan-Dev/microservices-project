package com.microservices.inventoryservice;

import com.microservices.inventoryservice.model.Inventory;
import com.microservices.inventoryservice.repository.InventoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}

	@Bean
	public CommandLineRunner loadData(InventoryRepository inventoryRepository) {
		return args -> {
			Inventory inventory = Inventory.builder().
					skuCode("sku-code-1")
							.quantity(10).build();

			Inventory inventory2 = Inventory.builder().
					skuCode("sku-code-2")
					.quantity(0).build();
			inventoryRepository.save(inventory);
			inventoryRepository.save(inventory2);
		};

	}

}
