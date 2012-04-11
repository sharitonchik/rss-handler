package by.mgvrk.practice.spring;

import by.mgvrk.practice.service.RssService;
import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.io.FeedException;
import com.sun.syndication.io.SyndFeedOutput;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * User: sharitonchik
 */
@Controller
@RequestMapping("/rss")
public class NewsController {

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public void getHandler(@RequestParam("news") String news, HttpServletResponse resp) {
        RssService rssService = new RssService();
        SyndFeedOutput out = new SyndFeedOutput();
        SyndFeed feeds = rssService.getSyndFeed(news);

        resp.setContentType("application/rss+xml; charset=utf-8");

        try {
            out.output(feeds, resp.getWriter());
        } catch (FeedException e) {
            e.printStackTrace(System.out);
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }

    }

}
