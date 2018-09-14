package by.htp.jd2.matveev.DAO;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import by.htp.jd2.matveev.bean.*;

public class NewsUpdaterJAXB implements NewsUpdater {

	private String fileForeSendOut = "H:\\newsFeed.xml";
	private String fileForeReceive = "H:\\newsFeed.xml";
	private NewsFeed recievedNewsFeed;

	public NewsFeed getRecievedNewsFeed() {
		return recievedNewsFeed;
	}

	public void sendOut(NewsFeed newsFeed) throws JAXBException {
		JAXBContext context = JAXBContext.newInstance(NewsFeed.class);
		Marshaller jaxbMarshaller = context.createMarshaller();
		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		jaxbMarshaller.marshal(newsFeed, new File(fileForeSendOut));
	}

	public void receive() throws JAXBException {
		File file = new File(fileForeReceive);
		JAXBContext context = JAXBContext.newInstance(NewsFeed.class);

		Unmarshaller jaxbUnmarshaller = context.createUnmarshaller();
		recievedNewsFeed = (NewsFeed) jaxbUnmarshaller.unmarshal(file);

		// System.out.println("in recieve: " + recievedNewsFeed);
	}

}