package com.example.FactoryManager;

import com.example.FactoryManager.configuration.CorsProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(CorsProperties.class)
public class FactoryManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(FactoryManagerApplication.class, args);
	}

}
