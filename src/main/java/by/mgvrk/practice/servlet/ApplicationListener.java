package by.mgvrk.practice.servlet;

import by.mgvrk.practice.model.Providers;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * User: sharitonchik
 */
public class ApplicationListener implements ServletContextListener {

    public void contextInitialized(ServletContextEvent sce) {
        Providers providers = Providers.getInstance();
    }

    public void contextDestroyed(ServletContextEvent sce) {

    }
}
