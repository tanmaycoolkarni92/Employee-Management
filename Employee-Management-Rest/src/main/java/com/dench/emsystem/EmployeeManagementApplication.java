package com.dench.emsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
@EnableJpaAuditing
public class EmployeeManagementApplication {

	@SuppressWarnings("deprecation")
	@Bean
	public WebMvcConfigurer crosConfigurer() {
			return new WebMvcConfigurerAdapter() {
				public void addCorsMappings(CorsRegistry registry) {
					registry.addMapping("/").allowedOrigins("*");
				}
			};
	}
	
	
	public static void main(String[] args) {
		SpringApplication.run(EmployeeManagementApplication.class, args);
	}
	
	
	
}
