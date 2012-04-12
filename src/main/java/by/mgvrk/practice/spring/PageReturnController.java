package by.mgvrk.practice.spring;

import by.mgvrk.practice.access.ResourcesReturner;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * User: sharitonchik
 */
@Controller
public class PageReturnController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getIndex() {
        return "index";
    }

    @RequestMapping(value = "/javascripts/*", method = RequestMethod.GET)
    @ResponseBody
    public String getJS(HttpServletRequest req) {
        ResourcesReturner fileString = new ResourcesReturner();
        return fileString.getResource(req.getRequestURI());
    }
}
