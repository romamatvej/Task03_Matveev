package by.htp.jd2.matveev.bean;

import javax.xml.bind.annotation.*;
import java.util.*;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class NewsFeed {
	@XmlElement(name = "news")
	private ArrayList<News> newsCatalog = new ArrayList<News>();;

	public void updateWithNews(News news) {
		newsCatalog.add(news);
	}
	@Override
	public String toString(){
		StringBuffer newsFeed = new StringBuffer("News Feed:");
		for(News news:newsCatalog) {
		newsFeed.append('\n' + news.toString());	
		}
		return newsFeed.toString();
		}
	
	public ArrayList <News> getNewsCatalog() {
		return newsCatalog;
	}
	
}
