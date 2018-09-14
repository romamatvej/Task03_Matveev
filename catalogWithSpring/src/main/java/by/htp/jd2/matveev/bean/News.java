package by.htp.jd2.matveev.bean;

import javax.xml.bind.annotation.*;
import java.util.Calendar;
import java.util.GregorianCalendar;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class News {
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

	public void setDateOfIssue(int year, int month, int day) {

		this.dateOfIssue = new GregorianCalendar(year, month, day);
	}

	public String getNewsBody() {
		return newsBody;
	}

	public void setNewsBody(String newsBody) {
		this.newsBody = newsBody;
	}

	@Override
	public String toString() {
		return name + "; " + author + "; " + dateOfIssue.get(Calendar.YEAR) + "." + dateOfIssue.get(Calendar.MONTH)
				+ "." + dateOfIssue.get(Calendar.DATE) + ".; " + newsBody;

	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (this.getClass() != obj.getClass()) {
			return false;
		}
		News news = (News) obj;
		if (this.name == null) {
			if (news.name != null) {
				return false;
			} else {
				if (this.name.equals(news.name)) {
					return false;
				}
			}
		}

		return true;
	}

	@Override
	public int hashCode() {
		int result = 17;
		result = 31 * name.hashCode() + author.hashCode() + dateOfIssue.hashCode() + newsBody.hashCode();
		return result;
	}
}