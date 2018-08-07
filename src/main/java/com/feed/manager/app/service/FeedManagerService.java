package com.feed.manager.app.service;

import java.util.List;

import com.feed.manager.app.to.Feed;

public interface FeedManagerService {
	
	void readData();

	List<Feed> getLastUpdatedfeeds();
}
