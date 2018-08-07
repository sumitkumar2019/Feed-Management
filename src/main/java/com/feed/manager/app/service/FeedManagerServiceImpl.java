package com.feed.manager.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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

	private PollableChannel feedChannel;
	
	private FeedManagerDao feedManagerDao;
	
	@Autowired
	@Qualifier("feedChannel")
	public void setFeedChannel(PollableChannel feedChannel) {
	    this.feedChannel = feedChannel;
	}

	@Autowired
	public void setFeedManagerDao(FeedManagerDao feedManagerDao) {
	    this.feedManagerDao = feedManagerDao;
	};

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
		System.out.println("---------Please Wait Next Data Fetch After 10 Seconds---------");
	}

	@Override
	public List<Feed> getLastUpdatedfeeds() {
		Page<FeedItem> pageItems = feedManagerDao.findAll(PageRequest.of(0, 10, Sort.Direction.DESC, "id"));
		List<FeedItem> feedItems = pageItems.getContent();
		return FeedMapper.mapFeeds(feedItems);
	}

}
