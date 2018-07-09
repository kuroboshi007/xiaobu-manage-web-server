package com.mrs.demo;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@EnableCaching
@SpringBootApplication
public class LittleDemoApplication {
	
	/*@RequestMapping("/")  //默认访问index.jsp
    String home() {  
		System.out.println("进来了");
		 return "index";
    } */
	

	public static void main(String[] args) {
		SpringApplication.run(LittleDemoApplication.class, args);
	}
}
