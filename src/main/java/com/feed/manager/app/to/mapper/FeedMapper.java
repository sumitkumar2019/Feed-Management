package com.feed.manager.app.to.mapper;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.feed.manager.app.dao.model.FeedItem;
import com.feed.manager.app.to.Feed;
import com.rometools.rome.feed.synd.SyndEntry;

public class FeedMapper {

	/**
	 * Mapping RSS Feeds from channel to Entity Object
	 * 
	 * @param feed
	 * @return
	 */
	public static FeedItem mapFeedItem(SyndEntry entry) {
		FeedItem feedItem = new FeedItem();
		feedItem.setPublishedDate(entry.getPublishedDate());
		feedItem.setTitle(entry.getTitle());
		feedItem.setLink(entry.getLink());
		feedItem.setUri(entry.getUri());
		feedItem.setUpdatedDate(entry.getUpdatedDate());
		
		//Modifying Comments
		feedItem.setComments("New Comments Added");
		
		//added some more field
		feedItem.setAuthor("SKumar");

		feedItem.setCreationDate(new Date());
		return feedItem;
	}

	/**
	 * Mapping Entity to Form Object
	 * 
	 * @param feed
	 * @return
	 */
	public static Feed mapFeed(FeedItem feedItem) {
		Feed feed = new Feed();
		feed.setPublishedDate(feedItem.getPublishedDate());
		feed.setTitle(feedItem.getTitle());
		feed.setComments(feedItem.getComments());
		feed.setLink(feedItem.getLink());
		feed.setUri(feedItem.getUri());
		feed.setUpdatedDate(feedItem.getUpdatedDate());
		return feed;
	}

	/**
	 * Mapping List of Entity to List of Form object
	 * 
	 * @param feeds
	 * @return
	 */
	public static List<Feed> mapFeeds(List<FeedItem> feedItems) {
		List<Feed> feedList = new ArrayList<>();
		for (FeedItem feedItem : feedItems) {
			feedList.add(mapFeed(feedItem));
		}
		return feedList;
	}

}
