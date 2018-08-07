package com.feed.manager.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@ImportResource("classpath*:/feed/integration.xml")
@EnableScheduling
public class FeedManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(FeedManagementApplication.class, args);
	}

}
