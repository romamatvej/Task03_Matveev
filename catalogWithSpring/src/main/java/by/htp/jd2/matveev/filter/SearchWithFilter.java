package by.htp.jd2.matveev.filter;

import java.util.*;
import by.htp.jd2.matveev.bean.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SearchWithFilter {
	private SearchCriteria filter;
	NewsFeed incomingNewsFeed;
	private ArrayList<News> newsCatalogToFilter;
	private NewsFeed filteredNewsFeed;

	public SearchWithFilter(NewsFeed incomingNewsFeed, SearchCriteria filter) {
		this.incomingNewsFeed = incomingNewsFeed;
		this.filter = filter;
	}

	public NewsFeed executeFilter() {
		ApplicationContext context = (ApplicationContext) new ClassPathXmlApplicationContext ("beans.xml");
		filteredNewsFeed = (NewsFeed) context.getBean("filteredNewsFeed");
		//filteredNewsFeed = new NewsFeed();
		newsCatalogToFilter = incomingNewsFeed.getNewsCatalog();
		Iterator<News> iterator = newsCatalogToFilter.iterator();
		while (iterator.hasNext()) {
			News news = iterator.next();
			if (filter.getName() == null || filter.getName().equals(news.getName())) {
				if (filter.getAuthor() == null || filter.getAuthor().equals(news.getAuthor())) {
					if (filter.getDateOfIssue() == null || filter.getDateOfIssue().equals(news.getDateOfIssue())) {
						filteredNewsFeed.updateWithNews(news);
					}
				}
			}
		}

		return filteredNewsFeed;
	}

}
