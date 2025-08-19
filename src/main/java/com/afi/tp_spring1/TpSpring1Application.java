package com.afi.tp_spring1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages= {"com.afi.tp_spring1.*"})
public class TpSpring1Application {

	public static void main(String[] args) {
		SpringApplication.run(TpSpring1Application.class, args);
		System.out.println("Application démarrée");
	}

}
