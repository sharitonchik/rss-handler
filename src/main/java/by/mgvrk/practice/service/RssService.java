package by.mgvrk.practice.service;

import by.mgvrk.practice.model.Feed;
import by.mgvrk.practice.model.Provider;
import by.mgvrk.practice.model.Providers;
import by.mgvrk.practice.parsers.RssParser;
import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.io.FeedException;

import java.io.IOException;

/**
 * User: sharitonchik
 */
public class RssService {
    Providers providers = Providers.getInstance();

    public SyndFeed getSyndFeed(String feedUri) {
        SyndFeed syndFeed = null;
        Feed feed = getFeed(feedUri);
        RssParser parser = new RssParser();

        try {
            syndFeed =  parser.getSyndFeed(feed);
        } catch (IOException e) {
            e.printStackTrace(System.out);
        } catch (FeedException e) {
            e.printStackTrace(System.out);
        }

        return syndFeed;
    }

    private Feed getFeed(String uri) {
        Feed feed = null;

        for (Provider provider : providers.getProviders()) {
            for (Feed feedFromList : provider.getFeeds()) {
                if (feedFromList.getUri().equals(uri)) {
                    feed = feedFromList;
                }
            }
        }

        return feed;
    }
}
