package by.mgvrk.practice.parsers;

import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.io.FeedException;
import com.sun.syndication.io.SyndFeedInput;
import com.sun.syndication.io.XmlReader;

import java.io.IOException;
import java.net.URL;

/**
 * User: sharitonchik
 */
public class RssParser {
    public SyndFeed getFeed(String url) throws IOException, FeedException {
        return new SyndFeedInput().build(new XmlReader(new URL(url)));
    }
}
