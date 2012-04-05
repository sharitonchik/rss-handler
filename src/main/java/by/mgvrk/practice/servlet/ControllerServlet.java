package by.mgvrk.practice.servlet;

import by.mgvrk.practice.service.RssService;
import com.sun.syndication.io.FeedException;
import com.sun.syndication.io.SyndFeedOutput;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * User: sharitonchik
 */
public class ControllerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RssService rssService = new RssService();
        SyndFeedOutput out = new SyndFeedOutput();
        resp.setContentType("text/xml; charset=utf-8");

        try {
            out.output(rssService.getSyndFeed(req.getParameter("news")), resp.getWriter());
        } catch (FeedException e) {
            e.printStackTrace(System.out);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
