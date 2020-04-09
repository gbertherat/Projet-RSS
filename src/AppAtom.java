import com.sun.syndication.feed.synd.SyndCategoryImpl;
import com.sun.syndication.feed.synd.SyndContentImpl;
import com.sun.syndication.feed.synd.SyndEntry;
import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.feed.synd.SyndLinkImpl;
import com.sun.syndication.io.SyndFeedInput;
import com.sun.syndication.io.XmlReader;

import java.net.URL;
import java.util.List;

public class AppAtom {
    @SuppressWarnings("unchecked")
	public static void main(String[] args) throws Exception {
        String url = "https://www.sciencedaily.com/rss/all.xml";
        //http://www.france24.com/fr/actualites/rss
        //http://rss.cnn.com/rss/cnn_topstories.rss
        //https://www.journaldugeek.com/rss        
        
        URL feedUrl = new URL(url);
        SyndFeedInput input = new SyndFeedInput();
        SyndFeed feed = input.build(new XmlReader(feedUrl));
        
        System.out.println("Feed Title: " + feed.getTitle());
        
        // Get the entry items...
        for (SyndEntry entry : (List<SyndEntry>) feed.getEntries()) {
            System.out.println("Title: " + entry.getTitle());
            System.out.println("Published date: " + entry.getPublishedDate());
            System.out.println("Description: " + entry.getDescription().getValue());
            
            // Get the Contents
            for (SyndContentImpl content : (List<SyndContentImpl>) entry.getContents()) {
                System.out.println("Content: " + content.getValue());
            }
            
            // Get the Categories
            for (SyndCategoryImpl category : (List<SyndCategoryImpl>) entry.getCategories()) {
                System.out.println("Category: " + category.getName());
            }
        }
    
    }
}
