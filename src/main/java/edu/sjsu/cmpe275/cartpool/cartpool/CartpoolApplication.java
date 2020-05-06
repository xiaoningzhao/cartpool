package edu.sjsu.cmpe275.cartpool.cartpool;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication//(exclude = org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class)
public class CartpoolApplication {

    public static void main(String[] args) {
        SpringApplication.run(CartpoolApplication.class, args);
    }

}
