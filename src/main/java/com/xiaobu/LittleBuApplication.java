package com.xiaobu;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;


@EnableCaching
@SpringBootApplication
public class LittleBuApplication {
	
	/*@RequestMapping("/")  //默认访问index.jsp
    String home() {  
		System.out.println("进来了");	
		 return "index";
    } */
	

	public static void main(String[] args) {
		SpringApplication.run(LittleBuApplication.class, args);
	}
}
