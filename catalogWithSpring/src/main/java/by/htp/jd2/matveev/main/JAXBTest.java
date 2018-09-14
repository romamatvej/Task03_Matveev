package by.htp.jd2.matveev.main;

import java.io.File;
import java.util.Calendar;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import by.htp.jd2.matveev.bean.*;
import by.htp.jd2.matveev.filter.*;
import by.htp.jd2.matveev.DAO.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JAXBTest {

	public static void main(String[] args) throws JAXBException {
		
		ApplicationContext context = (ApplicationContext) new ClassPathXmlApplicationContext("Beans.xml");
		
		News news1 = (News) context.getBean("news1");
		//News news1 = new News();
		news1.setName("name1");
		news1.setAuthor("author1");
		news1.setDateOfIssue(2018, 2, 5);
		news1.setNewsBody("newsBody1");

		News news2 = (News) context.getBean("news2");
		//News news2 = new News();
		news2.setName("name2");
		news2.setAuthor("author2");
		news2.setDateOfIssue(2018, 2, 7);
		news2.setNewsBody("newsBody2");

		NewsFeed newsFeedOutgoing = (NewsFeed) context.getBean("newsFeedOutgoing");
		//NewsFeed newsFeedOutgoing = new NewsFeed();
		newsFeedOutgoing.updateWithNews(news1);
		newsFeedOutgoing.updateWithNews(news2);

		NewsUpdaterJAXB newsUpdater = (NewsUpdaterJAXB) context.getBean("newsUpdater");
		//NewsUpdaterJAXB newsUpdater = new NewsUpdaterJAXB();
		newsUpdater.sendOut(newsFeedOutgoing);
		
		SearchCriteria filterMask = (SearchCriteria) context.getBean("filterMask");
		//SearchCriteria filterMask = new SearchCriteria();
		filterMask.setName("name1");
		newsUpdater.receive();
		NewsFeed newsFeedToFilter = (NewsFeed) newsUpdater.getRecievedNewsFeed();
		
		System.out.println("Sending NewsFeed to fiter: \n" + newsFeedToFilter);
		SearchWithFilter searchRequest = new SearchWithFilter(newsFeedToFilter, filterMask);
		NewsFeed filteredNewsFeed = searchRequest.executeFilter();
		System.out.println("After filter: \n" + filteredNewsFeed);
		// newsUpdater.receive();

	}

}
