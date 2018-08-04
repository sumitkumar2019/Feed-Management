package com.feed.manager.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.messaging.Message;
import org.springframework.messaging.PollableChannel;
import org.springframework.stereotype.Service;

import com.feed.manager.app.dao.FeedManagerDao;
import com.feed.manager.app.dao.model.FeedItem;
import com.feed.manager.app.to.Feed;
import com.feed.manager.app.to.mapper.FeedMapper;
import com.rometools.rome.feed.synd.SyndEntry;

@Service
public class FeedManagerServiceImpl implements FeedManagerService {

	@Autowired
	@Qualifier("feedChannel")
	PollableChannel feedChannel;

	@Autowired
	FeedManagerDao feedManagerDao;

	@SuppressWarnings("unchecked")
	@Override
	public void readData() {
		for (int i = 0; i < 10; i++) {
			Message<SyndEntry> message = (Message<SyndEntry>) feedChannel.receive(1000);
			if (message != null) {
				SyndEntry entry = message.getPayload();
				FeedItem feedItem = FeedMapper.mapFeedItem(entry);
				feedManagerDao.save(feedItem);
				System.out.println("FeedItem: "+ feedItem.getTitle() + "saved successully");
			} else {
				break;
			}
		}

	}

	@Override
	public List<Feed> getLastUpdatedfeeds() {
		Page<FeedItem> feedItems = feedManagerDao.findAll(PageRequest.of(0,10));
		return FeedMapper.mapFeeds(feedItems.getContent());
	}

}
