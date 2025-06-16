package com.pluralsight.demo;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
//Container for app
public class DemoApplication {

	public static void main(String[] args) {
		ApplicationContext context;
		context = SpringApplication.run(DemoApplication.class, args);

		for (String bean : context.getBeanDefinitionNames()){
			//using beans uses A LOT of beans and shows you the beans that Spring Boot Uses
			System.out.println(bean);
		}
	}

}
