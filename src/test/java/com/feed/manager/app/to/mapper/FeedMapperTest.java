package com.feed.manager.app.to.mapper;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.feed.manager.app.dao.model.FeedItem;
import com.feed.manager.app.to.Feed;
import com.rometools.rome.feed.synd.SyndEntry;
import com.rometools.rome.feed.synd.SyndEntryImpl;

public class FeedMapperTest {

	
	@Test
	public void mapFeedItemTest() {
		SyndEntry entry = new SyndEntryImpl();
		entry.setLink("www.google.com");
		entry.setTitle("Google");
		entry.setUri("www.msn.com");
		FeedItem feedItem = FeedMapper.mapFeedItem(entry);
		assertThat(feedItem.getLink()).isEqualTo(entry.getLink());
		assertThat(feedItem.getTitle()).isEqualTo(entry.getTitle());
		assertThat(feedItem.getUri()).isEqualTo(entry.getUri());
		assertThat(feedItem.getAuthor()).isEqualTo("SKumar");
		assertThat(feedItem.getComments()).isEqualTo("New Comments Added");
	}

	@Test
	public void mapFeedTest() {
		FeedItem feedItem = new FeedItem();
		feedItem.setTitle("Title 1");
		feedItem.setComments("Comments 1");
		feedItem.setLink("Link 1");
		
		Feed feed = FeedMapper.mapFeed(feedItem);
		assertThat(feed.getLink()).isEqualTo(feedItem.getLink());
		assertThat(feed.getTitle()).isEqualTo(feedItem.getTitle());
		assertThat(feed.getUri()).isEqualTo(feedItem.getUri());
	}

	@Test
	public void mapFeedsTest() {
		List<FeedItem> feedItems = new ArrayList<FeedItem>();
		
		FeedItem feedItem = new FeedItem();
		feedItem.setTitle("Title 1");
		feedItem.setComments("Comments 1");
		feedItem.setLink("Link 1");
		feedItems.add(feedItem);
		
		List<Feed> feeds = FeedMapper.mapFeeds(feedItems);

		assertThat(feeds.get(0).getLink()).isEqualTo(feedItem.getLink());
		assertThat(feeds.get(0).getTitle()).isEqualTo(feedItem.getTitle());
		assertThat(feeds.get(0).getUri()).isEqualTo(feedItem.getUri());
	}

}
