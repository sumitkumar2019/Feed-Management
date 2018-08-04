package com.feed.manager.app;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(locations = "classpath*:/feed/integration.xml")
public class FeedManagementApplicationTests {

    @Test
    public void contextLoads() {
    }

}
