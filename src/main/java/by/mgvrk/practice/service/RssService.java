package by.mgvrk.practice.service;

import by.mgvrk.practice.model.Feed;
import by.mgvrk.practice.model.Provider;
import by.mgvrk.practice.model.Providers;
import by.mgvrk.practice.parsers.RssParser;
import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.io.FeedException;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * User: sharitonchik
 */
public class RssService {
    Providers providers = Providers.getInstance();

    public SyndFeed getSyndFeed(String feedUri) {
        SyndFeed feed = null;
        String sourceUrl = getSourceUrl(feedUri);
        RssParser parser = new RssParser();

        try {
            feed = parser.getFeed(sourceUrl);
        } catch (IOException e) {
            e.printStackTrace(System.out);
        } catch (FeedException e) {
            e.printStackTrace(System.out);
        }

        return feed;
    }

    private String getSourceUrl(String uri) {
        String url = null;

        for (Provider provider : providers.getProviders()) {
            for (Feed feed : provider.getFeeds()) {
                if (feed.getUri().equals(uri)) {
                    url = feed.getUrl();
                }
            }
        }

        return url;
    }
}
