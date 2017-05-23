package com.example.demo;

import com.example.demo.repository.AssetsRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = AssetsRepository.class)
@EnableDiscoveryClient
public class AssetDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AssetDemoApplication.class, args);
	}
}
