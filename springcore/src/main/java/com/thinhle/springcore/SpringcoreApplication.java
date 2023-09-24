package com.thinhle.springcore;

import org.springframework.boot.SpringApplication;
// Bootstrap SB application
// create app context & register all Beans
// start embedded server (Tomcat,...)

import org.springframework.boot.autoconfigure.SpringBootApplication; //enable auto configuration,
// component scanning, additional configuration
// composed of these annotations @EnableAutoConfiguration @ComponentScan @Configuration


@SpringBootApplication
public class SpringcoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringcoreApplication.class, args);
	}

}
