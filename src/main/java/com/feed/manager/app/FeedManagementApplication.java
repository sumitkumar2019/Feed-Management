package com.feed.manager.app;

import com.feed.manager.app.service.FeedManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath*:/feed/integration.xml")
public class FeedManagementApplication {

	private static FeedManagerService feedManagerService;

	@SuppressWarnings("static-access")
	@Autowired
	FeedManagementApplication(FeedManagerService feedManagerService) {
		this.feedManagerService = feedManagerService;
	}

	public static void main(String[] args) {
		SpringApplication.run(FeedManagementApplication.class, args);
		feedManagerService.readData();
	}

}
