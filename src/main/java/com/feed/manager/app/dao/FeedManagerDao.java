package com.feed.manager.app.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.feed.manager.app.dao.model.FeedItem;

@Repository
public interface FeedManagerDao extends PagingAndSortingRepository<FeedItem, Long> {

	public Page<FeedItem> findAll(Pageable pageable);
}
