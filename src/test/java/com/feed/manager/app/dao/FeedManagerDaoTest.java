package com.feed.manager.app.dao;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import com.feed.manager.app.dao.model.FeedItem;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureDataJpa
public class FeedManagerDaoTest {
 
	
	private FeedManagerDao feedManagerDao;
	
	@Autowired
	public void setFeedManagerDao(FeedManagerDao feedManagerDao) {
	    this.feedManagerDao = feedManagerDao;
	}; 
 
    @Test
    public void findAllTest() {
    	Page<FeedItem> page =feedManagerDao.findAll(PageRequest.of(0, 1));
        List<FeedItem> feeds = page.getContent();
        assertThat(feeds.size()).isEqualTo(feeds.size());
    }
 
}