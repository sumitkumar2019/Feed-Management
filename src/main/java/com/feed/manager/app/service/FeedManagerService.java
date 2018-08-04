package com.feed.manager.app.service;

import java.util.List;

import com.feed.manager.app.to.Feed;

public interface FeedManagerService {
	
	public void readData();

	public List<Feed> getLastUpdatedfeeds();
}
