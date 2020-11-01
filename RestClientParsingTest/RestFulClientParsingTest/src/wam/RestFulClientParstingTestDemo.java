package wam;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class RestFulClientParstingTestDemo {

	public static void main(String[] args) {

		try {

			File file = new File(
					"C:\\Users\\manisx\\Documents\\Technical\\Java\\Examples\\RestClientParsingTest\\RestFulClientParsingTest\\response.xml");

			JAXBContext jaxbContext = JAXBContext.newInstance(Feed.class);

			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			Feed feed = (Feed) jaxbUnmarshaller.unmarshal(file);
			System.out.println(feed.getEntry().toString());
			System.out.println("\n");

			Marshaller marshaller = jaxbContext.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.marshal(feed, System.out);

		} catch (JAXBException e) {
			e.printStackTrace();
		}

	}

}