package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);

		AbstractApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class);

		Cafe cafe = ctx.getBean(Cafe.class);
		cafe.order();

		ctx.close();
	}

}
