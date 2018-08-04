package com.feed.manager.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.feed.manager.app.service.FeedManagerService;
import com.feed.manager.app.to.Feed;

@Controller
public class FeedManagerController {

	@Autowired
	FeedManagerService feedManagerService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ResponseEntity<List<Feed>> listLastUpdatedFeed() {
		List<Feed> feeds = feedManagerService.getLastUpdatedfeeds();
		return new ResponseEntity<List<Feed>>(feeds, HttpStatus.OK);
	}

}
