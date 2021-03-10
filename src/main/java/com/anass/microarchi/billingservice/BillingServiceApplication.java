package com.anass.microarchi.billingservice;

import com.anass.microarchi.billingservice.entities.Bill;
import com.anass.microarchi.billingservice.entities.Customer;
import com.anass.microarchi.billingservice.entities.ProductItem;
import com.anass.microarchi.billingservice.repositories.BillRepository;
import com.anass.microarchi.billingservice.repositories.ProductItemRepository;
import com.anass.microarchi.billingservice.services.CustomerService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
@EnableFeignClients
public class BillingServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BillingServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(BillRepository billRepository,
                            ProductItemRepository productItemRepository,
                            CustomerService customerService){
        return args -> {
            Customer c1 = customerService.findCustomerById(1L);
            Bill b1 = new Bill(null, new Date(), c1.getId(), null);
            billRepository.save(b1);
            productItemRepository.save(new ProductItem(null, 1L, 800, 30, b1));
        };
    }

}
