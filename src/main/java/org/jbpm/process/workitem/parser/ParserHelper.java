package org.jbpm.process.workitem.parser;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXB;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ParserHelper {

	private ParserHelper() {
	}

	public static Object convertXMLToObject(String input, Class<?> type) {
		return JAXB.unmarshal(new StringReader(input), type);
	}

	public static String convertToXML(Object input) throws JAXBException {
		StringWriter result = new StringWriter();	
		JAXBContext jaxbContext = JAXBContext.newInstance(input.getClass());
		Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, false);
		jaxbMarshaller.marshal(input, result);
		return result.toString();
	}
	
	public static Object convertJSONToObject(String input, Class<?> type) throws JsonParseException, JsonMappingException, IOException {		
		return new ObjectMapper().readValue(input, type);
	}

	public static Object convertToJSON(Object input) throws JsonProcessingException {
		return new ObjectMapper().writeValueAsString(input);
	}

}
