package by.mgvrk.practice.parsers;

import by.mgvrk.practice.model.Feed;
import by.mgvrk.practice.model.Provider;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * User: sharitonchik
 */
public class ProvidersBuilder {
    private Document dom;
    private List<Provider> providersList = new ArrayList<Provider>();
    private final String TEXT_TAG = "#text";
    private final String PROVIDERS = "providers";
    private final String ACTIVE = "active";
    private final String SOURCE_URL = "sourceurl";
    private final String PUBLISH_URL = "publishuri";
    private final String DESCRIPTION = "description";
    private final String INTERVAL_RESTRICTION = "intervalrestriction";

    public List<Provider> getProviders(String fileName) {
        InputStream stream = null;
        try {
            stream = this.getClass().getClassLoader().getResourceAsStream(fileName);
            buildDom(stream);
            parseDocument();
        } finally {
            if (stream != null) {
                try {
                    stream.close();
                } catch (IOException e) {
                    //quietly
                }
            }
        }
        return providersList;
    }

    private void buildDom(InputStream stream) {
        try {
            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = builderFactory.newDocumentBuilder();
            dom = builder.parse(stream);
        } catch (ParserConfigurationException e) {
            e.printStackTrace(System.out);
        } catch (SAXException e) {
            e.printStackTrace(System.out);
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }
    }

    private void parseDocument() {
        Element root = dom.getDocumentElement();

        NodeList children = root.getChildNodes();

        for (int i = 0; i < children.getLength(); i++) {
            Node child = children.item(i);

            if (child.getNodeName().equals(PROVIDERS)) {
                parseProviders(child.getChildNodes());
            }
        }
    }

    private void parseProviders(NodeList providers) {
        for (int i = 0; i < providers.getLength(); i++) {
            if (!providers.item(i).getNodeName().equals(TEXT_TAG)) {
                providersList.add(getProvider(providers.item(i)));

            }
        }
    }

    private Provider getProvider(Node item) {
        Provider provider = new Provider();

        provider.setFeeds(parseFeeds(item.getChildNodes()));
        return provider;
    }

    private List<Feed> parseFeeds(NodeList feeds) {
        List<Feed> feedsList = new ArrayList<Feed>();

        for (int i = 0; i < feeds.getLength(); i++) {
            if (!feeds.item(i).getNodeName().equals(TEXT_TAG)) {
                feedsList.add(getFeed(feeds.item(i)));
            }
        }

        return feedsList;
    }

    private Feed getFeed(Node feedNode) {
        NodeList feedConfig = feedNode.getChildNodes();
        Feed feed = new Feed();

        for (int i = 0; i < feedConfig.getLength(); i++) {
            if (!feedConfig.item(i).getNodeName().equals(TEXT_TAG)) {
                if (feedConfig.item(i).getNodeName().equals(ACTIVE)) {
                    feed.setActive(feedConfig.item(i).getFirstChild().getNodeValue());
                }

                if (feedConfig.item(i).getNodeName().equals(SOURCE_URL)) {
                    feed.setUrl(feedConfig.item(i).getFirstChild().getNodeValue());
                }

                if (feedConfig.item(i).getNodeName().equals(PUBLISH_URL)) {
                    feed.setUri(feedConfig.item(i).getFirstChild().getNodeValue());
                }

                if (feedConfig.item(i).getNodeName().equals(DESCRIPTION)) {
                    feed.setDescription(feedConfig.item(i).getFirstChild().getNodeValue());
                }

                if (feedConfig.item(i).getNodeName().equals(INTERVAL_RESTRICTION)) {
                    feed.setInterval(feedConfig.item(i).getFirstChild().getNodeValue());
                }
            }
        }
        return feed;
    }
}
