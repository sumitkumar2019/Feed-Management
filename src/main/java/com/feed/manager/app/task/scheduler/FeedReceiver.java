package com.feed.manager.app.task.scheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.feed.manager.app.service.FeedManagerService;

@Component
public class FeedReceiver {

	private FeedManagerService feedManagerService;

	@Autowired
	public FeedReceiver(FeedManagerService feedManagerService) {
		this.feedManagerService = feedManagerService;
	}

	@Scheduled(fixedDelay=10000)
	public void receiveFeed() {
		feedManagerService.readData();
	}
}