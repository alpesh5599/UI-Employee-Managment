package com.nexscend.employee.management;

import org.apache.log4j.PropertyConfigurator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.nexscend.employee.management")
@EntityScan("com.nexscend.employee.management.entity")
@EnableJpaRepositories("com.nexscend.employee.management.repository")
public class EmpManagementApplication {

	public static void main(String[] args) {
		PropertyConfigurator.configure("C:\\Users\\Vishal\\Downloads\\emp_management\\src\\main\\resources\\log4j.properties");
		SpringApplication.run(EmpManagementApplication.class, args);
	}
}