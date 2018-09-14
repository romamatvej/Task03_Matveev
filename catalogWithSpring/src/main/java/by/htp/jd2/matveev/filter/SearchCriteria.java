package by.htp.jd2.matveev.filter;

import java.util.Calendar;

public class SearchCriteria {

	private String name;
	private String author;
	private Calendar dateOfIssue;
	private String newsBody;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Calendar getDateOfIssue() {
		return dateOfIssue;
	}

	public void setDateOfIssue(Calendar dateOfIssue) {
		this.dateOfIssue = dateOfIssue;
	}

	public String getNewsBody() {
		return newsBody;
	}

	public void setNewsBody(String newsBody) {
		this.newsBody = newsBody;
	}
}
