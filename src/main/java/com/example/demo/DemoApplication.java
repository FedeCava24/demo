package com.example.demo;

import com.vaadin.flow.component.page.AppShellConfigurator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class DemoApplication extends SpringBootServletInitializer implements AppShellConfigurator{

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
