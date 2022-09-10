package com.example.shopping_mall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.Transactional;

@EnableScheduling //스프링 부트, 스케줄러 작동
@EnableJpaAuditing
@SpringBootApplication
public class ShoppingMallApplication {
	public static void main(String[] args) {
		SpringApplication.run(ShoppingMallApplication.class, args);


	}

}
