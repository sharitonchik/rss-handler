package by.mgvrk.practice.model;

import by.mgvrk.practice.parsers.ProvidersBuilder;

import java.util.List;

/**
 * User: sharitonchik
 */
public class Providers {
    private List<Provider> providers;
    private static final Providers instance = new Providers();

    private Providers() {
        ProvidersBuilder builder = new ProvidersBuilder();
        providers = builder.getProviders("config/config.xml");
    }

    public static Providers getInstance() {
        return instance;
    }

    public List<Provider> getProviders() {
        return providers;
    }
}
