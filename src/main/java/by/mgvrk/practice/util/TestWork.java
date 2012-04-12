package by.mgvrk.practice.util;

import by.mgvrk.practice.model.Providers;
import by.mgvrk.practice.parsers.RssParser;
import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.fetcher.impl.SyndFeedInfo;
import com.sun.syndication.io.FeedException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * User: sharitonchik
 */
public class TestWork {
    public static void main(String[] args) {
        System.out.println((Providers
                .getInstance()
                .getProviders()
                .get(0)
                .getFeeds()
                .get(5)
                .getUri()));
    }
}
