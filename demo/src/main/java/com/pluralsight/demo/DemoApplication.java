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


		//OLD WAY
//		for (String bean : context.getBeanDefinitionNames()){
//			//using beans uses A LOT of beans and shows you the beans that Spring Boot Uses
//			System.out.println(bean);
//		}

//		RegistrationDAO registrationDAO = new SimpleRegistrationDAO();
//		RegistrationService registrationService = new RegistrationService();

//		New Way
//		RegistrationService registrationService = context.getBean(RegistrationService.class);
//
//		Student s = registrationService.getStudentById(10);
//
//		System.out.println(s.getFirstName());
	}

}
