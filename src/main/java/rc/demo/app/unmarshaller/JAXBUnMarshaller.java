package rc.demo.app.unmarshaller;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.eclipse.persistence.jaxb.UnmarshallerProperties;

import java.io.StringReader;

public class JAXBUnMarshaller<T> {

	@SuppressWarnings("unchecked")
	public T unMarshall(String jsonString, Class<T> type) throws JAXBException {
		JAXBContext jaxbContext = JAXBContext.newInstance(type);
		
		Unmarshaller jaxbUnMarshaller = jaxbContext.createUnmarshaller();
		jaxbUnMarshaller.setProperty(UnmarshallerProperties.MEDIA_TYPE, "application/json");
		jaxbUnMarshaller.setProperty(UnmarshallerProperties.JSON_INCLUDE_ROOT, true);

		return (T)jaxbUnMarshaller.unmarshal(new StringReader(jsonString));
	}
}
