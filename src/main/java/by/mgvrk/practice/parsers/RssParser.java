package by.mgvrk.practice.parsers;

import by.mgvrk.practice.model.Feed;
import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.fetcher.impl.FeedFetcherCache;
import com.sun.syndication.fetcher.impl.HashMapFeedInfoCache;
import com.sun.syndication.fetcher.impl.SyndFeedInfo;
import com.sun.syndication.io.FeedException;
import com.sun.syndication.io.SyndFeedInput;
import com.sun.syndication.io.XmlReader;

import java.io.IOException;
import java.net.URL;
import java.util.Date;

/**
 * User: sharitonchik
 */
public class RssParser {
    private FeedFetcherCache cache;

    public RssParser() {
        cache = HashMapFeedInfoCache.getInstance();
    }

    public SyndFeed getSyndFeed(Feed feed) throws IOException, FeedException {
        URL syndFeedUrl = new URL(feed.getUrl());
        SyndFeedInfo syndFeedInfo;

        if (cache.getFeedInfo(syndFeedUrl) == null) {
            syndFeedInfo = createSyndFeedInfo(syndFeedUrl);
        } else {
            Date date = new Date();

            syndFeedInfo = getSyndFeedInfoFromCache(syndFeedUrl);
            if ((date.getTime() / 60000 - (Long) syndFeedInfo.getLastModified()) >= (feed.getInterval())) {
                syndFeedInfo = createSyndFeedInfo(syndFeedUrl);
            }
        }

        return syndFeedInfo.getSyndFeed();
    }

    private SyndFeedInfo createSyndFeedInfo(URL url) throws IOException, FeedException {
        SyndFeedInfo syndFeedInfo = new SyndFeedInfo();
        Date date = new Date();

        syndFeedInfo.setSyndFeed(new SyndFeedInput().build(new XmlReader(url)));
        syndFeedInfo.setUrl(url);
        syndFeedInfo.setLastModified(date.getTime() / 60000);

        cache.setFeedInfo(url, syndFeedInfo);

        return syndFeedInfo;
    }

    private SyndFeedInfo getSyndFeedInfoFromCache(URL url) {
        return cache.getFeedInfo(url);
    }
}
