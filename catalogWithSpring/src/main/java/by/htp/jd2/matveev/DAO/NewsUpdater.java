package by.htp.jd2.matveev.DAO;

import javax.xml.bind.JAXBException;

import by.htp.jd2.matveev.bean.*;

public interface NewsUpdater {
	
		
	public void sendOut(NewsFeed newsFeed) throws JAXBException;
	public void receive() throws JAXBException;

}
