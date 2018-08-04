package com.feed.manager.app.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.messaging.Message;
import org.springframework.messaging.PollableChannel;
import org.springframework.test.context.junit4.SpringRunner;

import com.feed.manager.app.dao.FeedManagerDao;
import com.feed.manager.app.dao.model.FeedItem;
import com.rometools.rome.feed.synd.SyndEntry;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigurationPackage
public class FeedManagerServiceTest{

	@Autowired
	FeedManagerService feedManagerService;
	
	@MockBean
	FeedManagerDao feedMangerDao;
	
	@MockBean
	PollableChannel feedChannel;
	
	@Mock
    private Message<SyndEntry> message;

    @Mock
    private SyndEntry syndEntry;
	
	@Test
	public void readDataTest() {
		when(message.getPayload()).thenReturn(syndEntry);
        when(syndEntry.getLink()).thenReturn("http://google.com");
        when(feedMangerDao.save(Mockito.any())).thenReturn("");
        feedManagerService.readData();
	}
	
	@Test
	public void getLastUpdatedFeedsTest() {
		when(feedMangerDao.findAll(Mockito.any(Pageable.class))).thenReturn( new PageImpl<FeedItem>(new ArrayList<FeedItem>()));
		assertThat(feedManagerService.getLastUpdatedfeeds()).isEqualTo(Arrays.asList());
		
	}

}
